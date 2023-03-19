package E_Data_Structure_Generic;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        /* Todo example generic */
        Stack<String> st1;
        st1 = new Stack<String>(10);
        st1.push("A");
        st1.push("B");
        String s1 = st1.pop();

        /* Todo example Pair */
        Pair<String, Double> p1;
        p1 = new Pair<String, Double>("Ali", 19.0);
        String name = p1.getFirst();
        Double avg = p1.getSecond();

        /* Todo example Node */
        Node<String> last = new Node("Taghi", null);
        Node<String> first = new Node("Ali", last);

        /* Todo Raw Type */
        ArrayList list = new ArrayList();
        list.add("A");
        list.add(new Integer(5));
        list.add(new Character('#'));

        NumbersQueue queue;
        queue = new NumbersQueue();
        queue.enqueue(new Integer(1));
        queue.enqueue(new Double(3.14));
        //Compile error
        //queue.enqueue("Ali");


    }
}


class Stack<E> {
    private E[] elements;
    private int top;

    public void push(E pushValue) {
        if (top == elements.length - 1)
            throw new FullStackException();
        elements[++top] = pushValue;
    }

    public E pop() {
        if (top == -1)
            throw new EmptyStackException();
        return elements[top--];
    }

    public Stack(int maxsize) {
        top = -1;
        elements = (E[]) new Object[maxsize];
    }
}

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }
}

class Node<E> {
    E item;
    Node<E> next;

    Node(E element, Node<E> next) {
        this.item = element;
        this.next = next;
    }
}

/* Todo limit for generics */
interface SortedList<E extends Comparable> {
}

class NumbersQueue<T extends Number> {

    List<T> list = new ArrayList<>();

    public void enqueue(T o) {
        list.add(o);
    }

    public T dequeue() {
        return list.get(list.size() - 1);
    }
}

/* Todo Inheritance Generics */

/*class IntList implements List<Integer> {
    public boolean add(Integer e) {
        return true;
    }
}*/

interface NumberList<T extends Number> extends List<T> {
}


class FullStackException extends RuntimeException {

}