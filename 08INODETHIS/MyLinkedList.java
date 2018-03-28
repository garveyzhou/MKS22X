public class MyLinkedList{
    private Node previous;
    private Node next;
    private int data;

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
    


    
}
