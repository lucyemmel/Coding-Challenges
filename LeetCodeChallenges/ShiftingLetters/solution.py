# from https://leetcode.com/problems/shifting-letters/
class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        chars = 'abcdefghijklmnopqrstuvwxyz'
        shift_sum = sum(shifts)
        used = 0
        solution = ''
        
        for i in range(len(s)):
            total_shift = shift_sum - used
            used += shifts[i]
            solution += chars[(chars.index(s[i]) + total_shift) % len(chars)]
            
        return solution