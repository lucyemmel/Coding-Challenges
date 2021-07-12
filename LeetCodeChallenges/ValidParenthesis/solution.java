// from https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        // uneven size can never be correct
        if(s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            switch(c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':
                case '}':
                case ']':
                    // stack should not be empty
                    if(stack.empty()) {
                        return false;
                    }
                    char ch = stack.pop();
                    // invalid closing paranthesis
                    if(c != ch) {
                        return false;
                    }
                    break;
                default:
                    // invalid character found
                    return false;
            }
        }
        // non-empty stack means there were more opening than closing paranthesis
        return stack.empty();
    }
}