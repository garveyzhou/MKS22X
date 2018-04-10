public class Recursion{
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if( n == 0){
	    return 1;
	}
	return n *fact(n-1);
    }
    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n < 2){
	    return n;
	}
	return fibHelper(1,n,0,1);
    }

    public int fibHelper(int count,int n,int last2,int last1){
	if (n == count){
	    return last1;
	}
	return fibHelper(count + 1,n,last1,last1 + last2);
    }

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	return helper(n,n/2);
    }

    public double helper(double n, double guess){
	if(((guess * guess / n) < 1.00001) && ((guess * guess / n) > 0.99999)){
	    return guess;
	}
	return helper(n,(n/guess +guess)/2);
    }
    public static void main(String[]args){
	Recursion rec = new Recursion();
	System.out.println(rec.fib(0)); //0
	System.out.println(rec.fib(1)); //1
	System.out.println(rec.fib(2)); //1
	System.out.println(rec.fib(3)); //3
	System.out.println(rec.fib(6)); //8
	System.out.println(rec.fact(10));
	System.out.println(rec.fact(1));
	//System.out.println(rec.fact(-100));
	System.out.println(rec.sqrt(0));
	//System.out.println(rec.sqrt(-10));
	System.out.println(rec.sqrt(1));
	System.out.println(rec.sqrt(0.0036));
	//System.out.println(rec.fib(-11)); 
    }
}
