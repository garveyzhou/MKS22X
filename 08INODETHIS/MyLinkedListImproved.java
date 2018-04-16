import java.util.*;
public class MyLinkedListImproved<T> extends Comparable<T> implements Iterable<T>{
    private Node first;
    private Node last;
    private int size;
    
    public MyLinkedListImproved(){
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
       
    public T get(int index){
	if( index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getData();			 
    }
    
    public T set(int index,T value){
	if( index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	T v = getNode(index).getData();
	getNode(index).setData(value);
	return v;
    }
    
    public int size(){
	return size;
    }
    
    public void add(int index,T value){
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
    
    public boolean remove(T value){
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
    
    public T remove(int index){
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
    
    public Integer IndexOf(T value){
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
        private class Node{
	private Node prev;
	private Node next;
	private T data;
	public Node(T info){
	    prev = null;
	    next = null;
	    data= info;
	}
	public T getData(){
	    return data;
	}
	public void setData(T value){
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
    
    private class Iter implements Iterator<T>{
	Node next;
	public Iter(Node n){
	    next = n;
	}
	public boolean hasNext(){
	    return next.getNext().equals(null);
	}
	public T next(){
	    return next.getData();
	}
	public void remove(){
	}
    }

    public Iterator<T> iterator(){
	return new Iter(first);
    }

    public int max(){
	if(size == 0){
	    return -1;
	}
	T max = first.getData();
	int index  = 0;
	int maxIndex = 0;
	for(T data : this){
	    if(data.compareTo(max) > 0){
		max = data;
		maxIndex = index;
	    }
	    index++;
	}
	return maxIndex;   
    }
    public int min(){
	if(size == 0){
	    return -1;
	}
	T min = first.getData();
	int index  = 0;
	int minIndex = 0;
	for(T data : this){
	    if(data.compareTo(min) < 0){
		min = data;
		minIndex = index;
	    }
	    index++;
	}
	return minIndex ; 
    }
}
