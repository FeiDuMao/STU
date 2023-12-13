import com.tyy.stu.obj.TreeNode;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Test1 {


    @SneakyThrows
    @Test
    public void test() {
        System.out.println(maxDepth(TreeNode.getSimpleNode(), 0));
    }


    public boolean checkIfPangram(String sentence) {

        Set<Character> characters = new HashSet<>(26);
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                characters.add(ch);
            }
        }

        return characters.size() == 26;
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


    public int maxDepth(TreeNode root) {
        TreeNode simpleNode = TreeNode.getSimpleNode();

        return maxDepth(simpleNode, 1);
    }


    public int maxDepth(TreeNode root, Integer depth) {
        int a = depth, b = depth;
        if (root.getLeft() != null) a = maxDepth(root.getLeft(), ++depth);
        if (root.getRight() != null) b = maxDepth(root.getRight(), ++depth);
        return Math.max(a, b);

    }


}
