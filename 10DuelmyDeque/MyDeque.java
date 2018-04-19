public class MyDeque<T>{
    private T[] data;
    private int size;
    private int first;
    private int last;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[]) new Object[10];
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int limit){
	if(limit < 0){
	    throw new IllegalArgumentException();
	}
	data = (T[]) new Object[limit];
	size = 0;
    }
    
    public int size(){
	return size;
    }

    public void addFirst(E){

    }

    public void addLast(E){

    }

    public E removeFirst(){
	return data[first];
    }

    public E removeLast(){
	return data[last];
    }

    public E getFirst(){
	return data[first];
    }

    public E getLast(){
	return data[last];
    }
    
}
