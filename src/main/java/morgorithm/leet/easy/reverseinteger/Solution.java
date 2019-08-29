package morgorithm.leet.easy.reverseinteger;


/*
* Given a 32-bit signed integer, reverse digits of an integer.
*
* Example 1:
Input: 123
Output: 321

* Example 2:
Input: -123
Output: -321

* Example 3:
Input: 120
Output: 21
*
* */
/*
 * Note:
 *  Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 *  range: [−231,  231 − 1].
 *  For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * */
class Solution {
    public int reverse(int x) {
        final char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;

        boolean hasMinusSign = false;
        if(chars[0] == '-'){
            hasMinusSign = true;
        }

        StringBuilder sb = new StringBuilder();
        if(hasMinusSign){
            sb.append('-');
        }
        for(int i = length - 1 ; i >= 0 ; i--){
            if(chars[i] != '-') {
                sb.append(chars[i]);
            }
        }

        final long l = Long.parseLong(sb.toString());
        if(l >= Integer.MAX_VALUE || l <= Integer.MIN_VALUE){
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(120));//
        System.out.println(s.reverse(1534236469));
    }
}