import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
      throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename)throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
	animate = false;
	File f = new File(filename);
	Scanner s = new Scanner(f);
	String str = "";
	int cols = 0;
	int rows = 0;
	while( s.hasNextLine()){
	    String m = s.nextLine();
	    cols = m.length();
	    str += m ;
	    rows ++;
	}
	maze = new char[rows][cols];
	int start = 0;
	int end = 0;
	int i = 0;
	for(int r = 0; r < rows; r++){
	    for(int c = 0;c <cols; c++){
		if(str.charAt(i) == 'S'){
		    start++;
		}
		if(str.charAt(i) == 'E'){
		    end++;
		}
		maze[r][c] = str.charAt(i);
		i++;
	    }
	}
	if( start != 1 || end != 1){
	    throw new IllegalStateException();
	}
    }
	
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public String toString(){
	String res = "";
	for(int i = 0 ; i< maze.length; i++){
	    for(int j = 0; j <maze[0].length; j++){
		res += maze[i][j];
	    }
	    res += "\n";
	}
	return res;
    }
    
    public int solve(){
	//find the location of the S. 
	for (int r = 0 ; r < maze.length ; r++){
	    for(int c = 0 ; c <maze[0].length ; c++){
		if(maze[r][c] == 'S'){
		    //erase the S
		    maze[r][c] = '@';
		    //and start solving at the location of the s.
		    return solve(r,c,1);
		}
	    }
	}
	return -1;
    }

    /*
      Recursive Solve function:
      A solved maze has a path marked with '@' from S to E.
      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.
      Postcondition:
      The S is replaced with '@' but the 'E' is not.
      All visited spots that were not part of the solution are changed to '.'
      Note: This is not required based on the algorithm, it is just nice visually to see.
      All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int steps){ //you can add more parameters since this is private

	//automatic animation! You are welcome.
	
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	
	if(maze[row][col] == 'E'){
	    return steps;
	}
	
	for (int i = 0; i< moves.length; i++){
	    maze[row][col] = '@';
	    if(maze[row + moves[i][0]][col + moves[i][1]] == ' ' || maze[row + moves[i][0]][col + moves[i][1]] == 'E'){
		int next = solve(row + moves[i][0],col + moves[i][1], steps+1);
		if(next != -1){
		    return next;
		}
	    }
	    maze[row][col] = '.';
	}
	return -1; //so it compiles
    }
    public static void main (String[]args){
	try{
	    Maze a = new Maze("maze.txt");
	    a.setAnimate(true);
	    a.solve();
	    Maze b = new Maze("maze1.txt");
	    b.setAnimate(true);
	    b.solve();
	}
	catch (FileNotFoundException e){
	}
    }
}
