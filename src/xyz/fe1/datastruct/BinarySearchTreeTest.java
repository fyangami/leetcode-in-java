package xyz.fe1.datastruct;

public class BinarySearchTreeTest {


    public static void main(String[] args) {
        var tree = new BinarySearchTree<>(1);
        tree.insert(5).insert(6).insert(2).insert(10).insert(4).insert(7);
        System.out.printf("list: %s\n", tree.getList());
//        System.out.printf("remove element %s: %s\n", 5, tree.remove(5));
//        System.out.printf("list: %s\n", tree.getList());
        System.out.printf("contains %s: %s\n", 3, tree.contains(3));
        System.out.printf("contains %s: %s\n", 10, tree.contains(10));
    }
}
