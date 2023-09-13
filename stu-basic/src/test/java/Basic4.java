import java.util.Arrays;
import java.util.Scanner;

public class Basic4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] str = in.nextLine().split(" ");

        Integer[] nums = Arrays.stream(str).map(Integer::valueOf).toArray(Integer[]::new);
        if (nums.length == 0) System.out.println("-1");


        //  1 2 3 4 5 6 7

        int start = nums[0];
        int min = -1;

        for (int i = 1; i < start + 1 && i < nums.length / 2; i++) {

            int step = 1; // 记录走了多少步
            int j = i;    // 表示当前下标
            int curNum;   // 表示当前位置的值

            while (true) {
                curNum = nums[j];
                step++;
                j += curNum;
                if (j > nums.length) break;
                if (j == nums.length ) {
                    if (min == -1) min = step;
                    else min = Math.min(step, min);
                    break;
                }
            }

        }

        System.out.println(min);


    }


}
