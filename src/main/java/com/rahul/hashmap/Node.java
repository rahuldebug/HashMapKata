package com.rahul.hashmap;

public class Node {
    String key;
    Integer val;
    Node next;

    public Node(String key , int val){
        this.key=key;
        this.val=val;
    }


    public Node() {

       // this.key="";
        this.val=-1;
        this.next=null;
    }
}
