public class KnightBoard{
    private int[][] board;
    private final int[][] moves = {{-2,1} , {-2,-1} , {-1,-2} , {1,2} , {2,-1} , {2,1} , {1,-2}, {-1,2} }; 
    private int solutions;
    
    public KnightBoard(int r, int c){
	if( r < 0 || c < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[r][c];
	for (int i = 0; i < r; i++){
	    for(int j = 0; j < c; j++){
		board[i][j] = 0;
	    }
	}
	solutions = 0;
    }

    public String toString(){
	String res = "";
	for(int i = 0; i <board.length;i++){
	    for(int j = 0; j <board[0].length;j++){
		if ( board [i][j] == 0){
		    res += "_ ";
		}
		else if( board[i][j] < 10){
		    res+= " "+board[i][j]+ " ";
		}
		else{res += " " + board[i][j];}
	    }
	    res += "\n";
	}
	return res;
    }
    
    public boolean solve(int row,int col){
	if(row >= board.length || col >= board[0].length || row < 0 || col < 0){
	    throw new IllegalArgumentException();
	}
	for(int i = 0; i < board.length; i++){
	    for(int j =0; j< board.length; j++){
		if(board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return help(row,col,1);
    }

    public boolean help(int row,int col, int step){
	if ( step > board.length * board[0].length){
	    return true;
	}
	for (int i = 0; i < 8 ; i++){
	    try{
		if(board[row][col] == 0){
		    board[row][col] = step;
		    //System.out.println(toString());
		    if(help(row + moves[i][0] ,col + moves[i][1], step+1) ){
			return true;
		    }
		    else{board[row][col] = 0;}
		}
	    }
	    catch(ArrayIndexOutOfBoundsException e){}	
	}
	return false;
    }
    
    public int countSolutions(int row,int col){
	if(row >= board.length || col >= board[0].length || row < 0 || col < 0){
	    throw new IllegalArgumentException();
	}
	for(int i = 0; i < board.length; i++){
	    for(int j =0; j< board.length; j++){
		if(board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	countH(row,col,1);
	int temp = solutions;
	solutions = 0;
	return temp;
    }

    public void countH(int row, int col,int level){
	if(level ==  board.length * board[0].length){
	    solutions ++;
	}
	for (int i = 0; i < 8 ; i++){
	    try{
		if(board[row + moves[i][0]][col + moves[i][1]] == 0){
		    board[row][col] = level;
		    countH(row + moves[i][0] ,col + moves[i][1], level +1);
		    board[row][col] = 0;
		}
	    }
	    catch(Exception e){}	
	}
    }
    //Crystal's driver
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3,3);

	System.out.println(a);
	/* Prints
	   _ _ _
	   _ _ _
	   _ _ _
	*/

	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (a.solve(i,j)){
		    System.out.println("There is an error with your solve method");
		}
	    }
	} //prints nothing

	System.out.println(a.countSolutions(0,0)); //prints 0



	KnightBoard b = new KnightBoard(5,5);
	System.out.println(b.solve(0,0)); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    KnightBoard b1 = new KnightBoard(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(0,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"



	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		KnightBoard abc = new KnightBoard(5,5);
		System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	    }
	}
	KnightBoard c = new KnightBoard(5,5);

	int totalSol = 0;
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	    }
	}

	System.out.println(totalSol); //prints 1728

	KnightBoard d = new KnightBoard(5,5);
	System.out.println(d.countSolutions(0,0)); //prints 304

    }
}
