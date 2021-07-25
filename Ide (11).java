/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void queensc2d(boolean board[][],int tpc,int tc,int row ,int col,String ans)
    {
        if(tpc==tc)
        {
            System.out.println(ans);
            return;
        }
        
        if(col==board[1].length)
        {
            queensc2d(board,tpc,tc,row+1,0,ans);
            return;
        }
        
        if(row==board.length)
        {
            return;
        }
        
        
        
        board[row][col]=true;
        queensc2d(board,tpc+1,tc,row,col+1,ans+"queen"+":B:"+row+":"+col+"\t");
        board[row][col]=false;
        queensc2d(board,tpc,tc,row,col+1,ans);
        board[row][col]=false;
        
    }
    
      public static void queensc2dkill(boolean board[][],int tpc,int tc,int row ,int col,String ans)
    {
        if(tpc==tc)
        {
            System.out.println(ans);
            return;
        }
        
        if(col==board[1].length)
        {
            queensc2dkill(board,tpc,tc,row+1,0,ans);
            return;
        }
        
        if(row==board.length)
        {
            return;
        }
        
        
        if(isitsafe(board,row,col))
        {
        board[row][col]=true;
        queensc2dkill(board,tpc+1,tc,row,col+1,ans+"queen"+":B:"+row+":"+col+"\t");
        board[row][col]=false;
        }
        queensc2dkill(board,tpc,tc,row,col+1,ans);
        board[row][col]=false;
        
    }
    
    public static boolean isitsafe(boolean board[][],int row, int col)
    {
        int r=row-1;
        int c=col;
        
        while(r>=0)
        {
            if(board[r][c]==true)
            return false;
            --r;
        }
        
        r=row;
        c=col-1;
        
        while(c>=0)
        {
            if(board[r][c]==true)
            return false;
            --c;
            
        }
        
        c=col-1;r=row-1;
        
        while(r>=0&&c>=0)
        {
            if(board[r][c])
            return false;
            
            r--;
            c--;
        }
        
        r=row-1;
        c=col+1;
         while(r>=0&&c<board[0].length)
        {
            if(board[r][c])
            return false;
            
            r--;
            c++;
        }
        return true;
    }
    public static void ratinamaze(char arr[][],int row,int col)
    {
        if(row==arr.length-1&&col==arr[0].length-1)
        {
            arr[row][col]='-';
            
            for(int i=0;i<arr.length;++i)
            {
                for(int j=0;j<arr[0].length;++j)
                {
                    System.out.print(arr[i][j]+"  ");
                }
                System.out.println();
                
            }
            System.out.println("-----------------");
            return;
        }
        
        if(row==-1||row==arr.length||col==-1||col==arr[0].length||arr[row][col]=='X'||arr[row][col]=='-')
        {
             
            return;
        }
        
        arr[row][col]='-';
        
        ratinamaze(arr,row+1,col);
        ratinamaze(arr,row-1,col);
         ratinamaze(arr,row,col+1);
          ratinamaze(arr,row,col-1);
          
          arr[row][col]='0';
         
        
    }
public static void main (String[] args)
{
    
    	char arr[][]={{'0','X','0','0'},{'0','0','0','X'},{'0','0','X','0'},{'0','0','0','0'}};
    	
    	ratinamaze(arr,0,0);
}
}
	
	

