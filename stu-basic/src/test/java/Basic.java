import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Basic {


    @Test
    public void test() {

        Map<String, Map<String, Double>> tmp = new HashMap<>();
        Map<String, Double> t0 = new HashMap<>();
        Map<String, Double> t1 = new HashMap<>();
        tmp.put("0", t0);
        tmp.put("1", t1);

        tmp.get("0").put("00", 0.0d);


    }
}
