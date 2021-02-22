package LC.top100;

import helper.Helper;
import helper.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode res = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            carry = sum / 10;
            sum %= 10;
            head.next = new ListNode(sum);
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0)
            head.next = new ListNode(carry);
        return res.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        Helper.prettyPrint(addTwoNumbers.addTwoNumbers(
                Helper.convertIntegerArrayToLinkedList(new int[]{2, 4, 3}),
                Helper.convertIntegerArrayToLinkedList(new int[]{5, 6, 4})
        ));

        Helper.prettyPrint(addTwoNumbers.addTwoNumbers(
                Helper.convertIntegerArrayToLinkedList(new int[]{0}),
                Helper.convertIntegerArrayToLinkedList(new int[]{0})
        ));

        Helper.prettyPrint(addTwoNumbers.addTwoNumbers(
                Helper.convertIntegerArrayToLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9}),
                Helper.convertIntegerArrayToLinkedList(new int[]{9, 9, 9, 9})
        ));
    }
}
