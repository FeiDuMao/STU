import com.tyy.stu.obj.TreeNode;
import com.tyy.stu.utils.TExecutor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class Basic {


    public static void main(String[] args) {


        ThreadPoolExecutor executor = TExecutor.getExecutor();
        executor.submit(null, null);
        executor.execute(null);


    }


    @Test
    public void test() {


        new ArrayList<>();
        new LinkedList<>();


        TreeNode simpleNode = TreeNode.getSimpleNode();
        visit2(simpleNode);

    }


    /**
     * 便利二叉树： 中左右
     *
     * @param node
     */
    public void visit1(TreeNode node) {
        if (node == null) return;
        System.out.println(node.getVal());

        if (node.getLeft() != null) visit1(node.getLeft());
        if (node.getRight() != null) visit1(node.getRight());


    }


    /**
     * 层次遍历二叉树
     *
     * @param node head
     */
    public void visit2(TreeNode node) {

        if (node == null) return;
        List<TreeNode> list = new ArrayList<>();
        list.add(node);

        while (!list.isEmpty()) {
            TreeNode head = list.remove(0);
            System.out.println(head.getVal());
            if (head.getLeft() != null) list.add(head.getLeft());
            if (head.getRight() != null) list.add(head.getRight());
        }
    }


}
