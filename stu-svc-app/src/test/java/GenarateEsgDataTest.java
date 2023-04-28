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
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@SpringBootTest(classes = {TApplication.class})
@ActiveProfiles("new-bar-demo1")
class GenarateEsgDataTest {


    @Autowired
    @Qualifier("db_new_bar")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void test() {
        List<Map<String, Object>> data = buildData();

        MapSqlParameterSource[] mapSqlParameterSources = new MapSqlParameterSource[data.size()];

        data.stream().map(MapSqlParameterSource::new).toList().toArray(mapSqlParameterSources);

        jdbcTemplate.batchUpdate(
                "insert into esg_score_stock(report_date, stock_code, esg_organization_id, total_score, rating, environment, social, governance, creator)" +
                        " values (:report_date,:stock_code,:esg_organization_id,:total_score,:rating,:environment,:social,:governance,:creator)",
                mapSqlParameterSources);
        log.info("update success! size = {}", data.size());

    }


    private List<Map<String, Object>> buildData() {

        LocalDate date = LocalDate.of(2023, 4, 1);
        String orgId = "477aff7e-c922-4130-814d-f9b6434fd476";
        String userId = "c849a465-f951-40d8-ad3b-a76c1f9edf4b";
        List<String> stockCodes = jdbcTemplate.query("select code from stock_basic_info", (row, index) -> row.getString(1));
        Random random = new Random();


        return stockCodes.parallelStream().map(stockCode -> {

            double score1 = random.nextDouble(0, 100);
            double score2 = random.nextDouble(0, 100 - score1);
            double score3 = random.nextDouble(0, 100 - score1 - score2);

            double total = score1 + score2 + score3;
            String rating = getRating(total);
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

    private String getRating(double total) {
        if (total > 80) return "A";
        if (total > 60) return "B";
        if (total > 40) return "C";
        if (total > 20) return "D";
        return "E";
    }


}
