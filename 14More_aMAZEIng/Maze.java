import java.util.*;
import java.io.*;
public class Maze{
    private Location start,end;
    private char[][] board;

    public Maze(String mazeText)throws FileNotFoundException{
	File f = new File(mazeText);
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
	board = new char[rows][cols];
	int startC = 0;
	int endC = 0;
	int i = 0;
	for(int r = 0; r < rows; r++){
	    for(int c = 0;c <cols; c++){
		if(str.charAt(i) == 'S'){
		    startC++;
		    start = new Location(c,r,null);
		}
		if(str.charAt(i) == 'E'){
		    endC++;
		    end = new Location(c,r,null);
		}
		board[r][c] = str.charAt(i);
		i++;
	    }
	}
	if( startC != 1 || endC != 1){
	    throw new IllegalStateException();
	}
    }

    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // '@' - part of solution
    // 'S' - starting space (do not replace this)
    public void set(int r, int c , char a){
	board[r][c] = a;
    }
    
    public String toString(){
	String str = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		str += board[i][j];
	    }
	    str +='\n';
	}
	return str;
    }
   
    // Work on this method as a group! 
    public String toStringColor(){
	return "";
    }

    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
	int[][] sides = {{0,1},{1,0},{-1,0},{0,-1}};
	Location[] list = new Location[4];
	for(int i = 0;i< 4;i++){
	    if(n.getX() + sides[i][0] >= 0 && n.getX() + sides[i][0]  < board[0].length && n.getY() + sides[i][1] >= 0 && n.getY() + sides[i][1] < board.length){
		if(board[n.getY() + sides[i][1]][n.getX() + sides[i][0]] == ' ' || board[n.getY() + sides[i][1]][n.getX() + sides[i][1]] == 'E'){
		    list[i] = new Location(n.getX() + sides[i][0], n.getY() + sides[i][1], n);
		}
	    }
	}
	return list;
		}

    public Location getStart(){
	return start;
    }

    public Location getEnd(){
	return end;
    }
    
    public static void main(String[] args){
	try{
	    Maze a = new Maze("maze.txt");
	    System.out.println(a.toString());
	}
	catch (FileNotFoundException e){
	}
    }

}
