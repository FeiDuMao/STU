import org.junit.jupiter.api.Test;

import java.util.*;

public class Basic2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        Set<Integer>nums = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            nums.add(in.nextInt());
        }

        nums.stream().sorted().forEach(System.out::println);

    }


    @Test
    public void test() {


        System.out.println(solve(10));
        System.out.println(solve(3));
        System.out.println(solve(5));

    }


    private static int solve(int n) {

        int sum = 0;

        while (n >= 3) {
            int a = n / 3;
            int b = n % 3;

            sum += a;
            n = a + b;

        }
        return n == 2 ? ++sum : sum;
    }


}
