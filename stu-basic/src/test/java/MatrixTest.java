import org.apache.commons.math3.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixTest {


    @Test
    public void test() {


        List<String> strings = List.of("1", "2", "3");
        Double[][] matrix = new Double[][]{
                {1.0, 0.1, 0.2},
                {Double.NaN, 1.0, 0.3},
                {Double.NaN, Double.NaN, 1.0},
        };


        List<Pair<String, Double>> pairs = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i ; j < strings.size(); j++) {
                String s = strings.get(i) + strings.get(j);
                pairs.add(new Pair<>(s, matrix[i][j]));
            }
        }

        System.out.println(pairs.size());

    }
}
