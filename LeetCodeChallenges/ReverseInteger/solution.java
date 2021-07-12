// from https://leetcode.com/problems/reverse-integer/submissions/

class Solution {
    public int reverse(int x) {
        String repr = "";
        if(x < 0) {
            repr = "-";
            x = Math.abs(x);
        }
        
        do {
            repr += x % 10;
            x /= 10;
        } while(x != 0);
        
    System.out.println(repr);
        
        try {
            return Integer.parseInt(repr, 10);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
    
}