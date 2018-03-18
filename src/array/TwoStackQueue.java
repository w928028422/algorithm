package array;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    public void push(int obj){
        stackPush.push(obj);
    }

    public int poll(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException();
        }
        pull();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException();
        }
        pull();
        return stackPop.peek();
    }

    private void pull() {
        if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.push(5);
        queue.push(4);
        queue.push(3);
        System.out.println(queue.poll());
        queue.push(6);
        System.out.println(queue.poll());
    }
}
