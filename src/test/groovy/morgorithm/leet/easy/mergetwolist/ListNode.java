package morgorithm.leet.easy.mergetwolist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val=[" + val + "]" + (next == null? "" : next.val);
    }
}