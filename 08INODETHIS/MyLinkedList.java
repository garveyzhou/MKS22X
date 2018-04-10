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
	    next = b;
	    data= info;
	}
	public int getData(){
	    return data;
	}
	public int setData(int value){
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
	    if(current.getNext() != Null){
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
	return getNode(n).getData();			 
    }
    
    public void set(int index,int value){
	if( index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	getNode(index).setData(value);
    }
    
    public int size(){
	return size;
    }
    
    public void add(int index,int value){
	if( index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node a = Node(getNode(index - 1),getNode(index),value);
	getNode(index-1).setNext(a);
	getNode(index + 1).setPrev(a);
    }
    
    public boolean add(int newData){
	Node ToAdd = newNode(newData);
	if (length == 0){
	    first = ToAdd;
	}
	else{
	    last.setNext(ToAdd);
	    add.setPrev(last);
	}
	last = ToAdd;
	size++;
	return true;
    }
    
    public boolean remove(int value){
    }
    
    public void remove(int index){
	if( index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}

    }
    
    public int getIndexOf(int value){
    }
    
    public void clear(){
	first = null;
	last = null;
	size = 0;
    }

    
}
