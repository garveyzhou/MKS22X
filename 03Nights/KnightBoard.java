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
	return solutions;
    }

    public void countH(int row, int col,int level){
	if(level >=  board.length * board[0].length){
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
	    catch(ArrayIndexOutOfBoundsException e){}	
	}
    }
    
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(5,5);
	System.out.println(a.solve(5,5));
	//System.out.println(a.toString());
	System.out.println(a.solve(0,0));
	System.out.println(a.countSolutions(0,0));
	System.out.println(a.toString());
    }
}
