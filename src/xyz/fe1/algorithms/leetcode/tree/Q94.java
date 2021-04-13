package xyz.fe1.algorithms.leetcode.tree;

import xyz.fe1.datastruct.binary.TreeNode;

import java.util.LinkedList;
import java.util.List;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[2,1]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 914 👎 0
public class Q94 {

    public static void main(String[] args) {
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        var q94 = new Q94();
        System.out.println(q94.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new LinkedList<Integer>();
        travel(root, list);
        return list;
    }

    private void travel(TreeNode node, List<Integer> list) {
        if (node != null) {
            travel(node.left, list);
            list.add(node.val);
            travel(node.right, list);
        }
    }

}
