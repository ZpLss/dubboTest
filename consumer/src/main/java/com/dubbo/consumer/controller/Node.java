package com.dubbo.consumer.controller;

public class Node {

    public Integer value;
    public Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
