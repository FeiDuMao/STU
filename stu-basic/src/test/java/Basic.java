import com.tyy.stu.obj.TreeNode;
import com.tyy.stu.utils.TExecutor;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Basic {


    public static void main(String[] args) {


        ThreadPoolExecutor executor = TExecutor.getExecutor();
        executor.submit(null, null);
        executor.execute(null);


    }



    private String tryTest(){
        try {
            System.out.println("aaaaa");

            int i = 1 / 0;
            System.out.println("aaaaaaaaaaaaa");
            return "a";
        }catch (Exception e){
            System.out.println("bbbbb");
            return "b";
        }finally {
            System.out.println("ccccc");
//            return "c";
        }
    }


    @Test
    public void test() {

        System.out.println(tryTest());

    }

    @Test
    public void test2() {

        Integer a1 = 12;
        Integer a2 = Integer.valueOf(12);
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

    }


    /**
     * 遍历二叉树： 中左右
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
