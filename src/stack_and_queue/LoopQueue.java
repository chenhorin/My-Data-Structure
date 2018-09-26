package stack_and_queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front,tail;

    private int size;


    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; //让头尾不重叠,为什么?当添加元素时,为了防止front == tail判断成空的时候又是为满
        //所以多添加一个元素
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;//只有他们相等的时候才可能为空
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front )
            reSize(getCapacity() * 2);
//       错误
        /*
        for (int i = tail - 1; i >= front % data.length;i --)
            data[i] = data[i - 1];

        data[front] = e;*/
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空，无法出队");
        }
        E res = data[front];

        data[front] = null;
        front = (front + 1) % data.length;
//      程序的健壮性,
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0 )
            reSize(getCapacity() / 2);
        return res;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    private void reSize(int capacity) {
        E[] newArr = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newArr[i] = data[(i + front) % data.length];
        }
        data = newArr;
//        漏掉了
        front = 0;
//        size = tail; tail循环变小的话,size岂不是也变小了
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue : capacity = %d , size = %d\n", getCapacity(), size));
        res.append("Front [");
//        因为i 可以 > tail
        /*for (int i = front; i % data.length < tail % data.length; i ++) {
            res.append(data[i]);
            if (i != tail - 1 % data.length) {
                res.append(" , ");
            }

        }*/
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);

            if ((i + 1) % data.length != tail) {
                res.append(" , ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
