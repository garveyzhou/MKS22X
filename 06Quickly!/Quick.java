import java.util.*;
public class Quick{

    public static int partition(int[] data, int start, int end){
	int pivot = (int)(Math.random()*(end-start)+start);
	swap(data,start,pivot);
	int i = start + 1;
	int lt = start + 1 ;
	int gt = end;
	while (i <  gt){
	    if(data[i] ==  data[start]){
		i++;
	    }
	    else if(data[i] > data[start]){
		swap(data,i,gt);
		gt-- ;
	    }
	    else{swap(data,i,lt);
		i++;
		lt++;
	    }
	}
	swap(data,start,gt);
	return gt;
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
	int in = partition(data,start,end);
	while(in != k){
	    if (in < k){
	        start = in + 1;
	    }
	    else{end = in - 1;}
	    in = partition(data,start,end);
	}
	return data[in];	
    }

    public static void quickSort(int[] data){

    }
    public static void main(String[]args){
	int[] a = {1,2,1,3,0,2,0,0,1,0,2,3};
	for(int i = 0; i< 10;i++){
	    System.out.println(partition(a,0,11));
	    System.out.println(toString(a));
	}
    }
}
