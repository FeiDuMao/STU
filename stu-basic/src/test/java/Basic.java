import org.junit.jupiter.api.Test;

import java.util.Random;

public class Basic {


    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextDouble(20,30));
        }
    }
}
