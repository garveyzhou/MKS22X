import java.util.*;
import java.io.*;

public class USACO{
    public static int bronze(String filename){
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	int R = s.nextInt();
	int C = s.nextInt();
	int E = s.nextInt();
	int N = s.nextInt();
	int[][] land = new int[R][C];
	for(int i = 0; i <R; i++){
	    for(int j = 0;j < C ; j++){
		land[i][j] = s.nextInt();
	    }
	}
	for (int n = 0; n< N; n--){
	    int r = s.nextInt();
	    int c = s.nextInt();
	    int down = s.nextInt();
	    stomp(land,r - 1 ,c - 1,down);
	}
	int totalDepth = 0;
	for( int i = 0; i< R; i++){
	    for(int j = 0; j< C;j++){
		if(land[i][j] < E){
		    totalDepth += E - land[i][j];
		}
	    }
	}
	return totalDepth *72*72;
	
	} catch(FileNotFoundException e){};
	return -1;
    }

    public static void stomp(int[][] data, int row, int col ,int d){
	int max = 0;
	for(int i = 0; i < 3;i++){
	    for(int j = 0; j < 3;j++){
		if(data[row+i][col+j] > max){
		    max = data[row+i][j+col];
		}
	    }
	}
	for(int i = 0; i < 3;i++){
	    for(int j = 0; j < 3;j++){
		if(data[row+i][col+j] > max - d){
		    data[row+i][j+col] = max -d;
		}
	    }
	}
    }
    public static void main(String[]args){
    }
    
}
