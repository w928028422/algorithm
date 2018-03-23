package array;

/**
 * 用数组实现栈和队列
 */
public class ArrayToStackQueue {
    static class MyStack {
        private int index;
        private int[] array;

        public MyStack(int size) throws Exception {
            if (size <= 0){
                throw new Exception("栈的大小不合法");
            }
            array = new int[size];
        }

        public int peek(){
            if (index == 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            return array[index - 1];
        }

        public int pop(){
            if (index == 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            return array[--index];
        }

        public void push(int obj){
            if (index == array.length){
                throw new ArrayIndexOutOfBoundsException();
            }
            array[index++] = obj;
        }
    }

    static class MyQueue {
        private int[] array;
        private int size;
        private int start;
        private int end;

        public MyQueue(int initSize) throws Exception {
            if (initSize <= 0){
                throw new Exception("栈的大小不合法");
            }
            array = new int[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        public void push(int obj){
            if (size == array.length){
                throw new ArrayIndexOutOfBoundsException();
            }
            array[end++] = obj;
            size++;
            if (end == array.length){
                end = 0;
            }
        }

        public int poll(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            int res = array[start++];
            size--;
            if (start == array.length){
                start = 0;
            }
            return res;
        }

        public int peek(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            return array[start];
        }
    }

    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack(2);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.peek());
        MyQueue queue = new MyQueue(3);
        queue.push(5);
        queue.push(9);
        queue.push(1);
        System.out.println(queue.poll());
        queue.push(6);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
