public class QueenBoard{
    private int[][] board;
    
    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < size; i++){
	    for(int x = 0; x < size; x++){
		board[i][x] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c){
	board[r][c] = -1;
	for(int j = c; i< board.length && r <board.length ;j++){
	}
	return true;
    }

    private boolean removeQueen(int r,int c){
	if(board[r][c] != 0){
	    return false;
	}
	
	board[r][c] = 0;
	for(int j = c + 1; j< board.length; j++){
	    board[r][j] -= 1;
	}
	for(int i = r + 1,int j= c + 1;i < board.length && j < board.length; i++,j++){
	    board[r][j] -= 1;
	}
	return true;
    }

    public String toString(){
	String res = "";
	for(int i = 0; i < board.length; i++){
	    res += "[ ";
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j] == -1){
		    res += "Q";
		}
		else{
		    res += board[i][j] + " ";
		}
	    }
	    res += "]"+"\n";
	}
	return res;
    }


    public boolean solve(int col ){
	if(col == data.length){
	    return true;
	}
	for(int r = 0;r<data.length;r++){
	    if(addQueen(r,col)){
		solve(col+1);
	    }
	    
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	System.out.println(a.toString());
    }
}
