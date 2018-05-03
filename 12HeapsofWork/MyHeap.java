public class MyHeap<T extends Comparable<T>>{
    private boolean max;
    private T[] data;
    private int size;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	max = true;
        size = 0;
	data = (T[])new Comparable[10];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean a){
	max = a;
	size = 0;
	data = (T[])new Comparable[10];
    }

    public int size(){
	return size;
    }
    
    public void add(T s){
	if(size == data.length){
	    resize();
	}
	data[size] = s;
	size++;
	pushUp();
    }
    
    public T remove(){
	T s = data[0];
	swap(0, size()-1);
	length--;	
	pushDown();	
	return s;
    }
    
    public void swap (int a, int b){
	T c = data[a];
	data[a] = data[b];
	data[b] = c;
    }

      @SuppressWarnings("unchecked")
      private void resize(){
	  T[] temp = (T[])new Comparable[2*size];
	  for (int i = 0; i < size; i++){
	      temp[i] = data[i];
	  }
	  data = temp;	
      }

    public String toString(){
	String str = "[ ";
	for(int i = 0; i <size;i++){
	    line += data[i] + " , ";
	}
	return str + " ]";
    }

    public T peek(){
	return data[0];
    }

    public void pushUp(){
	
    }
    public void pushDown(){
    }
		     
