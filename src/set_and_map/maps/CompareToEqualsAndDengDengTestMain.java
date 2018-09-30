package set_and_map.maps;

public class CompareToEqualsAndDengDengTestMain {
    public static void main(String[] args) {

        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println((s1 == s2) ? "true" : "false");//false
        System.out.println((s1.equals(s2)) ? "true" : "false");//true

        if (s1.compareTo(s2) == 0) {
            System.out.println("s1 is equal s2");//out
        }
        Boolean t = new Boolean(true);
        Boolean f = new Boolean(false);

        System.out.println(t.compareTo(f));//true

        Integer a = 1;
        Integer b = 2;
        System.out.println(b.compareTo(a));//?

        s1 = s2;
        System.out.println((s1 == s2) ? "true" : "false");//true

    }
}
