public class MyLinkedList{
    private Node first;
    private Node last;
    private int size;

    private class Node{
	private Node prev;
	private Node next;
	private Integer data;
	public Node(Integer info){
	    prev = null;
	    next = null;
	    data= info;
	}
	public Integer getData(){
	    return data;
	}
	public void setData(Integer value){
	    data = value;
	}
	public void setNext(Node n){
	    next = n;
	}
	public Node getNext(){
	    return next;
	}
	public void setPrev(Node p){
	    prev = p;
	}
	public Node getPrev(){
	    return prev;
	}
	public String toString(){
	    String s = "";
	    s += data + "";
	    return s;
	}
    }
    
    public MyLinkedList(){
	size = 0;
    }
    
    public String toString(){
	String str = "{";
	Node current = first;
	while(current != null){
	    str += current;
	    if(current.getNext() != null){
		str += ",";
	    }
	    current = current.getNext();
	}
	return str + "}";
    }
    
    private Node getNode(int n){
	Node current = first;
	for(int i = 0; i< n; i++){
	    current = current.getNext();
	}
	return current;
    }
       
    public int get(int index){
	if( index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getData();			 
    }
    
    public Integer set(int index,Integer value){
	if( index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Integer v = getNode(index).getData();
	getNode(index).setData(value);
	return v;
    }
    
    public int size(){
	return size;
    }
    
    public void add(int index,Integer value){
	Node a = new Node(value);
	if( index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	else if(index == size){
	    add(value);
	}
	else if(index == 0){
	    first.setPrev(a);
	    a.setNext(first);
	    first = a;
	}
	else{
	a.setNext(getNode(index));
	a.setPrev(getNode(index-1));
	a.getNext().setPrev(a);
	a.getPrev().setNext(a);
	}
	size++;
    }
    
    public boolean add(Integer value){
	Node a = new Node(value);
	if (size == 0){
	    first = a;
	}
	else{
	    last.setNext(a);
	    a.setPrev(last);
	}
	last = a;
	size++;
	return true;
    }
    
    public boolean remove(Integer value){
	Node current = first;
	for(int i = 0; i< size; i++){
	    if(current.getData().equals( value)){
		remove(i);
		return true;
	    }
	    current = current.getNext();
	}
	return false;
    }
    
    public Integer remove(int index){
	if( index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node current = getNode(index);
	Integer rm = current.getData();
	if(size == 1){
	    first  = null;
	    last = null;
	}
	else if(index == size -1){
	    last.getPrev().setNext(null);
	    last = last.getPrev();
	}
	else if(index == 0){
	    first.getNext().setPrev(null);
	    first = first.getNext();
	}
	else{
	    current.getPrev().setNext(current.getNext());
	    current.getNext().setPrev(current.getPrev());
	}
	size --;
	return rm;
    }
    
    public Integer IndexOf(Integer value){
	Node current = first;
	for(int i = 0; i<size; i++){
	    if(current.getData().equals(value)){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }
    
    public void clear(){
	first = null;
	last = null;
	size = 0;
    }


    
    //Crystal's driver
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();

	System.out.println("Testing add(Integer value)");
	for (int i = 0; i < 10; i++){
	    a.add(new Integer(i));
	    System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
	} //adds the integers from 0 to 9 inclusive and prints out the LinkedList

	System.out.println("\nTesting get(int index)");
	for (int i = 0; i < 10; i++){
	    System.out.println("index: " + i + " data: " + a.get(i));
	} //prints the integers from 0 to 9 inclusive

	System.out.println("\nTesting exception for get(int index)");
	try{
	    System.out.println(a.get(10));
	    System.out.println(a.size());
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.get(-1));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	for (int i = 0; i < 10; i++){
	    a.add(new Integer(i));
	}

	System.out.println("\nTesting indexOf(Integer value)");
	for (int i = 0; i < 10; i++){
	    System.out.println("Value: " + i + " Index: " + a.IndexOf(i));
	} //prints 0 to 9 inclusive

	System.out.println("\nTesting remove(Integer value)");
	for(int i = 0; i < 10; i++){
	    a.remove(new Integer(i));
	    System.out.println(a);
	} //removes first half of the LinkedList

	System.out.println("\nTesting set(int index, Integer value)");
	for (int i = 0; i < 10; i++){
	    a.set(i, new Integer(i * 10));
	    System.out.println(a);
	} //sets the data of each node to 10 * index

	System.out.println("\nTesting exceptions for set(int index, Integer value)");
	try{
	    System.out.println(a.set(-1, new Integer(1)));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.set(10, new Integer(1)));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesing add(int index, Integer value)");
	for (int i = 0; i < 9; i++){
	    a.add(i, new Integer(i * 3));
	    System.out.println("index added: " + i + " LinkedList: " + a.toString());
	} //adds multiples of 3 up to 24 to the LinkedList at the beginning
	a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
	System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

	System.out.println("\nTesting exceptions for add(int index, Integer value)");
	try{
	    a.add(-1, new Integer(5));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    a.add(21, new Integer(5));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesting remove(int index)");
	System.out.println("Original LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
	System.out.println("LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
	System.out.println("LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
	System.out.println("LinkedList: " + a.toString());

	System.out.println("\nTesting exceptions for remove(int index)");
	try{
	    System.out.println(a.remove(-1));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.remove(17));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesting clear()");
	a.clear();
	System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
    }
    
}
