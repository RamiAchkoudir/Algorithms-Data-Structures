Uppgift 3 - FIFO queue Java

import java.util.*;


public class Uppgift3 {


    static DNode head;
    static DNode tail;

    public class DNode {

        int data;
        DNode next;
        DNode previous;

        DNode(int data){

            this.data = data;

        }
    }

    public void addNode(int data){

        DNode dNode = new DNode(data);

        if(head==null){

            head = dNode;
            tail = dNode;
            head.next = head;
            head.previous = head;

        }else{

            tail = head;

            while(tail.next!=head){

                tail = tail.next;

            }

            tail.next = dNode;
            dNode.next = head;
            dNode.previous = tail;
            head.previous = dNode;

        }
    }

    public void add( int data){
        addNode(data);
        print();
        System.out.println();
    }

    public void remove(){
        delNode();
        print();
        System.out.println();
    }

    public void delNode(){

        if (head.next == tail){
            head = null;
            tail = null;
            DNode n = null;
        System.out.println(n);

        }
        else if (head == null){
            DNode m = null;
         System.out.println(m);
        }
        else {
            tail = head;
            head.next.previous = head.previous;
            head.previous.next = head.next;
            head = head.next;
        }
    }

    public void print(){

        tail = head;
        do{

            System.out.print( tail.data + " --> " );

            tail = tail.next;

        }while(tail!=head);

    }



    public static void main(String[] args){

        Uppgift3 list = new Uppgift3();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);;
        list.remove();
        //System.out.println();

    }
}



