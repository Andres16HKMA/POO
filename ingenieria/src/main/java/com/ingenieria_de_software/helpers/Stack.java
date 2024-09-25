package com.ingenieria_de_software.helpers;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node<T> head;
    private int size;

    public Stack() {
        size = 0;
    }

    public void push(T data) {
        this.head = new Node<>(data, this.head);
        size++;
    }

    public T pop() {
        if (this.head == null) {
            throw new EmptyStackException();
        }

        size--;
        T info = head.getData();
        this.head = this.head.getPrevious();
        return info;
    }

    public Node<T> peek() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        return this.head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return size;
    }

    public void unstackAll() {  // desapilar
        if (isEmpty()) {
            System.out.println("La pila está vacía");
        } else {
            while (!isEmpty()) {
                T dataNode = pop();
                System.out.println(dataNode);
            }
            System.out.println();
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
        } else {
            Node<T> node = peek();

            while (node != null) {
                System.out.println(node.getData());
                node = node.getPrevious();
            }
            System.out.println();
        }
    }

}