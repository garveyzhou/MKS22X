public class RunningMedian{
    private MyHeap<Double> max;
    private MyHeap<Double> min;
    
    public RunningMedian(){
	min = new MyHeap<>();
	max = new MyHeap<>(false);
    }

    public void add(double n){
	if(min.size() == 0){
	    min.add(n);
	}
	else if(max.size() == 0){
	    max.add(n);
	}
	
	if (min.peek() > n){
	    min.add(n);
	}
	else if( max.peek() < n){
	    max.add(n);
	}
	
	if(min.size() - max.size() > 1){
	    max.add(min.remove());
	}
	else if(max.size() - min.size() > 1){
	    min.add(max.remove());
	}
    }

    public double getMedian(){
	if(min.size() > max.size()){
	    return min.peek();
	}
	else if( max.size()> min.size()){
	    return max.peek();
	}
	else{ return (max.peek() + min.peek())/2;
	}
    }
}
