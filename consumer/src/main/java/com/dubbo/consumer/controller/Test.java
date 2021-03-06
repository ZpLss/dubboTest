package com.dubbo.consumer.controller;

public class Test {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;
        c.next = null;

        Node d = new Node(7);
        Node e = new Node(9);
        Node f = new Node(8);
        d.next = e;
        e.next = f;
        f.next = null;

        //反转链表
        Node node1 = revertNode(a);
        while (null != node1.next){
            System.out.println(node1.value);

            if (null == node1.next){
                System.out.println(node1.value);
            }
            node1 = node1.next;
        }
//        Node node2 = revertNode(d);
//        //遍历链表，对应节点数值相加
//        Node node = addNode(node1, node2);
//        while (null != node.next){
//            System.out.println(node.value);
//            node = node.next;
//        }


    }

    public static  Node revertNode(Node head){
        Node dummy = new Node(-1);
        Node pCur = head;
        while (pCur != null) {
             Node pNex = pCur.next;
             pCur.next = dummy.next;
             dummy.next = pCur;
             pCur = pNex;
        }
        return dummy.next;
    }

    public static Node addNode(Node l1, Node l2){
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else{
            Node ls1 = l1, ls2 = l2;
            int sum = 0, prog = 0;
            while(ls1 != null && ls2 != null){
                sum = ls1.value + ls2.value+ prog;
                ls1.value = sum%10;
                prog = sum/10;
                if(ls1.next == null || ls2.next == null) break;
                ls1 = ls1.next;
                ls2 = ls2.next;
            }
            if(ls1.next == null) ls1.next = ls2.next;
            while(prog != 0){
                if(ls1.next == null) {
                    ls1.next = new Node(prog);
                    prog = 0;
                }
                else{
                    ls1 = ls1.next;
                    sum = ls1.value + prog;
                    ls1.value = sum%10;
                    prog = sum/10;
                }
            }
        }
        return l1;
    }
}
