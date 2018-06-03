public class RunningMedian{
    private MyHeap<Double> small;
    private MyHeap<Double> large;

    public RunningMedian(){
	small = new MyHeap<>(true);
	large = new MyHeap<>(false);
    }

    public void add(double n){
	if(small.size() == 0){
	    small.add(n);
	}	
	else if (small.peek() > n){
	    small.add(n);
	}
	else{
	    large.add(n);
	}

	System.out.println(small.toString());
	System.out.println(large.toString());
	if(small.size() - large.size() > 1){
	    large.add(small.remove());
	}
	else if(large.size() - small.size() > 1){
	    small.add(large.remove());
	}
    }

    public double getMedian(){
	if(small.size() > large.size()){
	    return small.peek();
	}
	else if(large.size()> small.size()){
	    return large.peek();
	}
	else{
	    return (large.peek() + small.peek())/2;
	}
    }

    public String toString(){
	return "big:" + large.toString() + "small:"+ small.toString();
    }
    public static void main(String[]args){
	
	RunningMedian x = new RunningMedian();

	x.add(1);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	x.add(2);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	x.add(10);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	x.add(7);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	/*x.add(0);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	x.add(5);
	System.out.println(x.toString());
	System.out.println("median: " + x.getMedian());
	*/
    }
    
}
