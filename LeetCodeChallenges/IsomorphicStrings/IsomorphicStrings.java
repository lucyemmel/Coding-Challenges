class Solution {
    
    private boolean isIsomorphicHelper(String a, String b) {
        assert a.length() == b.length();
        
        // attempt isomorphing String a into String b
        HashMap<Character, Character> isomorphingMap = new HashMap<>(); 
        for(int i = 0; i < a.length(); i++) {
            isomorphingMap.putIfAbsent(a.charAt(i), b.charAt(i));
        }
        
         // build potential solution
        char [] chars = a.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            chars[i] = isomorphingMap.get(chars[i]);
        }
        
        String morphed_a = new String(chars);
		
        // return whether solution is correct
        return morphed_a.equals(b);
    }
    
    public boolean isIsomorphic(String s, String t) {
        assert s.length() == t.length();
        
        // check isomorphable in both directions
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }
}