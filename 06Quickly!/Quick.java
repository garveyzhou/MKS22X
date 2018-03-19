import java.util.*;
public class Quick{

    public static int[] partition(int[] data, int start, int end){
	int pivot = (int)(Math.random()*(end-start)+start);
	swap(data,start,pivot);
	int i = start + 1;
	int pivotal = data[start];
	int lt = start ;
	int gt = end;
	while (i <=  gt){
	    if(data[i] ==  pivotal){
		i++;
	    }
	    else if(data[i] > pivotal){
		swap(data,i,gt);
		gt-- ;
	    }
	    else{swap(data,i,lt);
		i++;
		lt++;
	    }
	}
	int[] a = {lt,gt};
	return a;
    }

    private static void swap(int[]ary,int a, int b){                  
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    public static String toString(int[] data){
	String s = "[";
	for(int i =0; i<data.length; i++){
	    s += data[i] + " ";
	}
	s += "]";
	return s;
    }
    
    public static int quickselect(int[]data,int k){
	int start = 0;
	int end = data.length -1;
	int[] ends = partition(data,start,end);
	while(ends[0] > k || ends[1] < k ){
	    if(k < ends[0]){
		end = ends[0]-1;
	    }
	    if(k > ends[1]){
		start = ends[1] + 1;
	    }
	   ends =  partition(data,start,end);
	}
		
	return data[ends[0]];
    }

    public static void quicksort(int[] data){
	quickSortH(data,0,data.length -1);
    }

    public static void quickSortH(int[] data,int start,int end){
	if (start <end){
	    int pivot = (int)(Math.random()*(end-start)+start);
	    swap(data,start,pivot);
	    int i = start + 1;
	    int pivotal = data[start];
	    int lt = start ;
	    int gt = end;
	    while (i <=  gt){
		if(data[i] ==  pivotal){
		    i++;
		}
		else if(data[i] > pivotal){
		    swap(data,i,gt);
		    gt-- ;
		}
		else{swap(data,i,lt);
		    i++;
		    lt++;
		}
	    }
	    quickSortH(data,0,lt-1);
	    quickSortH(data,gt+1,end);
	}
    }

    public static void main(String[]args){
	int[] a = {1,2,1,3,0,2,0,0,1,0,2,3};
	for(int i = 0; i< a.length;i++){
	    //System.out.println(partition(a,0,11));
	    //System.out.println(toString(a));
	    //System.out.println(quickselect(a,i));
	}
	quicksort(a);
	System.out.println(toString(a));
    }
    
}
