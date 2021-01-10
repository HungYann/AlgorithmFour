package Chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item>{
    private static final int INIT_CAPACITY = 8;

    private Item[] a; //array of items
    private int n;  // number of elements on stack


    public ResizingArrayStack(){
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    /**
     * is this stack empty?
     * @return
     */

    public boolean isEmpty(){
        return n ==0;
    }

    /**
     * return the number of items in the stack
     * @return
     */

    public int size(){
        return n;
    }


    /**
     * resizing the underlying array holding the elements
     * @return
     */

    private void resize(int capacity){
        assert capacity>=n;
        a = Arrays.copyOf(a,capacity);
    }

    /**
     * Add the item to the stack
     * @return
     */

    private void push(Item item){
        if(n==a.length) resize(2*a.length);
        a[n++] = item;
    }

    /**
     * remove item
     * @return
     */

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null;
        n--;

        if(n>0&&n==a.length/4) resize(a.length/2);
        return item;
    }

    /**
     * return peek, not remove
     * @return
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) stack.push(item);
            else if(!stack.isEmpty()) StdOut.printf(stack.pop()+ " ");
         }
        StdOut.printf("("+ stack.size()+ "left on the stack)");
    }
    
}
