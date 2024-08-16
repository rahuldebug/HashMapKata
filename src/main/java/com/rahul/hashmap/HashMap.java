package com.rahul.hashmap;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
    //default size
    int size = 16;
    List<Node> bucket;

    //Constructor
    public HashMap() {
        this.bucket = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            bucket.add(new Node());
        }
    }

    //put logic implementation
    public void put(String key, Integer val) {
        Node toInsert = new Node(key, val);
        Integer hash = getHash(key);
        int loc = handleBucket(hash);

            //get the bucket for insertion , using hash function
            Node first = bucket.get(loc);

            //keeping temp , so I don't lose the first
            Node temp = first;

            // Same key , logic to overwrite
            if (containsKey(key)) {
                if(temp.key==null) temp=temp.next;
                while (!temp.key.equals(key)) {
                    // containsKey(key);
                    temp = temp.next;
                }
                temp.val = val;
            }

            //looking for insertion location in case of collision

            else {
                while (temp.next != null) {
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

    //method to check conatins key
    private boolean containsKey(String key) {
        int loc = handleBucket(getHash(key));
        Node curr = (Node) bucket.get(loc);
        while (curr!= null) {
            if (key.equals(curr.key)) return true;
            curr = curr.next;
        }
        return false;
    }

//resizing logic

    public void resize(int currsize) {
//edge case handling
        if (currsize < this.size) return;
        this.size = size;
        List<Node> oldBucket = bucket;
//new arraylist of new size  being assigned to bucket
//and bucket moved to new bucket
        bucket = new ArrayList<Node>(size);
        //initializing with empty nodes
        for(int i=0;i<size;i++){
            bucket.add(i,new Node());
        }
//
        for (Node node : oldBucket) {
            if (node.next != null) {
                Node temp = node;
                while (temp.next != null) {
                    //hashing and bucketing logic will handle the position
                    //as instead of dividing with constants , it is being divided by current size
                    put(temp.key, temp.val);
                    temp = temp.next;
                }

            }
        }

    }


}

