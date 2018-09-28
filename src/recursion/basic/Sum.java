package recursion.basic;

public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

//    分类问题和确定边界
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
//        在调用界面进行工作台式的统计计算
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7,10};
        System.out.println(sum(arr));

    }
}
