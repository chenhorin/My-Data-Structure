package arrays;

public class Array<E> {

    private E[] data;
    private int size;

    private static final int ARRAY_WRONG = -1;
    private static final int ARRAYS_OK = 1;


    public Array(int capacity) {
//        data = new int[capacity];
        // 初始化和容量放进去的东西不一样
        //注意Java不支持数组生命泛型
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
//        记得复用性 data = new int[10];
        this(10);//注意代码的规范性，善用this
    }

    public int getSize() {
        return size;
    }

    //    记得要查看数组容量
    public int getCapacity() {
        return data.length;
    }

    //    查看是否为空
    public boolean isEmpty() {
       /* if (size == 0) {
            return false;
        } else
            return true;*/
        return size == 0;//注意代码的冗余
    }

    /*public int addElement(int e) {
        if (size < this.getCapacity()) {
            data[size] = e;
            size++;
            return ARRAY_WRONG;
        } else
            return ARRAYS_OK;
    }*/

    //  在索引处插入
    public void /*addElement*/add(int index, E e) {
        /*if (index >= 0 && index <= size && size + 1 < this.getCapacity()) {
            for (int i = size + 1; i > index; i--) {
                data[i] = data[i - 1];
            }
            size++;
            data[index] = e;
            return ARRAYS_OK;
        } else return ARRAY_WRONG;*/
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;

        size++;
        /*if (size == data.length) {
            resize(2 * data.length);
        }*/
//        注意放的位置
    }

    /* public void updateElement(int index, int e)*/
    public void set(int index, E e){
        /*if (index >= 0 && index <= size)
            data[index] = e;
        return ARRAYS_OK;注意逻辑与和逻辑或*/
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("索引越界");
        }
        data[index] = e;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界");
        }
        return data[index];
    }

    //    注意往所有的头添加和尾添加
    public void addFirst(E e) {
        add(0,e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public boolean contains(E e) {
        /*for (int i : data) {
            if (i == e) {
                return true;
            }
        }*/
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            /*if (data[i] == e) {
                return i;
            }*/
//            声明对象后需要判断的是对象是否相同
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    //    删除返回的元素,删除索引对应的,和删除元素
    public E removeElement(E e) {
        int i = find(e);
        if (i == -1) {
            throw new IllegalArgumentException("不存在删除的元素");
        }
        return remove(i);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界");
        }

        E rem = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; //把所有的值往前挪动一位最后一位还是老值...个人推测形式上变为Null称之为loitering num != memory leak

        if (size == data.length / 4) {
            resize(data.length / 4);
        }
        return rem;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

//    注意功能性的还是得提前封装
    /*public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }*/
    public E getLast(){
    return get(size - 1);
}

    public E getFirst(){
        return get(0);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d , capacity = %d\n", size, data.length));
        res.append("[ ");
        for (int i = 0; i < size ;i ++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(" , ");
        }
        res.append(" ]");
        return res.toString();
    }

    //    缩容
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        /*System.arraycopy(data,0,newArray,0,data.length);*/
        for(int i = 0 ; i < size ; i ++)
            newArray[i] = data[i];
        data = newArray;
    }
}

