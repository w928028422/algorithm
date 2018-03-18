package array;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int obj){
        if (min.empty()){
            min.push(obj);
        }else if (obj > min.peek()){
            min.push(min.peek());
        }else{
            min.push(obj);
        }
        data.push(obj);
    }

    public int pop(){
        if (min.empty()){
            throw new RuntimeException();
        }
        min.pop();
        return data.pop();
    }

    public int getMin(){
        return min.peek();
    }

    public int peek(){
        return data.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(0);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
    }
}
