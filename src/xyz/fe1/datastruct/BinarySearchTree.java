package xyz.fe1.datastruct;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private final TreeNode<T> root;

    public BinarySearchTree(T t) {
        this.root = new TreeNode<>(t);
    }

    public BinarySearchTree<T> insert(T t) {
        if (t == null) throw new IllegalArgumentException();
        var node = new TreeNode<>(t);
        var cursor = root;
        while (true) {
            if (cursor.e.compareTo(node.e) >= 0) {
                if (cursor.left != null) {
                    cursor = cursor.left;
                } else {
                    cursor.left = node;
                    break;
                }
            } else {
                if (cursor.right != null) {
                    cursor = cursor.right;
                } else {
                    cursor.right = node;
                    break;
                }
            }
        }
        return this;
    }

/*    public boolean remove(T t) {
        var cursor = root;
        var parent = cursor;
        boolean removeLeft = false;
        while (cursor != null) {
            int compare = cursor.e.compareTo(t);
            if (compare == 0) {
                TreeNode<T> proceed, marge = null;
                if (cursor.left == null) {
                    proceed = cursor.right;
                } else if (cursor.right == null) {
                    proceed = cursor.left;
                } else {
                    if (cursor.left.e.compareTo(cursor.right.e) < 0) {
                        proceed = cursor.left;
                        marge = cursor.right;
                    }else {
                        proceed = cursor.right;
                        marge = cursor.left;
                    }
                }
                if (removeLeft) parent.left = proceed;
                else parent.right = proceed;
                return true;
            } else if (compare >= 0) {
                parent = cursor;
                removeLeft = true;
                cursor = cursor.left;
            } else {
                parent = cursor;
                removeLeft = false;
                cursor = cursor.right;
            }
        }
        return false;
    }*/

    public boolean contains(T t) {
        var cursor = root;
        while (cursor != null) {
            int compare = cursor.e.compareTo(t);
            if (compare == 0) {
                return true;
            } else if (compare >= 0) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }
        return false;
    }

    public List<T> getList() {
        var list = new LinkedList<T>();
        travel(list::add);
        return list;
    }

    public void travel(Visitor<T> visitor) {
        travel(this.root, visitor);
    }

    private void travel(TreeNode<T> node, Visitor<T> visitor) {
        if (node == null) return;
        travel(node.left, visitor);
        visitor.visit(node.e);
        travel(node.right, visitor);
    }

    @FunctionalInterface
    public interface Visitor<E> {
        void visit(E e);
    }

    private static class TreeNode<E> {

        E e;
        TreeNode<E> left;
        TreeNode<E> right;

        TreeNode(E e) {
            this.e = e;
        }
    }
}
