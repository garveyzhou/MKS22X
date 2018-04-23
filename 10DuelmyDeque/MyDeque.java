import java.util.*;
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

    public void addFirst(T ele ){
	if (ele == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if(size == 0){
	    first = 0;
	    last = 0;
	    data[first] = ele;
	}
	else if(first == 0){
	    first = data.length - 1;
	    data[first] = ele;
	}
	else{first --;
	    data[first] = ele;
	}
	size++;
    }

    public void addLast(T ele){
	if (ele == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if(size == 0){
	    first = 0;
	    last = 0;
	    data[first] = ele;
	}
	else if( last  == data.length - 1){
	    last = 0;
	    data[last] = ele;
	}
	else{last++;
	    data[last] = ele;
	}
	size++;
    }

    public T removeFirst(){
        if (size == 0){
	    throw new NoSuchElementException();
	}
	T rem = data[first];
	data[first] = null;
	if(first == data.length - 1){
	    first = 0;
	}
	else{first++;}
	size--;
	return rem;
    }

    public T removeLast(){
	if (size == 0){
	  throw new NoSuchElementException();
	}
	T rem = data[last];
	data[last] = null;
	if(last == 0){
	    last = data.length - 1;
	}
	else{last--;}
	size--;
	return rem;
    }

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[first];
    }

    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[last];
    }

     @SuppressWarnings("unchecked")
     public void resize(){
	 T[]temp =  (T[]) new Object[size * 2];
	 if(first > last){
	     int index = 0;
	     for(int i = first; i < size; i++){
		 temp[index]= data[i];
		 index++;
	     }
	     for(int i = 0 ; i <= last; i++){
		 temp[index] = data[i];
		 index++;
	     }
	 }
	 else{for(int i = 0;i < size; i++){
		 temp[i] = data[i];
	     }
	 }
	 data = temp;
	 first = 0;
	 last = size - 1;
     }

    public String toString(){
	String s = "";
	for(int i = 0; i< data.length; i++){
	    s += data[i];
	}
	return s;
    }

 
}
