import java.util.*;
public class Quick{

    public int partition(int[] data, int start, int end){
	int pivot = (int)(Math.random()*data.length);
	swap(data,pivot,0);
	for (int i = 1; i < data.length && start < end; i++){
	    if(data[pivot] >= data[i]){
		swap(data,i,start);
		start++;
	    }
	    else{ swap(data,i,end);
		end--;
		i--;
	    }
	}
	swap(data,0,start);
	return start;
	
    }

    private static void swap(int[]ary,int a, int b){                  
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }
}
