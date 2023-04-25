import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class HelloWorldJava {




    @Test
    void test3() {


        List<LocalDate> tradingDays = List.of(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 2),
                LocalDate.of(2022, 1, 3),
                LocalDate.of(2022, 1, 4),
                LocalDate.of(2022, 1, 5),
                LocalDate.of(2022, 1, 6),
                LocalDate.of(2022, 1, 7),
                LocalDate.of(2022, 1, 8),
                LocalDate.of(2022, 1, 9),
                LocalDate.of(2022, 1, 10),
                LocalDate.of(2022, 1, 11)
        );

        List<LocalDate> intervalDays = List.of(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 5),
                LocalDate.of(2022, 1, 10)
        );

        Map<Integer, List<LocalDate>> result = buildTradingDateMap(tradingDays, intervalDays);


    }


    private Map<Integer, List<LocalDate>> buildTradingDateMap(List<LocalDate> allTradingDates, List<LocalDate> intervalDates) {
        Map<Integer, List<LocalDate>> result = new HashMap<>(intervalDates.size());
        for (int i = 0; i < intervalDates.size(); i++) {
            LocalDate currentIntervalDate = intervalDates.get(i);
            if (i + 1 == intervalDates.size()) {
                int from = allTradingDates.indexOf(currentIntervalDate);
                List<LocalDate> tradingDays = allTradingDates.subList(from,allTradingDates.size());

                result.put(i, tradingDays);
                break;
            }

            LocalDate nextIntervalDate = intervalDates.get(i + 1);
            int from = allTradingDates.indexOf(currentIntervalDate);
            int to = allTradingDates.indexOf(nextIntervalDate);
            List<LocalDate> tradingDates = allTradingDates.subList(from, to);

            result.put(i, tradingDates);

        }
        return result;
    }

    @Test
    void test2() {


        List<LocalDate> dates = List.of(
                LocalDate.of(2022, 2, 1),
                LocalDate.of(2022, 2, 3),
                LocalDate.of(2022, 2, 2),
                LocalDate.of(2022, 2, 4)
        );
        List<LocalDate> sortDates = dates.stream().sorted(LocalDate::compareTo).collect(Collectors.toList());
        System.out.println(sortDates.toString());


    }

    @Test
    void test() {

        Map<String, Integer> map = IntStream.range(0, 1000).boxed().collect(Collectors.toMap(Object::toString, Integer::intValue));

        List<List<TestBox>> result = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            List<TestBox> collect;
            if (i < 50) {
                collect = map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(en -> new TestBox(en.getKey(), en.getValue()))
                        .collect(Collectors.toList());
            } else {
                collect = map.entrySet().stream()
                        .map(en -> new TestBox(en.getKey(), en.getValue()))
                        .collect(Collectors.toList());
            }

            result.add(collect);
        }


        for (int i = 0; i < 99; i++) {
            List<TestBox> cur = result.get(i);
            for (int j = i + 1; j < 100; j++) {
                List<TestBox> next = result.get(j);
                for (int k = 0; k < 1000; k++) {
                    Assertions.assertEquals(cur.get(j), next.get(j));
                }
            }

        }

    }


    @AllArgsConstructor
    @EqualsAndHashCode
    private class TestBox {
        String a;
        Integer b;
    }


}
