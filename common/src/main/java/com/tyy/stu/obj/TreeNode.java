package com.tyy.stu.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {


    private Integer val;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }


    public static TreeNode getSimpleNode() {

        TreeNode f = new TreeNode(6, null, null);
        TreeNode e = new TreeNode(5, null, null);
        TreeNode d = new TreeNode(4, null, null);

        TreeNode c = new TreeNode(3, null, f);
        TreeNode b = new TreeNode(2, d, e);
        TreeNode a = new TreeNode(1, b, c);


        System.out.println("******* node ********");
        System.out.println("         1          ");
        System.out.println("     2        3     ");
        System.out.println("  4     5        6  ");
        System.out.println("********************");
        return a;
    }


    /**
     * 打印二叉树
     *
     * @param root 根节点
     */
    public static void visit(TreeNode root) {
        //todo 按照层次结构打印一颗二叉树，并且展示左右节点
        if (root == null) return;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode tmp = nodes.remove(0);
            if (tmp.getLeft() != null) nodes.add(tmp.getLeft());
            if (tmp.getRight() != null) nodes.add(tmp.getRight());
            System.out.println(tmp.getVal());
        }

    }




}
