import arrays.Array;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array arr = new Array();
        /*System.out.println(array.getSize());
        for (int i = 0; i < 454; i++) {
            array.addFirst(getRandom());
        }
        System.out.println(array.toString());


        System.out.println("+++-----");
        System.out.println(array.removeLast());
        System.out.println("+++-----");
        System.out.println(array.toString());

        System.out.println("------");

        System.out.println("+++-----");
        System.out.println(array.removeFirst());
        System.out.println("+++-----");

        System.out.println(array.toString());*/
        for (int i = 0; i < 8; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        for (int i = 0; i < 3; i++) {
            arr.removeLast();
        }
        System.out.println(arr);

        for (int i = 0; i < 3; i++) {
            arr.removeLast();
        }
        System.out.println(arr);
    }

    private static int getRandom() {
        Random random = new Random();
        int nextInt = random.nextInt(100);
        System.out.println("我是random" + nextInt);
        return nextInt;
    }
}
