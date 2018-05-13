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
	if(size >= data.length){
	    resize();
	}
	data[size] = s;
	size++;
	swapUp(size - 1);
    }
    
    public T remove(){
	T s = data[0];
	swap(0, size-1);
	size--;	
	swapDown(0);	
	return s;
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
	    str += data[i] + " , ";
	}
	return str + " ]";
    }

    public T peek(){
	return data[0];
    }
   
    public void swap (int a, int b){
	T c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
    
    public void swapUp(int index){
	int parent = (index - 1)/2;
	if(index != 0){
	    if(max && data[index].compareTo(data[parent]) > 0){
		swap(index,parent);}
	    else if(max && data[index].compareTo(data[parent]) > 0){
		swap(index,parent);}
	    swapUp(parent);
	}
    }
    public void swapDown(int index){
	int left = index*2+1;
	int right = index*2+2;
	if( right < size){
	    if (max){
		if(data[left].compareTo(data[right]) < 0){
		    if(data[index].compareTo(data[left]) < 0){
			swap(index, left);	    
			swapDown(left);
		    }
		}
		else{if(data[index].compareTo(data[right]) < 0){
			swap(index, right);	    
			swapDown(right);		
		    }
		}
	    }
	    if(!max){
		if(data[left].compareTo(data[right]) > 0){
		    if(data[index].compareTo(data[left]) > 0){
			swap(index, left);	    
			swapDown(left);
		    }
		}
		else{if(data[index].compareTo(data[right]) > 0){
			swap(index, right);	    
			swapDown(right);		
		    }
		}
	    }
	}
    }
}
	    
	
