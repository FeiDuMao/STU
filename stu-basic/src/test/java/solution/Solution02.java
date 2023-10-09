package solution;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution02 {


    @Test
    public void test() {
        int[][] arr = {
                {2, 4, 6, 8, 7, 9},
                {3, 8, 9, 1, 4, 5},
                {6, 9, 12, 2, 15, 11},
                {8, 7, 18, 7, 13, 2},
                {7, 2, 10, 4, 3, 7},
                {9, 5, 6, 17, 5, 1}
        };

        System.out.println(solve(arr));

    }


    private int solve(int[][] arr) {


        int[][] dp = new int[6][6];

        //动态规划：获取每个位置的最短路线
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = arr[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        //获取路径
        List<Pair> path = new ArrayList<>(11);
        path.add(new Pair(0, 0));
        int i = 0, j = 0;
        while (i < 5 || j < 5) {
            if (i == 5) {
                path.add(new Pair(i, ++j));
                continue;
            }
            if (j == 5) {
                path.add(new Pair(++i, j));
                continue;
            }

            if (dp[i + 1][j] < dp[i][j + 1]) {
                path.add(new Pair(++i, j));
            } else {
                path.add(new Pair(i, ++j));
            }


        }

        //输出结果
        Character[] characters = new Character[]{'A', 'B', 'C', 'D', 'E', 'F'};
        path.forEach(p -> {
            int y = p.getX() + 1;
            Character x = characters[p.getY()];
            System.out.println(x + "," + y);
        });

        return dp[5][5];
    }

    @AllArgsConstructor
    @Data
    class Pair {
        int x;
        int y;
    }


}
