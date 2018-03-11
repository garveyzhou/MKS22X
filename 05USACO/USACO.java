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
	    for (int n = 0; n < N; n++){
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
	    return totalDepth * 72 * 72;
	
	} catch(FileNotFoundException e){};
	return -1;
    }

    public static void stomp(int[][] data, int row, int col ,int d){
	int max = 0;
	try{
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
	}catch(ArrayIndexOutOfBoundsException e){};
    }

    public static int silver(String filename){
	try{ File f = new File(filename);
	    Scanner s = new Scanner(f);
	    int R  = s.nextInt();
	    int C = s.nextInt();
	    int T = s.nextInt();
	    char[][] map = new char[R][C];
	    for(int i = 0; i< R; i++){
		String row = s.nextLine();
		for(int j = 0; j< C ; j++){
		    map[i][j] = row.charAt(j);
		}
	    }
	    int[][] newarr = new int [R][C];
	    int[][] oldarr = new int[R][C];

	    for(int i = 0; i<R;i++){
		for(int j = 0; j <C: j++){
		    if (map[i][j] == '*'){
			oldarr[i][j] = -1;
		    }
		    else{oldarr[i][j] == 0;
		    }
		}
	    }

	    int R1 = s.nextInt() - 1;
	    int C1 = s.nextInt() - 1;
	    int R2 = s.nextInt() - 1;
	    int C2 = s.nextInt() -1;
	    oldarr[R1][C1]= 1;
	    if((R2-R1+C2-C1)%2 != T%2){
		return 0;}
	    
	}catch(Exception e){};
	return 0;
    }


    public static void sumNeightbors(int r, int c,int arr){
	int[][] sides = {{0,1},{0,-1},{1,0},{-1,0}};
	in sum = 0;
	for (int i = 0 ; i< 4; i++){
	    try{
	    
    public static void main(String[]args){
	System.out.println(USACO.bronze("Lakemake1.txt"));
    }
    
}
