// from https://leetcode.com/problems/string-to-integer-atoi/

import java.math.BigInteger;
class Solution {
    public int myAtoi(String s) {
        // Step 1
        s = s.stripLeading();
        // Step 2
        String repr = "";
        if(s.startsWith("-")) {
            repr += "-";
            s = s.substring(1);
        }
        else if(s.startsWith("+")) {
            s = s.substring(1);
        }
         if(s.isEmpty()) {
            return 0;
        }
        // Step 3
        char c = s.charAt(0);
        while(!s.isEmpty() && Character.isDigit(c)) {
            repr += c;
            s = s.substring(1);
            if(s.isEmpty()) {
                break;
            }
            c = s.charAt(0);
        }
        System.out.println(repr);
        // Step 4
        int result = 0;
        if(!repr.isEmpty()) {
            try {
                result = Integer.parseInt(repr, 10);
            }
            catch(NumberFormatException ex) {
                // Step 5
                try {
                    BigInteger temp = new BigInteger(repr);
                    BigInteger max = new BigInteger(Integer.toString(Integer.MAX_VALUE));
                    BigInteger min = new BigInteger(Integer.toString(Integer.MIN_VALUE));
                    if(temp.compareTo(max) == 1) {
                        return Integer.MAX_VALUE;
                    }
                    if(temp.compareTo(min) == -1) {
                        return Integer.MIN_VALUE;
                    }
                }
                // repr does not represent a valid number
                catch(NumberFormatException e) {
                    return 0;
                }
            }
        }
        // Step 6
        return result;
    }
}