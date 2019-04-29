package tij.util;

import java.util.LinkedList;

public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<>();

    public void push(T t) {
        storage.addFirst(t);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String s = "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—";

        for (int i=0, len=s.length(); i<len; i++){
            if ('+' == s.charAt(i)){
                i++;
                stack.push(s.charAt(i) + "");
            }
            else if('-' == s.charAt(i))
                System.out.print(stack.pop());
        }
        System.out.println();

        System.out.println(stack);

    }
}
