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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode list = head;
        
        double carryOver = 0;

        while(l1 != null || l2 != null || carryOver > 0) { // O(n) vai rodar no tamanho da maior lista
            int l1Value = 0; 
            if (l1 != null) l1Value = l1.val;

            int l2Value = 0;
            if (l2 != null) l2Value = l2.val;

            int sum = (l1Value + l2Value) + (int) carryOver;

            carryOver = 0;
            if (sum > 9) carryOver = (double) sum/10;

            if (carryOver > 0) {
                int decimal = (int) carryOver;
                double fractional = carryOver - decimal;
                String s = String.format("%.2f", fractional);
                fractional = Double.parseDouble(s);

                list.val = (int) (fractional * 10);
            } else {
                list.val = sum;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (l1 == null && l2 == null && carryOver == 0) break;

            list.next = new ListNode();
            list = list.next;
        }

        return head;
    }
}