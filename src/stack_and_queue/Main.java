package stack_and_queue;

public class Main {
    public static void main(String[] args) {
//        1. basic test
        /*ArrayStack<Object> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        System.out.println(stack);*/
//        2. leet_code
       /* Main main = new Main();
//        System.out.println(main.isValid("{[)}"));
        System.out.println(main.isValid("{(}"));*/

//       3.Queue
        Queue queue = new LoopQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
//这样做为什么不行?因为错的时候没有及时,返回,没有进入条件判断return中止,当'['弹出后一次 c = '}' topChar就成立
                /*char topChar = stack.pop();
                if (c == '}' && topChar == '{') {
                    return true;
                }
                if (c == ']' && topChar == '[') {
                    return true;
                }
                if (c == ')' && topChar == '(') {
                    return true;
                }*/
                char topChar = stack.pop();
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
