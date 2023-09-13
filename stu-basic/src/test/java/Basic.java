import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basic {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>(10);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num == 0) {
                break;
            }
            nums.add(num);
        }
        for (Integer num : nums) {
            System.out.println(solve(num));
        }
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
