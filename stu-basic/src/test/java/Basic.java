import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Basic {


    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextDouble(20, 30));
        }
    }
}
