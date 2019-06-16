import java.util.HashSet;

public class Solution160_IntersectionLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    ListNode hhh;

    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        ListNode ha, hb;
        HashSet<ListNode> m = new HashSet<>();
        ha = headA;
        hb = headB;

        while (ha != null) {
            m.add(ha);
            ha = ha.next;
        }

        while (hb != null) {
            if (m.contains(ha)) {
                return hb;
            }
            hb = hb.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        ListNode ha, hb;
        if (headA == null || headB == null) {
            return null;
        }
        ha = headA;
        hb = headB;

        while (ha != hb) {
            if (ha.next == null && hb.next == null) {
                return null;
            }
            if (ha.next != null) {
                ha = ha.next;
            } else {
                ha = headB;
            }
            if (hb.next != null) {
                hb = hb.next;
            } else {
                hb = headA;
            }
        }
        return ha;
    }
}

