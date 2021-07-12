// from https://leetcode.com/problems/decode-xored-array/
class Solution {
    public int[] decode(int[] encoded, int first) {
        int [] solution = new int[encoded.length + 1];
        solution[0] = first;
        for(int i = 0; i < encoded.length; i++) {
            solution[i + 1] = encoded[i] ^ first;
            first = solution[i + 1];
        }
        return solution;
    }
}