// https://docs.google.com/presentation/d/1h0Q8yZkgNTJr2FQVEOUmiN99Tj4k05tKxPuRZEQ9ZjU/edit#slide=id.ge3aa12ad30_0_191

package com.ingenieria_de_software.helpers;

public class Node<T> {

    T data;
    Node<T> previous;

    public Node(T data, Node<T> previous) {
        this.data = data;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrevious() {
        return previous;
    }

}
