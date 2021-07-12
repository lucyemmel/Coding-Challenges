class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> repeated = new HashSet<>();
        int solution = 0;
        char [] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            final char c = chars[i];
            if(repeated.contains(c)) {
                 solution = (repeated.size() > solution) ? repeated.size() : solution;
                 repeated = new HashSet<Character>();
                // rebuild character sequence backwards up to collision
                for(int j = i - 1; j >= 0; j--) {
                    if(chars[j] == c) {
                        break;
                    }
                    repeated.add(chars[j]);
                }
            }
            repeated.add(c);
        }
        
        return (solution > repeated.size()) ? solution : repeated.size();
    }
}