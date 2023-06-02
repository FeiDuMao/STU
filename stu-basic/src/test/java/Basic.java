import com.tyy.stu.inherit.ClassB;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Basic {


    @Test
    public void test() {
        LocalDate date = LocalDate.ofEpochDay(7677);
        System.out.printf(date.toString());
    }


    @Test
    public void test2() {

        ClassB classB = new ClassB(1, 2);
        classB.step1();


    }
}
