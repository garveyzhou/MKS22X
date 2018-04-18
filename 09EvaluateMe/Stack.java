import java.util.*;
public class Stack<T>{
    private LinkedList<T> list;

    public Stack(){
	list = new LinkedList<T>();
    }

    public void push(T value){
	list.add(value);
    }
    
    public T pop(){
	return list.remove(list.size() -1);
    }

    public String toString(){
	String str = "[";
	for(T value: list){
	    str += value + " , ";
	}
	return str + " ] ";
    }
}
