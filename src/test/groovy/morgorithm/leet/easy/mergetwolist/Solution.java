package morgorithm.leet.easy.mergetwolist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1.next != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        list1.add(l1.val);
        while (l2.next != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        list2.add(l2.val);

        list1.addAll(list2);
        Collections.sort(list1);

        System.out.println(list1);

        ListNode result = new ListNode(list1.get(0));

        for (int i = 1; i < list1.size() - 1; i++) {
            int c = list1.get(i);
            result.val = c;
            result.next = new ListNode(c);
            result = result.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a4 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);

        a1.next = a2;
        a2.next = a4;

        b1.next = b3;
        b3.next = b4;
        final ListNode listNode = solution.mergeTwoLists(a1, b1);
        System.out.println(listNode);
    }
}
