import java.util.Scanner;
class Nqueens
{
	static boolean placeQueen(int[][] chess,int column,int n)
	{
		if(column==n)
			return true;
		for(int j=0;j<n;j++)
		{
			if(isSafe(chess,column,j,n))
			{
				chess[column][j]=1;
				if(placeQueen(chess,column+1,n))
					return true;
				else
				{
					chess[column][j]=0;
					continue;
				}
			}
		}
		return false;

	}
	static boolean isSafe(int[][] q,int x,int y,int n)
	{
		for(int i=0;i<n;i++)
		{
			if(q[i][y]==1)
				return false;
			if(q[x][i]==1)
				return false;
		}
		for(int i=0; x+i<n && y+i<n ;i++)
		{
			if(q[x+i][y+i]==1)
				return false;
		}
		for(int i=0;x-i >= 0 && y-i >=0;i++)
		{
			if(q[x-i][y-i]==1)
				return false;
		}
		for(int i=0;x+i < n && y-i >=0;i++)
		{
			if(q[x+i][y-i]==1)
				return false;
		}
		for(int i=0;x-i >= 0 && y+i <n;i++)
		{
			if(q[x-i][y+i]==1)
				return false;
		}
		return true;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] chess=new int[n][n];
		boolean b=Nqueens.placeQueen(chess,0,n);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(" "+chess[i][j]);
			}
			System.out.println("");
		} 
	}
}