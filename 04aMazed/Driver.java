import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args){
	try{
	    Maze f = new Maze("data.txt");
	    System.out.println(f.solve());
	}
	catch(FileNotFoundException e){System.out.println("Error");}
	try{
	    Maze a = new Maze("maze.txt");
	    a.setAnimate(true);
	    System.out.println( a.solve());
	    Maze b = new Maze("maze1.txt");
	    b.setAnimate(true);
	    System.out.println( b.solve());
	    Maze c = new Maze("maze3.txt");
	    c.setAnimate(true);
	    System.out.println( c.solve());
	}
	catch (FileNotFoundException e){
	    System.out.println("Error");
	}
    }
}
