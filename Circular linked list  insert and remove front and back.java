Uppgift 4 - Add/Remove etc



public class Uppgift4 {

    public class Node{
        int data;
        Node next;

        public Node(int data){

            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void AddAtStart(int data){

        Node Newnode = new Node(data);

        if(head == null){
            head = Newnode;
            tail = Newnode;
            //make it a singular circular linked list
            Newnode.next = head;
        }else{

            Newnode.next = head;
            //head är först på listan, tail är fortfarande på slutet
            head = Newnode;
            tail.next = head;

        }
    }

    public void DeleteStart(){

        if (head == null){
            return;
        }
        else{
        if (head != tail){
            head = head.next;
            tail.next = head;
        }
        else{
            head = tail = null;
        }

        }
    }

    public void AddAtEnd(int data){
        Node NewNode = new Node(data);
        if (head == null){
            head = NewNode;
            tail = NewNode;
            NewNode.next = head;
        }
        else{
            tail.next = NewNode;
            tail = NewNode;
            tail.next = head;
        }
    }

    public void DeleteEnd() {
        if(head == null) {
            return;
        }
        else {
            //Checks whether contain only one element
            if(head != tail ) {
                Node current = head;

                //Loop will iterate till the second last element as current.next is pointing to tail
                while(current.next != tail) {
                    current = current.next;
                }
                //Second last element will be new tail
                tail = current;
                current.next.next = null;
                //Tail will point to head as it is a circular linked list
                tail.next = head;
            }
            //If the list contains only one element
            //Then it will remove it and both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }


    public void display() {
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            do{
                //Prints each node by incrementing pointer.
                System.out.print(" "+ current.data);
                current = current.next;
            }while(current != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Uppgift4 list = new Uppgift4();

        //Add at start
        System.out.println("Adding from the start");
        System.out.println();
        list.AddAtStart(1);
        list.display();
        list.AddAtStart(2);
        list.display();
        list.AddAtStart(3);
        list.display();
        list.AddAtStart(4);
        list.display();

        /*
        //Add at End
        System.out.println("Adding from the end");
        System.out.println();
        list.AddAtEnd(1);
        list.display();
        list.AddAtEnd(2);
        list.display();
        list.AddAtEnd(3);
        list.display();
        list.AddAtEnd(4);
        list.display();
        */


        //DeleteStart
        /*
        while (list.head != null){
            list.DeleteStart();
            System.out.println("Deleting items from start");
            list.display();
        } */


        //DeleteEnd
        while(list.head != null){
            list.DeleteEnd();
            System.out.println("Deleting items from end");
            list.display();
        }

    }
}

