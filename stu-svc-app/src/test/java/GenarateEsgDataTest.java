import com.google.common.collect.Lists;
import com.tyy.TApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@SpringBootTest(classes = {TApplication.class})
@ActiveProfiles("new-bar-demo1")
class GenarateEsgDataTest {


    @Autowired
    @Qualifier("db_new_bar")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void test() {

        List<LocalDate> dates = List.of(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 3, 3),
                LocalDate.of(2022, 5, 5),
                LocalDate.of(2022, 8, 8),
                LocalDate.of(2022, 10, 10),
                LocalDate.of(2022, 12, 12)
        );

        List<Map<String, Object>> allData = dates.parallelStream()
                .flatMap(date -> Stream.of(
                        buildDataMSCI(date),
                        buildDataSRLD(date)
                )).flatMap(Collection::stream)
                .collect(Collectors.toList());


        Lists.partition(allData, 2000).parallelStream().forEach(data -> {

            MapSqlParameterSource[] mapSqlParameterSources = data.stream()
                    .map(MapSqlParameterSource::new)
                    .toList()
                    .toArray(new MapSqlParameterSource[data.size()]);

            log.info("start to update data , size = {}", mapSqlParameterSources.length);
            jdbcTemplate.batchUpdate(
                    "insert into esg_score_stock(report_date, stock_code, esg_organization_id, total_score, rating, environment, social, governance, creator)" +
                            " values (:report_date,:stock_code,:esg_organization_id,:total_score,:rating,:environment,:social,:governance,:creator) " +
                            "on duplicate key update report_date =values(report_date), stock_code = values(stock_code) ",
                    mapSqlParameterSources);
        });

    }


    private List<Map<String, Object>> buildDataMSCI(LocalDate date) {

        String orgId = "cb3dbc34-8c9f-e87a-602d-9128a5f91a8d";
        String userId = "c849a465-f951-40d8-ad3b-a76c1f9edf4b";
        List<String> stockCodes = jdbcTemplate.query("select code from stock_basic_info", (row, index) -> row.getString(1));
        Random random = new Random();

        log.info("start genarate msci data at {}", date);
        return stockCodes.parallelStream().map(stockCode -> {

            double score1 = random.nextDouble(0, 10);
            double score2 = random.nextDouble(0, 10);
            double score3 = random.nextDouble(0, 10);

            double total = (score1 + score2 + score3) / 3;
            String rating = getRatingMSCI(total);
            return Map.<String, Object>of(
                    "report_date", date,
                    "stock_code", stockCode,
                    "esg_organization_id", orgId,
                    "total_score", total,
                    "rating", rating,
                    "environment", score1,
                    "social", score2,
                    "governance", score3,
                    "creator", userId
            );
        }).toList();
    }

    private List<Map<String, Object>> buildDataSRLD(LocalDate date) {

        String orgId = "69316c5d-c8eb-46ce-a757-cb56f9f96ffa";
        String userId = "c849a465-f951-40d8-ad3b-a76c1f9edf4b";
        List<String> stockCodes = jdbcTemplate.query("select code from stock_basic_info", (row, index) -> row.getString(1));
        Random random = new Random();

        log.info("start genarate SRLD data at {}", date);
        return stockCodes.parallelStream().map(stockCode -> {

            double score1 = random.nextDouble(0, 100);
            double score2 = random.nextDouble(0, 100);
            double score3 = random.nextDouble(0, 100);

            double total = (score1 + score2 + score3) / 3;
            String rating = getRatingSRLD(total);
            return Map.<String, Object>of(
                    "report_date", date,
                    "stock_code", stockCode,
                    "esg_organization_id", orgId,
                    "total_score", total,
                    "rating", rating,
                    "environment", score1,
                    "social", score2,
                    "governance", score3,
                    "creator", userId
            );
        }).toList();
    }


    private String getRatingSRLD(double total) {
        if (total >= 90) return "A+";
        if (total >= 80) return "A";
        if (total >= 70) return "A-";
        if (total >= 60) return "B+";
        if (total >= 50) return "B";
        if (total >= 40) return "B-";
        if (total >= 30) return "C+";
        if (total >= 20) return "C";
        if (total >= 10) return "C-";
        return "D";
    }

    private String getRatingMSCI(double total) {
        if (total > 8.571) return "AAA";
        if (total > 7.143) return "AA";
        if (total > 5.714) return "A";
        if (total > 4.286) return "BBB";
        if (total > 2.857) return "BB";
        if (total > 1.429) return "B";
        return "CCC";
    }


}
