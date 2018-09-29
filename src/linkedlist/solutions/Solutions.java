package linkedlist.solutions;

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
    public ListNode removeElements2(ListNode head, int e) {
//        当不需要考虑内存的释放问题时,不需要再额外做一个指针
        while (head != null && head.val == e) {
            head = head.next;
        }
        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == e) {
                prev.next = prev.next.next;
//                改变的节点依然可能是待删除的节点,所以需要再次循环
            } else
                prev = prev.next;
        }
        return head;
    }

    public ListNode removeElements3(ListNode head, int e) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode prev = dummyhead;
        while (prev.next != null) {
            if (prev.next.val == e) {
                prev.next = prev.next.next;
            }else
                prev = prev.next;
        }
        return dummyhead.next;
    }

    public ListNode removeElements4(ListNode head, int e) {
        if (head == null) {
            return null;
        }
      /*  ListNode res = removeElements4(head.next, e);
        if (head.val == e) {
            return res;
        }else
            head = head.next;
        return head;*/
        ListNode res = removeElements4(head.next,e);
        if (head.val == e) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
    public ListNode removeElements5(ListNode head, int e) {
        if (head == null) {
            return null;
        }
        head.next = removeElements5(head.next, e);
        return head.val == e ? head.next : head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7};
        ListNode node = new ListNode(arr);
        System.out.println(node);
        System.out.println(new Solutions().removeElements5(node, 2));

    }
}
