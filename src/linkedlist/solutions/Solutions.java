package linkedlist.solutions;

import javax.sound.midi.Soundbank;

public class Solutions<E> {

    public ListNode removeElements(ListNode head, int e) {
//        新的头节点还是可能是跟给定的元素相等
        while (head != null && head.val == e) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == e) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
//                改变的节点依然可能是待删除的节点,所以需要再次循环
            } else
                prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7};
        ListNode node = new ListNode(arr);
        System.out.println(node);
        System.out.println(new Solutions().removeElements(node, 2));

    }
}
