package com.tyy.stu.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
