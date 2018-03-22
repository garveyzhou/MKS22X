public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length);
    }

    private static void msort(int[]data,int[]temp,int lo , int hi){
	if (lo <= hi){
	    for(int i = 0; i< data.length; i++){
		temp[i] = data[i];
	    }
	    int mid = (hi+lo)/2;
	    msort(temp,data,lo,mid);
	    msort(temp,data,mid+1,hi);
	}
	else{merge(temp,data,lo,hi);}
    }

     private static void swap(int[]ary,int a, int b){                  
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    private static void merge(int[] data,int[]temp,int lo , int hi){
	if(data[lo] > data[hi]){
	    swap(data,lo,hi);
	}
    }

}
