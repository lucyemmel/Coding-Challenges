// from https://leetcode.com/problems/palindrome-number/
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String repr = Integer.toString(x);
        
        int j = repr.length() - 1;
        for(int i = 0; i < repr.length() / 2; i++) {
            if(repr.charAt(i) != repr.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }
}