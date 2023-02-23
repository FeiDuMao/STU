import com.tyy.TApplication;
import com.tyy.stu.adapter.UserInfoJpaAdapter;
import com.tyy.stu.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest(classes = {TApplication.class})
@ActiveProfiles("local")
class SpringBootIntegrationTest {

    @Autowired
    private UserInfoJpaAdapter jpaAdapter;

    @Autowired
    @Qualifier("db_study")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void test() {
        Optional<UserInfo> tyy = jpaAdapter.queryByUserName("tyy");
        log.info("tyy is {}", tyy.isPresent());
    }


    @Test
    void test2() {
        String sql = "select * from user_info";
        List<UserInfo> result = jdbcTemplate.query(sql, (rs, idx) -> {
            String userName = rs.getString(1);
            return UserInfo.builder()
                    .userName(userName)
                    .build();
        });

        log.info("user info is {} ", result);
    }


}
