package HashTable;

import TwoPointers.ListNode;

import java.util.HashMap;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();//Does not matter of the value
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            } else {
                map.put(head, head.val);
            }
            head = head.next;
        }

        return null;
    }
}
