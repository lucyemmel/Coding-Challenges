/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.math.BigInteger;
class Solution {
    
    private int [] getDigits(BigInteger val) {
        int [] res = new int[val.toString().length()];
        int current = 0;
        
        do {
            res[current] = (val.mod(BigInteger.TEN)).intValue();
            val = val.divide(BigInteger.TEN);
            current++;
        } while(val.signum() == 1);
        
        return res;
    }
    
    private ListNode makeNewList(BigInteger val) {
        int [] digits = getDigits(val);
        ListNode start = null;
        ListNode last = null;
        
        for(int digit: digits) {
            if(start == null) {
                start = new ListNode(digit);
                last = start;
            }
            else {
                last.next = new ListNode(digit);
                last = last.next;
            }
        }
        return start;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        assert l1 != null && l2 != null;
        
        String repr1 = "";
        String repr2 = "";
        
        do {
            repr1 = Integer.toString(l1.val).concat(repr1);
            l1 = l1.next;
        } while(l1 != null);
        
         do {
            repr2 = Integer.toString(l2.val).concat(repr2);
            l2 = l2.next;
        } while(l2 != null);
    
        
        BigInteger val1 = new BigInteger(repr1, 10);
        BigInteger val2 = new BigInteger(repr2, 10);
        
        BigInteger sum = val1.add(val2);
        return makeNewList(sum);
    }
}