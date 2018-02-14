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
	if(c >= board.length || r >= board.length || board[r][c] != 0){
	    return false;
	}
	board[r][c] = -1;
	for(int i = c + 1 , count = 1; i < board.length ;i++){
	    if(r+count < board.length ){
		board[r+count][i] += 1;
	    }
	    if(r-count > 0 ){
		board[r-count][i] += 1;
	    }
	    board[r][i] += 1;
	}
	return true;
    }

    private boolean removeQueen(int r,int c){
	if(board[r][c] != -1){
	    return false;
	}
	board[r][c] = 0;
	for(int i = c + 1 , count = 1; i < board.length ;i++){
	    if(r+count < board.length ){
		board[r+count][i] -= 1;
	    }
	    if(r-count > 0 ){
		board[r-count][i] -= 1;
	    }
	    board[r][i] -= 1;
	}
	return true;
    }

    public String toString(){
	String res = "";
	for(int i = 0; i < board.length; i++){
	    res += " ";
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j] == -1){
		    res += "Q";
		}
		else{
		    res += board[i][j] + " ";
		}
	    }
	    res += ""+"\n";
	}
	return res;
    }


    public boolean solve(int col ){
	if(col == board.length){
	    return true;
	}
	for(int r = 0;r<board.length;r++){
	    if(addQueen(r,col)){
		solve(col+1);
	    }
	    else{removeQueen(r,col);}
	}
	return false;
    }
	    
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(4);
	System.out.println(a.toString());
	System.out.println(a.solve(0));
	System.out.println(a.toString());
    }
}
