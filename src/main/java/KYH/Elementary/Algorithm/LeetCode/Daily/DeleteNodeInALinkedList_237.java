package KYH.Elementary.Algorithm.LeetCode.Daily;

public class DeleteNodeInALinkedList_237 {
    public static void main(String[] args) {
        ListNode input = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        deleteNode(input.next);
        System.out.println(input);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            this.next = null;
        }
        public ListNode(int x, ListNode nextNode) {
            val = x;
            next = nextNode;
        }
        @Override
        public String toString() {
            return val + ", " + next;
        }
    }
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
