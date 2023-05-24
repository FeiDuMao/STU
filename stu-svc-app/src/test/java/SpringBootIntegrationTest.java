import com.tyy.TApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest(classes = {TApplication.class})
@ActiveProfiles("local")
class SpringBootIntegrationTest {

//    @Autowired
//    private UserInfoJpaAdapter jpaAdapter;

    @Autowired
    @Qualifier("db_study")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void test() {
        Map<String, Object> data = Map.of(
                "stock_code", "tyy1",
                "comp_name", "1234",
                "industry", "as5d"
        );
        //会报错 ,但是能插入成功
        int updatedRows = jdbcTemplate.update(
                "insert into stock_industry(stock_code, comp_name, industry) " +
                        "VALUES (:stock_code,:comp_name,:industry) " +
                        "on duplicate key update stock_code=values(stock_code),comp_name=values(comp_name),industry=values(industry)",
                new MapSqlParameterSource(data),
                new GeneratedKeyHolder(List.of(data)),
                data.keySet().toArray(new String[]{})
        );
        System.out.println(updatedRows);
        List<String> result = jdbcTemplate.query(
                "select * from stock_industry where stock_code in (:stock_code)",
                Map.of("stock_code", List.of("000001", "tyy1")),
                (rs, inx) -> {
                    String col1 = rs.getString(1);
                    String col2 = rs.getString(2);
                    String col3 = rs.getString(3);
                    return col1;
                }
        );
        System.out.println(Arrays.toString(result.toArray()));
    }


    private void update(String tableName, Map<String, String> data) {
        String sql = "insert into " +
                tableName
                + "(" +
                data.keySet().toString()
                + ")"
                + "values(" +
                ""
                + ")";
    }


}
