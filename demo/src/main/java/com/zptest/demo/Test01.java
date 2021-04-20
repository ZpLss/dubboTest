package com.zptest.demo;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    public static void main(String[] args) {



    }
    public static Node revert(Node node){

        List<Integer> list = new ArrayList<>();
        while (true){
            if (node.next != null){
                list.add(node.data);
            }
            if (node.next == null){
                list.add(node.data);
                break;
            }
        }

        for (int i = list.size() -1;i < list.size(); i--){
            Node node1 = new Node();
            node1.data = list.get(i);

            Node node2 = new Node();
            node2.data = list.get(i);

        }


        return node;
    }


}

class Node{
    public int data;
    public Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
