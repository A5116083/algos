package com.company.Queue;

import java.util.*;

public class LRUCache {

    public static void main(String[] args) {
            Cache cache = new Cache(4);
            cache.refer(1);
            cache.refer(2);
            cache.refer(3);
            cache.refer(1);
            cache.refer(4);
            cache.refer(5);
            cache.refer(2);
            cache.refer(2);
            cache.refer(1);
            cache.displayAll();



    }

    public static class CacheUsingLkdHashMap{




    }

    public static class  Cache{

        Deque<Integer> dll ;
        HashSet<Integer> keyMap;
        int size;

        public Cache(int size) {
            this.size = size;
            dll = new LinkedList<>();
            keyMap = new HashSet<>();
        }

        public void refer(int x){

            if(!keyMap.contains(x)){
                if(dll.size()== size){  //if the size of the Deque is full then remove item from last and also remove same item from the Hashset
                    int last = dll.removeLast();
                    keyMap.remove(last);
                }

            }else {
                dll.remove(x);
            }
            dll.push(x);
            keyMap.add(x);

        }

        public void displayAll(){
            Iterator<Integer> iterator=  dll.iterator();
            while (iterator.hasNext()){

                System.out.println(iterator.next());
            }


        }
    }

}
