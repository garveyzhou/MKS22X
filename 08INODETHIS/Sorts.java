import java.util.*;
public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if (data.size() > 0){
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[]posBucket = new MyLinkedListImproved[10];
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] negBucket= new MyLinkedListImproved[10];
	    for(int i = 0; i< 10;i++){
		posBucket[i] = new MyLinkedListImproved<Integer>();
		negBucket[i] = new MyLinkedListImproved<Integer>();
	    }
	    int max = data.get(data.max());
	    int min = data.get(data.min());
	    int numPasses;
	    if(Math.abs(max) >= Math.abs(min)){
		numPasses = (int)(Math.log10(max));
	    }
	    else{numPasses = (int)(Math.log10(min * -1));
	    }
	    for(int i = 0; i < numPasses; i++){
		for(Integer x : data){
		    if( x >= 0){
			int index= (int)((x / Math.pow(10,i))% 10);
			posBucket[index].add(x);
		    }
		    else{
			int index= (int)((x * -1 / Math.pow(10,i))% 10);
			negBucket[index].add(x);
		    }
		}
		data.clear();
		for(int j = negBucket.length - 1;j > 0;j--){
		    data.concat(negBucket[j]);
		}
		for(int j = 0; j < posBucket.length; j++){
		    data.concat(posBucket[j]);
		}
	    }
	}
    }
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	radixsort(data);
    }
}
		   
		    
