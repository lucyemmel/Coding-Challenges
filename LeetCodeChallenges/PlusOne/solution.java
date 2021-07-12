// from https://leetcode.com/problems/plus-one/
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] + 1 < 10) {
                digits[i]++;
                return digits;
            }
            else if(i - 1 < 0) {
                digits[i] = 0;
                int [] new_digits = new int[digits.length + 1];
                System.arraycopy(digits, 0, new_digits, 1, digits.length);
                new_digits[0] = 1;
                return new_digits;
            }
            else {
                digits[i] = 0;
            }
        }
        return digits;
    }
}