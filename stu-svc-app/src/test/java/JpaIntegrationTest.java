import com.tyy.TApplication;
import com.tyy.stu.adapter.entity.Person;
import com.tyy.stu.adapter.jpa.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Slf4j
@SpringBootTest(classes = TApplication.class)
@ActiveProfiles("local")
class JpaIntegrationTest {


    @Autowired
    private PersonRepository repository;


    @Test
    void test() {
        List<Person> result = repository.findAll();

        log.info("result size = ", result.size());

    }

}
