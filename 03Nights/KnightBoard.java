public class KnightBoard{
    private int[][] board;
    private int[][] moves;
    
    public KnightBoard(int r, int c){
	moves = new int[8][2];
	moves = {{-2,1} , {-2,-1} , {-1,-2} , {1,2} , {2,-1} , {2,1} , {1,2}, {-1,2} }; 
	board = new int[r][c];
	for (int i = 0; i < r, i++){
	    for(int j = 0; j < c; j++){
		board[i][j] = 0;
	    }
	}
    }

    public String toString(){
	String res = "";
	for(int i = 0; i <board.length;i++){
	    for(int j = 0; j <board[0].length;j++){
		if ( board [i][j] == 0){
		    res += "_ ";
		}
		else{res += board[i][j] + " ";}
	    }
	}
    }
    
    public boolean solve(int row,int col){
	if(row >= board.length || col >= board[0].length || row < 0 || col < 0){
	    throw new IllegalArgumentException();
	}
	for(int i = 0; i < board.length; i++){
	    for(int j =0; j< board.length; j++){
		if(board[i][j] != 0){
		    throw new IllegalStateException;
		}
	    }
	}
	for( int i = 0; i < 8; i++){
	    
	}    
    }

    public boolean help(int row,int col, int type){
	
    }
    
    public int countSolutions(int row,int col){

    }
    
}
