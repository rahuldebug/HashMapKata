package com.rahul.hashmap;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
    //default size

    int size = 16;
    List<Node> bucket;

    public HashMap() {

        this.bucket = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            bucket.add(new Node());
        }
    }

    public void put(String key, Integer val) {
        Node toInsert = new Node(key, val);
        Integer hash = getHash(key);
        int loc = handleBucket(hash);

            //check for collision first
            //curr value at the location
            Node first = bucket.get(loc);
            //keeping temp , so I don't lose the first
            Node temp = first;

            //also needs to check for same key
            //logic to overwrite

            if (containsKey(key)) {
                if(temp.key==null) temp=temp.next;
                while (!temp.key.equals(key)) {
                    // containsKey(key);
                    temp = temp.next;
                }
                temp.val = val;
            }
            //looking for insertion location
            else {
                while (temp.next != null) {
                    // containsKey(key);
                    temp = temp.next;
                }
                // here value will be inserted
                temp.next = toInsert;

            }

    }


    public Integer get(String key) {
        Integer hash = getHash(key);
        int loc = handleBucket(hash);
        Node first = bucket.get(loc);

        if (containsKey(key)) {
            while (!key.equals(first.key)) {
                first = first.next;
            }
            return first.val;
        }

        return null;

    }

    //Utility methods


    //method to get bucket Location
    private Integer handleBucket(Integer hash) {
        return hash % size;

    }


    //method to get hash
    private Integer getHash(String key) {
        return key.hashCode();
    }

    private boolean containsKey(String key) {
        int loc = handleBucket(getHash(key));
        Node curr = (Node) bucket.get(loc);
        while (curr!= null) {
            // String temp= curr.key;
            if (key.equals(curr.key)) return true;
            curr = curr.next;
        }
        return false;
    }


    public void resize(int currsize) {

        if (currsize < this.size) return;
        this.size = size;
        List<Node> oldBucket = bucket;

        bucket = new ArrayList<Node>(size);
        for(int i=0;i<size;i++){
            bucket.add(i,new Node());
        }

        for (Node node : oldBucket) {
            if (node.next != null) {
                Node temp = node;
                while (temp.next != null) {
                    put(temp.key, temp.val);
                    temp = temp.next;
                }

            }
        }

    }


}

