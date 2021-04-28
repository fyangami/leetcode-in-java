package xyz.fe1.datastruct.binary;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val){this.val = val;}

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
