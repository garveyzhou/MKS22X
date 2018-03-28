import java.util.*;
    
public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];

	msort(data,temp,0,data.length-1);
    }

    private static void msort(int[]data,int[]temp,int lo , int hi){
	if (lo < hi){
	    for(int i = lo; i<= hi; i++){
		temp[i] = data[i];
	    }
	    int mid = (hi+lo)/2;
	    msort(temp,data,lo,mid);
	    msort(temp,data,mid+1,hi);
	    merge(data,temp,lo,mid,hi);
	}
    }

     private static void swap(int[]ary,int a, int b){                  
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    private static void merge(int[] data,int[]temp,int lo , int mid, int hi){
	int s1 = lo;
	int s2 = mid + 1;
	int e1 = mid;
	int e2 = hi;
	int i = lo;
	
	while (s1 <= e1 && s2 <= e2){
	    if(temp[s1] <= temp[s2]){
		data[i] = temp[s1];
		i++;
		s1++;
	    }
	    else{
		data[i] = temp[s2];
		i++;
		s2++;
	    }
	}

	while (s1 <= e1){
	    data[i] = temp[s1];
	    i++;
	    s1++;
	}

	while (s2 <= e2){
	    data[i] = temp[s2];
	    i++;
	    s2++;
	}
    }
    
    public static String toString(int[] data){
	String str = "[";
	for (int i = 0; i < data.length; i++){
	    str += data[i];
	    if (i < data.length -1){
		str += ", ";
	    }
	}
	str += "]";
	return str;
    }
    public static void main(String args[]) {
	int [] start = new int[10];
	Random c = new Random();
	for(int i = 0; i < start.length ; i++){
	    start[i] = c.nextInt(100);
	}
	//System.out.println(toString(start));
	int [] result = Arrays.copyOf(start,start.length);
	Arrays.sort(result);

	long startTime = System.currentTimeMillis();
	
	mergesort(start);
        
	long elapsedTime = System.currentTimeMillis() - startTime;
	if(Arrays.equals(start,result)){
	    System.out.println(elapsedTime);
	}
	System.out.println(toString(start));
    }
}
