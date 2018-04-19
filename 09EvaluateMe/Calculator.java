import java.util.*;
public class Calculator{
    @SuppressWarnings("unchecked")
    public static Double eval(String e){
	String[] tokens = e.split(" ");
	
	Stack<Double> Tokens = new Stack();
	for(int i = 0; i < tokens.length; i++){
	    if(tokens[i].equals("+")){
		Tokens.push(Tokens.pop() + Tokens.pop());
	    }
	    else if(tokens[i].equals("-")){
		Double a = Tokens.pop();
		Tokens.push( Tokens.pop() - a);
	    }
	    else if(tokens[i].equals("*")){
		Double a = Tokens.pop();
		Tokens.push(a * Tokens.pop());
	    }
	    else if(tokens[i].equals("/")){
		Double a = Tokens.pop();
		Tokens.push(Tokens.pop()/a);
	    }
	    else if(tokens[i].equals("%")){
		Double a = Tokens.pop();
		Tokens.push( Tokens.pop() % a);
	    }
	    else{Tokens.push(Double.parseDouble(tokens[i]));
		
	    }
	}

	return Tokens.pop();
	
	
    }

    public static void main(String[] args){
	System.out.println(eval("10.0 2.0 -"));
	System.out.println(eval("10.0 2.0 - 2 %"));
	System.out.println(eval("10.0 2.0 - 5 +"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
