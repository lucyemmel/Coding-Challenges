// from https://leetcode.com/problems/license-key-formatting/
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase().replaceAll("-", "");
        
        if(s.isBlank()) {
            return "";
        }
        
        int start = 0;
        String solution = "";
        int leftover = s.length() % k;
        
        while(leftover-- != 0) {
            solution += s.charAt(start);
            start++;
        }
        if(start > 0) {
            solution += '-';
        }
        
        for(int i = 0; i < s.length() / k; i++) {
            // take k chars and append them to string
            for(int j = 0; j < k; j++) {
                solution += s.charAt(start);
                start++;
            }
            solution += "-";
        }
        
        return solution.substring(0, solution.length() - 1);
    }
}