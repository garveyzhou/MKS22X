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
	    String[] num = s.nextLine().split(" ");
	    int R = Integer.parseInt(num[0]);
	    int C = Integer.parseInt(num[1]);
	    int T = Integer.parseInt(num[2]);
	    char[][] map = new char[R][C];
	    for(int i = 0; i < R; i++){
		String line = s.nextLine();
		for(int j = 1; j < C ; j++){
		    map[i][j] = line.charAt(j);
		}
	    }
	    int[][] newarr = new int [R][C];
	    int[][] oldarr = new int[R][C];

	    for(int i = 0; i< R ;i++){
		for(int j = 0; j <C; j++){
		    if (map[i][j] == '*'){
			oldarr[i][j] = -1;
		    }
		    else{oldarr[i][j] = 0;
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
	    
	    for(int i = 0 ; i < T; i++){
		for(int x = 0; x <R ; x++){
		    for(int y = 0;y< C; y++){
			newarr[x][y] = sumNeighbors(x,y,oldarr);;
		    }
		}
		for(int x = 0; x< R; x++){
		    for(int y = 0;y<C; y++){
			oldarr[x][y] = newarr[x][y];
		    }
		}
		//	System.out.println(toString(oldarr));
	    }
	    return newarr[R2][C2];
	}catch(FileNotFoundException e){};
	return -1;
    }

    public static boolean isValid( int r, int c,int[][] arr){
	return (r < arr.length && r >= 0 && c < arr[0].length && c >= 0 && arr[r][c] != -1);
    }    
    public static int sumNeighbors(int r, int c,int[][] arr){
	int[][] sides = {{0,1},{0,-1},{1,0},{-1,0}};
	int sum = 0;
	    for (int i = 0 ; i< 4; i++){
		if ( arr[r][c] != -1){
		    if(isValid(r + sides[i][0],c + sides[i][1],arr)){
			sum += arr[r + sides[i][0]][c + sides[i][1]];
		    }
		
		}
		else{return -1;}
	    }
	//	System.out.println(toString(arr));
	return sum;
    }

    public static String toString(int[][] arr){
	String str = "";
	for (int r = 0; r < arr.length; r++){
	    for (int c = 0; c < arr[r].length; c++){
		str += arr[r][c] + " ";
	    }
	    str += "\n";
	}
	return str;
    }
    
    public static void main(String[]args){
	System.out.println(USACO.bronze("Lakemake1.txt"));
	System.out.println(USACO.silver("Cow.txt"));
	USACO.silver("Cow.txt");
    }
    
}
