import java.util.Arrays;
import java.util.Scanner;

public class Basic5 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        Integer[] nums = Arrays.stream(str).map(Integer::valueOf).sorted().toArray(Integer[]::new);


        // 90 100 390 390 410


        int i = 0, j = nums.length - 1;
        int count = 0;

        while (i <= j) {
            if (i == j) {
                count++;
                break;
            }
            if (nums[i] + nums[j] <= 500) {
                j--;
                i++;
                count++;
            } else {
                j--;
                count++;
            }
        }
        System.out.println(count);


    }


}
