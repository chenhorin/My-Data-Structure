package stack_and_queue;

public class FastLinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;

    private int size;

    public FastLinkedListQueue() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        }
//        Node tailNode = tail;
//        反面教材,运行完上面又会运行下面
        /*tail.next = new Node(e);
        tail = tail.next;*/
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue wrong ,queue empty");
        }
        Node ret = head;
        head = head.next;
//        注意这样断掉联系,而不是使其对应的值为空,head.next自然还保持着联系;
        ret.next = null;
//        注意切掉node的tail的指针;
        if (head == null)
            tail = null;
        size--;
        return ret.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("FastLinkedListQueue : Size = %d \n", getSize()));
        res.append("FRONT : <-- ");

        Node cur = head;
        for (int i = 0; cur != null; i++) {
            res.append(cur.e + " <- ");
            cur = cur.next;
        }
        res.append("NULL  :TAIL");
        return res.toString();
    }

    public static void main(String[] args) {
        FastLinkedListQueue<Integer> queue = new FastLinkedListQueue();
        /*for (int i = 1; i < 10; i++) {
            queue.enqueue(i);
        }*/
        queue.enqueue(1);
        System.out.println(queue);
    }
}
