// from https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    
    private boolean isPalindrome(String s) {
        int j = s.length() - 1;
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }
    
    public String longestPalindrome(String s) {
        var len = s.length();
        String solution = "";
        for(int i = 0; i < len; i++) {
            for(int j = 1; j <= len; j++) {
                if(j > i) {
                var substr = s.substring(i, j);
                if(substr.length() > solution.length() && isPalindrome(substr)) {
                    solution = substr;
                }
            }
            }
        }
        return solution;
    }
}