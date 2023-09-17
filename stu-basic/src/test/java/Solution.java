import org.junit.jupiter.api.Test;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class Solution {


    private void solve(int[] arr, int target) {


        int min = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];

            if (sum == target) {
                min = 1;
                break;
            }

            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum < target) continue;

                if (min == 0) min = j - i + 1;
                else min = Math.min(min, j - i + 1);
                break;
            }
        }

        System.out.println(min);

    }


    @Test
    public void test() {

        solve(new int[]{2,3,1,2,4,3},8);



    }


}
