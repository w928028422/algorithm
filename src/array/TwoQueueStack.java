package array;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int obj){
        data.add(obj);
    }

    public int pop(){
        if (data.isEmpty()){
            throw new RuntimeException();
        }
        while (data.size() > 1){
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public int peek(){
        if (data.isEmpty()){
            throw new RuntimeException();
        }
        while (data.size() > 1){
            help.add(data.poll());
        }
        int res = data.peek();
        help.add(data.poll());
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(8);
        stack.push(7);
        System.out.println(stack.pop());
        stack.push(9);
        System.out.println(stack.peek());
    }
}
