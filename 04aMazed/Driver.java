import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args){
	try{
	    Maze f = new Maze("data.txt");
	    System.out.println(f.solve());
	}
	catch(FileNotFoundException e){}
	try{
	    Maze a = new Maze("maze.txt");
	    a.setAnimate(true);
	    System.out.println( a.solve());
	    Maze b = new Maze("maze1.txt");
	    b.setAnimate(true);
	    System.out.println( b.solve());
	}
	catch (FileNotFoundException e){
	}
    }
}
