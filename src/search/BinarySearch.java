import java.util.Comparator;

public class BinarySearch {
    

    /**
     * 二分查找非递归
     * @param <T>
     * @param ts
     * @param target
     * @param cmp
     * @return
     */
    public <T> int findIndex(T[] ts, T target, Comparator<T> cmp) {
        var left = 0;
        var right = ts.length - 1;
        var mid = (right + left) / 2;
        while(left <= right) {
            var compared = cmp.compare(ts[mid], target);
            if (compared > 0) right = mid - 1;
            else if (compared < 0) left = mid + 1;
            else return mid;
            mid = (right + left) / 2;
        }
        return -1;
    }

    /**
     * 二分查找递归方式，
     *      :) 皮一把玩一手闭包
     * @param <T>
     * @param ts
     * @param target
     * @param cmp
     * @return
     */
    public <T> int findIndexRecursion(T[] ts, T target, Comparator<T> cmp) {
        class Closure {
            int recursion(int left, int right) {
                if (left <= right) {
                    var mid = (left + right) / 2;
                    var compared = cmp.compare(ts[mid], target);
                    if (compared > 0) return recursion(left, mid - 1);
                    else if (compared < 0) return recursion(mid + 1, right);
                    return mid;
                }
                return -1;
            }
        }
        return new Closure().recursion(0, ts.length - 1);
    }

    public static void main(String[] args) {
        var search = new BinarySearch();
        var arr = new Integer[]{1, 2, 4, 5, 7, 10, 23, 102, 333};
        var index = search.findIndex(arr, 1, (a, b) -> (int) a - (int) b);
        System.out.printf("[non-recursion]  find index: %d\n", index);
        index = search.findIndexRecursion(arr, 1, (a, b) -> (int) a - (int) b);
        System.out.printf("[recursion]      find index: %d\n", index);
    }
}