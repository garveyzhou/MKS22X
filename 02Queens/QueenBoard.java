public class QueenBoard{
    private int[][] board;
    private int count;
    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < size; i++){
	    for(int x = 0; x < size; x++){
		board[i][x] = 0;
	    }
	}
    }

    public boolean addQueen(int r, int c){
	if(c >= board.length || r >= board.length || board[r][c] != 0){
	    return false;
	}
	for(int i = 0; i < board.length; i ++){
	    if(board[i][c] == -1){
		return false;
	    }
	}
	board[r][c] = -1;
	for(int i = c + 1 , count = 1; i < board.length ;i++,count++){
	    if(r+count < board.length ){
		board[r+count][i] += 1;
	    }
	    if(r-count >= 0 ){
		board[r-count][i] += 1;
	    }
	    board[r][i] += 1;
	}
	return true;
    }

    public  boolean removeQueen(int r,int c){
	if(r >= board.length || c >= board.length){
	    return false;
	}
	if(board[r][c] != -1){
	    return false;
	}
	board[r][c] = 0;
	for(int i = c + 1 , count = 1; i < board.length ;i++,count ++){
	    if(r+count < board.length ){
		board[r+count][i] -= 1;
	    }
	    if(r-count >= 0 ){
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
		    res += "Q ";
		}
		else{
		    res += "_ ";
		}
	    }
	    res += ""+"\n";
	}
	return res;
    }


    public boolean solve(int col ){
	if(col == 0){
	    for(int i =0; i <board.length ; i ++){
		for(int j = 0; j<board.length ; j++){
		    if(board[i][j] != 0){
			throw new IllegalStateException();
		    }
		}
	    }
	}
	if(col == board.length){
	    return true;
	}
	for(int r = 0;r<board.length;r++){
	    if(addQueen(r,col)){
		if(solve(col+1)){
		    return true;
		}
	    }
	    removeQueen(r,col);
	}
	return false;
    }
    public int countSolutions(){
	for(int i =0; i <board.length ; i ++){
	    for(int j = 0; j<board.length ; j++){
		if(board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	counthelp(0);
	return count;
    }

    public void counthelp(int col){
	if(col == board.length){
	    count++;
	    //System.out.println(toString());
	}
	for(int r = 0;r<board.length;r++){
	    if(addQueen(r,col)){
		counthelp(col+1);
		//System.out.println(count);
	    }
	    removeQueen(r,col);
	}
    }
    
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	System.out.println(a.toString());
	System.out.println(a.countSolutions());
	System.out.println(a.toString());
    }
}
