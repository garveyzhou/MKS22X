public class MyLinkedList{
    private Node first;
    private Node last;
    private int size;

    private class Node{
	private Node prev;
	private Node next;
	private int data;
	public Node(Node a,Node b ,int info){
	    prev = a;
	}
	public int getData(){
	    return data;
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
	    s += "[" + data + "]";
	    return s;
	}
    }
    public MyLinkedList(){
	size = 0;
    }
    
    public String toString(){
	String str = "";
	Node current = first;
	while(current != null){
	    str += current;
	    if(current.getNext() != Null){
		str += ",";
	    }
	    current = current.getNext();
	}
	return str;
    }
    private Node  getNode(int n){
	Node current = first;
	for(int i = 0; i< n; i++){
	    current = current.getNext();
	}
	return current;
    }
       
    public int get(int n){
	if( n >= size || n < 0){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(n),getData();			 
    }
    public void set(int index,int value){
    }
    public int size(){
	return size;
    }
    public void add(int index,int value){
    }
    public boolean add(int newData){
	Node add = newNode(newData);
	if (length == 0){
	    first = add;
	}
	else{
	    last.setNext(add);
	    add.setPrev(last);
	}
	last = toAdd;
	size ++;
	return true;
    }
    public boolean remove(int value){
    }
    public void remove(int index){
    }
    public void clear(){
	first = null;
	last = null;
	size = 0;
    }

    
}
