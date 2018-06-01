public class RunningMedian{
    private MyHeap<Double> max;
    private MyHeap<Double> min;

    public RunningMedian(){
	min = new MyHeap<>(false);
	max = new MyHeap<>(true);
    }

    public void add(double n){
	if(min.size() == 0){
	    min.add(n);
	}	
	else if (getMedian() > n){
	    min.add(n);
	}
	else if(getMedian() < n){
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
	else{
	    return (max.peek() + min.peek())/2;
	}
    }

    public String toString(){
	return "max:" + max.toString() + "min:"+ min.toString();
    }
    public static void main(String[]args){
	
	RunningMedian x = new RunningMedian();

	x.add(1);
	//System.out.println("median: " + x.getMedian());
	x.add(2);
	//System.out.println("median: " + x.getMedian());
	x.add(10);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	x.add(7);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	x.add(0);
	System.out.println("median: " + x.getMedian());
	x.add(5);
	System.out.println("median: " + x.getMedian());
	
    }
    
}
