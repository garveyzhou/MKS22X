import java.util.*;
public class Calculator{
    @SuppressWarnings("unchecked")
    public static Double eval(String e){
	int numTokens = 1;
	for(int i = 0; i < e.length(); i++){
	    if(e.substring(i,i+1).equals(" ")){
		numTokens ++;
	    }
	}
	String[] tokens = new String[numTokens];
	int index = 0;
	for(int i = 0; i< e.length(); i++){
	    String current = "";
	    if(e.substring(i,i+1).equals(" ")){
		System.out.println(current);
		tokens[index] = current;
		current = "";
		index++;
	    }
	    else{
		current += e.substring(i,i+1);
	    }
	}
	
	Stack<Double> Tokens = new Stack();
	for(int i = 0; i < tokens.length; i++){
	    if(tokens[i].equals("+")){
		Tokens.push(Tokens.pop() + Tokens.pop());
	    }
	    else if(tokens[i].equals("-")){
		Tokens.push(Tokens.pop() - Tokens.pop());
	    }
	    else if(tokens[i].equals("*")){
		Tokens.push(Tokens.pop() * Tokens.pop());
	    }
	    else if(tokens[i].equals("/")){
		Tokens.push(Tokens.pop()/Tokens.pop());
	    }
	    else{Tokens.push(Double.parseDouble(tokens[i]));
	    }
	}

	return Tokens.pop();
	
	
    }

    public static void main(String[] args){
	System.out.println(eval("10 2 +"));
    }
}
