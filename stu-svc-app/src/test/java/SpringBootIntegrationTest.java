import com.tyy.TApplication;
import com.tyy.stu.adapter.UserInfoJpaAdapter;
import com.tyy.stu.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@Slf4j
@SpringBootTest(classes = {TApplication.class})
@ActiveProfiles("local")
class SpringBootIntegrationTest {

    @Autowired
    private UserInfoJpaAdapter jpaAdapter;


    @Test
    void test() {
        Optional<UserInfo> tyy = jpaAdapter.queryByUserName("tyy");
        log.info("tyy is {}", tyy.isPresent());
    }


}
