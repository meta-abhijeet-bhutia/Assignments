import java.util.*;
class Fcfs
{ 
    static void WaitingTime(int arr[][],int tat[],int wt[],int n) //Calculate Waiting Time
    { 
        for(int i=0;i< n;i++) 
            wt[i]=tat[i]-arr[i][1];
    }  
    static void TurnAroundTime(int arr[][],int ct[], int tat[],int n) 
    {  
        for(int i=0; i < n ; i++) 
            tat[i]=ct[i]-arr[i][0]; 
    } 
    static void CompletetionTime(int arr[][],int ct[],int n)
    {
		ct[0]=arr[0][0]+arr[0][1];
        for(int i=1;i<n;i++)
        {
            if(ct[i-1]>arr[i][0])
			{
				ct[i]=ct[i-1]+arr[i][1];
			}
			else
			{
				ct[i]=arr[i][0]+arr[i][1];
			}
        }
    }
    static void AverageWaitingTime(int[] wt,int n)
    {
        int w=0;
        int p=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+wt[i];
            if(wt[i]>w)
            {
                w=wt[i];
                p=i+1;
            }
        }
        System.out.println("Average Waiting time is"+((float)sum/(float)n));
        System.out.println("Maximum Waiting time in queue is of process no "+p+" and waiting time is "+w);
    }
    static void findAvgTurnAroundTime(int[] tat,int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+tat[i];
        }
        System.out.println("Average Turn Around time is"+((float)sum/(float)n));        
    }
    public static void main(String args[]) 
    {   
        System.out.println("Enter no. of processes");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Enter Arrival time and Burst time for all processes");
        int[][] arr = new int[n][2]; 
        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter Arrival time and Burst time for process "+(i+1));
            for (int j = 0; j < 2; j++) 
                 arr[i][j]=sc.nextInt();
        } 
        int ct[]=new int[n];
        int tat[]=new int[n];
        int wt[]=new int[n];
        CompletetionTime(arr,ct,n); 
        TurnAroundTime(arr,ct,tat,n);
        WaitingTime(arr,tat,wt,n);
        System.out.println("Arrival Time "+"Burst Time "+"Completetion Time "+"Turn Arround Time "+"Completetion Time ");
        for(int i=0;i<n;i++)
        {
            System.out.println("\t"+arr[i][0]+"\t"+arr[i][1]+"\t\t"+ct[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
        }
        AverageWaitingTime(wt,n);
    } 
} 