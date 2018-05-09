import java.util.*;
import java.io.*;

public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText)throws FileNotFoundException{
      maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
      if(mode == 0){
	  frontier = new FrontierQueue();
      }
      if(mode == 1){
	  frontier = new FrontierStack();
      }
      frontier.add(maze.getStart());
      Location end = maze.getEnd();
      while(frontier.hasNext()){
	  Location next = frontier.next();
	  if(next.getX() == end.getX() && next.getY() == end.getY()){
	      return true;
	  }
	  Location[] neighbors = maze.getNeighbors(next);
	  for(int i = 0; i< neighbors.length;i++){
	      if(neighbors[i].getX() == end.getX() && neighbors[i].getY() == end.getY()){
		  return true;
	      }
	      frontier.add(neighbors[i]);
	      maze.set(neighbors[i].getY(),neighbors[i].getX(),'?');
	  }
	      maze.set(next.getY(),next.getX(),'.');
      }	     
	      		  
      
    return false;
  }

  public String toString(){
    return maze.toString();
  }
}
