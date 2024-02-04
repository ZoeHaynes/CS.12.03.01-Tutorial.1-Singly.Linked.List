public class SinglyLinkedList<T> {

    // Inner Node class.
    public class Node<T> {
        private T data;
        private Node next;
        // Properties of the Node class.
        // The two properties should be:
        // 1. data (the data stored in the node).
        // 2. next (a reference (also known as a pointer) to the next node.

        // Constructor of the Node class.
        // The constructor should set the data property of the Node to be the value passed as a parameter.
        // The constructor should set the next property of the Node to be null.
        public Node(T data){
            this.data = data;
            this.next = null;
        }

    }

    // Properties of the Singly Linked List class.
    // The three properties should be:
    // 1. size (records the number of nodes in our Singly Linked List)
    // 2. head (a reference to the first (also known as the head) node in our Singly Linked List).
    // 3. tail (a reference to the last (also known as the tail) node in our Singly Linked List.

    private Node head;
    private int size;
    private Node tail;


    // Constructor.
    // Creates a Singly Linked List with a head node.

    public SinglyLinkedList(T value) {
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        size=1;
    }

    // Methods

    // size
    // returns the size of the Singly Linked List.
    public int size() {
        size = 1;
        if(head==null){
            size = 0;
            return 0;
        }
        else{
            Node curNode = head;
            while(curNode.next!=null){
                size++;
                curNode = curNode.next;
            }
        }
        return size;
    }

    // isEmpty
    // returns whether the Singly Linked List is empty.
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }

    // peekFirst
    // returns the data stored in the head node.
    public T peekFirst() {
        if(isEmpty()){
            throw new RuntimeException("Is Empty.");
        }
        return (T) head.data;
    }

    // peekLast
    // returns the data stored in the tail node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekLast() {
        if(isEmpty()){
            throw new RuntimeException("Is Empty.");
        }
        return (T) tail.data;

    }

    // addFirst
    // Adds a node to the front of the Singly Linked List.
    // If the Singly Linked List is empty,
    public void addFirst(T value) {
        Node newFirst = new Node(value);
        newFirst.next = head;
        head = newFirst;
        size++;

    }

    // addLast
    // Adds a node to the back of the Singly Linked List.
    public void addLast(T value) {
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        tail = newNode;
        size++;

    }

    // insertAt
    // Inserts a node at a specific index.
    // If the index is equal to 0, then we can invoke the addFirst method.
    // If the index is equal to size, then we can invoke the addLast method.
    // throws an illegal argument exception if the index is invalid.
    public void insert(T value, int index) {
        if(index>size()) {
            throw new IllegalArgumentException("Invalid Index");
        }
        else if(index==0){
            addFirst(value);
        }
        else if(index==size()){
            addLast(value);
        }
        else{
            Node newNode = new Node(value);
            Node curNode = head;
            int count = 0;
            while (count < index-1) {
                curNode = curNode.next;
                count++;
            }
            newNode.next = curNode.next;
            curNode.next = newNode;
            size++;
        }


    }

    // removeFirst
    // Removes the first (also known as the head node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the head node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeFirst() {
        if(head.next==null){
            size--;
            head = null;
            return null;
        }
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
            head = null;
        }
        return (T) head.data;
    }

    // removeLast
    // Removes the last (also known as the tail node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the tail node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeLast() {
        if(isEmpty()){
            throw new RuntimeException("Is Empty");
        }
        if(head.next==null){
            head = null;
            size--;
            return null;
        }
        Node last = head;
        int count = 0;
        while(last.next!=tail) {
            last = last.next;
            count++;
        }
        last.next = null;
        tail = last;
        size--;
        if(size==0){
            tail = null;
            return null;
        }
        return (T) tail.data;

    }

    // removeAt
    // Removes a node at a specific index.
    // Returns the data stored in the removed node.
    // If the index is equal to 0, then we can invoke the removeFirst method.
    // If the index is equal to size-1, then we can invoke the removeLast method.
    // throws an illegal argument exception if the index is invalid.

    public T removeAt(int index) {
        if(isEmpty()){
            throw new RuntimeException("Is Empty");
        }
        if(index<0){
            throw new IllegalArgumentException("Invalid Index");
        }
        else if(index>=size()){
            throw new IllegalArgumentException("Invalid Index");
        }
        if(index==0){
            return removeFirst();
        }
        else if(index==size-1){
            return removeLast();
        }
        Node curNode = head;
        int count = 0;
        while (count < index-1) {
            curNode=curNode.next;
            count++;

        }
        curNode.next=curNode.next.next;
        T returner = (T) curNode.next.data;
        size--;
        return returner;

    }

  ;  // contains
    // Determines whether the Singly Linked List contains a node that holds data equivalent to the value passed.
    // Returns a boolean.
    public boolean contains(T value) {
        if(isEmpty()){
            throw new RuntimeException("Is Empty");
        }
        Node check = head;
        for (int i = 0; i < size; i++) {
            if(check.data==value){
                return true;
            }
            check = check.next;
        }
        return false;

    }

    // valueAt
    // Returns the data held in the node at a specified index.
    // Throws an illegal argument exception if the index is invalid.
    public T valueAt(int index) {
        if(isEmpty()){
            return null;
        }
        else if(index<0 || index>=size){
            throw new IllegalArgumentException("Invalid Index");
        }
        Node check = head;
        int count = 0;
        while(count<index){
            check = check.next;
            count++;
        }
        return (T) check.data;

    }

    // reverse
    // Reverses the Singly Linked List.
    public void reverse() {
        Node current = head;
        Node newEnd = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
        tail = newEnd;

    }

    // toString
    // Returns a String representation of the Singly Linked List.
    public String toString() {
        String toString = "";
        Node curNode = head;
        if(size==1){
            toString = head.data.toString() + " -> null";
            return toString;

        }
        if(curNode==null){
            return null;
        }
        while(curNode.next!=null){
            toString= toString + curNode.data.toString() + " -> ";
            curNode = curNode.next;
        }
        toString+= tail.data.toString() + " -> null";
        return toString;

    }

}
