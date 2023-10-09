import com.tyy.stu.obj.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class Solution2 {


    /**
     * str -> str
     * <p>
     * <p>
     * abcdd
     */


    private String solution(String str) {

        // abcdeff
        int maxLength = 0;
        int start = 0;


        int i = 0;
        while (i < str.length()) {
            Set<Character> characterSet = new HashSet<>();
            int j = i;

            for (; j < str.length(); j++) {
                if (characterSet.contains(str.charAt(j))) {
                    if (characterSet.size() > maxLength) {
                        maxLength = characterSet.size();
                        start = i;
                    }
                    i++;
                    break;
                } else {
                    characterSet.add(str.charAt(j));
                    if (j + 1 == str.length()) {
                        if (characterSet.size() > maxLength) {
                            maxLength = characterSet.size();
                            start = i;
                        }
                        break;
                    }
                }
            }
            if (j + 1 == str.length()) break;

        }


        return str.substring(start, start + maxLength);

    }


    @Test
    public void test() {


        TreeNode n9 = new TreeNode();
        TreeNode n8 = new TreeNode(null, n9);
        TreeNode n7 = new TreeNode();
        TreeNode n6 = new TreeNode();
        TreeNode n5 = new TreeNode(n7, n8);
        TreeNode n4 = new TreeNode(n6, null);
        TreeNode n3 = new TreeNode(null, null);
        TreeNode n2 = new TreeNode(n4, n5);
        TreeNode n1 = new TreeNode(n2, n3);


        System.out.println(maxLength(n1));


    }


    private int maxLength(TreeNode root) {
        int max = 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove(0);
            if (node.getLeft() != null) nodes.add(node.getLeft());
            if (node.getRight() != null) nodes.add(node.getRight());
            max = Math.max(singleMaxLength(node.getLeft(), 0) + singleMaxLength(node.getRight(), 0), max);
        }
        return max;

    }


    private int singleMaxLength(TreeNode root, Integer len) {
        if (root == null) return len;
        if (root.getRight() != null) return singleMaxLength(root.getRight(), ++len);
        if (root.getLeft() != null) return singleMaxLength(root.getLeft(), ++len);
        return len;

    }


}
