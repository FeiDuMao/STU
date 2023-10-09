import com.tyy.stu.utils.TExecutor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test1 {


    private String getStr(String str) {

        // abcdebfgh

        int i = 0, j = 0;

        int start = 0;
        int maxLen = 0;


        // 每个char 对应的前一次出现的坐标
        Map<Character, Integer> map = new HashMap<>(str.length());

        while (j < str.length()) {
            char jChar = str.charAt(j);

            if (map.containsKey(jChar)) {
                int len = j - i;
                if (len > maxLen) {
                    start = i;
                    maxLen = len;
                }
                i = map.get(jChar) + 1;
                map.put(jChar, j);
            } else {
                map.put(jChar, j);
            }
            j++;

        }

        if (j - i > maxLen) {
            start = i;
            maxLen = j - i;
        }


        return str.substring(start, start + maxLen);
    }


    @Test
    public void test() {

        BigDecimal decimal =new BigDecimal(1);





        System.out.println(getStr("abcdebfgh"));
        System.out.println(getStr("abcdebfgh"));


    }


}
