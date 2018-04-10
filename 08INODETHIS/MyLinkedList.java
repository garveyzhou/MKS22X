public class MyLinkedList{
    private Node head;
    private Node tail;
    private int size;

    private class Node{
	private Node prev;
	private Node next;
	private int data;
	public Node(int data, Node next,Node prev){
	    data = data;
	    next = next;
	    prev = prev;
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
	    s += "["+ prev + " , " + data + " , " + next + "]";
	    return s;
	}
    }
    public MyLinkedList(){
    }
    
    public String toString(){
    }
    public int get(n){
    }
    public void set(int index,int value){
    }
    public int size(){
    }
    public void add(int index,int value){
    }
    public void remove(int index){
    }

    
}
