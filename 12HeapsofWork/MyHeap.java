public class MyHeap<T extends Comparable<T>>{
    private boolean max;
    private T[] data;
    private int size;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	max = true;
	length = 0;
	data = (T[])new Comparable[10];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean a){
	max = a;
	length = 0;
	data = (T[])new Comparable[10];
    }

    public void add(T s){
	if(length == 0){
	    data[0] = s;
	}
	else if(){
	}
    }

    
		     
