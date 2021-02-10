
public class Q_7 {

  /**
   * 7. Reverse Integer
   * 
   * Given a signed 32-bit integer x, return x with its digits reversed.
   * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
   * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
   *  Example 1:
   *     Input: x = 123
   *     Output: 321
   *   Example 2:
   *     Input: x = -123
   *     Output: -321
   *   Example 3:
   *     Input: x = 120
   *     Output: 21
   *   Example 4:
   *     Input: x = 0
   *     Output: 0
   */
  public static void main(String[] args) {
      System.out.println(reverse(-2147483629));
  }

  /**
   * 模拟栈操作，并且控制溢出即可
   * @param x
   * @return
   */
  public static int reverse(int x) {
      int reverseNumber = 0;
      while (x != 0) {
        int bit = x % 10;
        /**
         * 判断溢出情况，int最大值的最后一位是7，最小值的最后一位是8
         */
        if ( reverseNumber > Integer.MAX_VALUE / 10 || 
          (reverseNumber == Integer.MAX_VALUE / 10 && bit > 7) ||    
          reverseNumber < Integer.MIN_VALUE / 10 ||
          (reverseNumber == Integer.MIN_VALUE / 10 && bit < -8) ) {
          return 0;
        }
        reverseNumber = reverseNumber * 10 + bit;
        x /= 10;
      }
      return reverseNumber;
  }
}
