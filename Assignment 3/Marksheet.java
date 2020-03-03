import java.util.Scanner;
import java.lang.ArithmeticException;
class Marksheet
{ 
    static float AverageGrade(float arr[],int n)
    {
		float sum=0;
        for(int i=0;i<n;i++)
		{
		   sum=sum+arr[i];
		}
		return(sum/n);
    }
	static float MaximumGrade(float arr[],int n)
    {
		float Maximum=arr[0];
        for(int i=1;i<n;i++)
		{
			if(Maximum<arr[i])
			{
				Maximum=arr[i];
			}
		}
		return Maximum;
    }
	static float MinimumGrade(float arr[],int n)
    {
        float Minimum=arr[0];
        for(int i=1;i<n;i++)
		{
			if(Minimum>arr[i])
			{
				Minimum=arr[i];
			}
		}
			return Minimum;
    }
	static float PercentagePass(float arr[],int n)
    {
           float count=0;
        for(int i=0;i<n;i++)
		{
			if(arr[i]>=40)
			{
				count++;
			}
		}
		float Percentage=(count*100)/n;
		return Percentage;
    }
    public static void main(String args[]) throws ArithmeticException
    {   
        Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of students=");
		int n=sc.nextInt();
		float arr[]=new float[n];
		System.out.println("Enter Grades");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextFloat();
		}
		int x=0;
		while(x!=5)
		{
			System.out.println("Enter choice\n1. Average Grade\n2. Maximum Grade\n3. Minimum Grade\n4. Percentage pass\n5. Exit");
			x=sc.nextInt();
			if(x==1)
			{
				float Average=AverageGrade(arr,n);
				System.out.println("Average Grade="+Average);
			}
			else if(x==2)
			{
				float Maximum=MaximumGrade(arr,n);
				System.out.println("Maximum Grade="+Maximum);
			}
			else if(x==3)
			{
				float Minimum=MinimumGrade(arr,n);
				System.out.println("Minimum Grade="+Minimum);
			}
			else if(x==4)
			{
				float Percentage=PercentagePass(arr,n);
				System.out.println("Percentage pass student="+Percentage);
			}
			else if(x==5)
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Wrong Choice");
			}
		}
        
    } 
} 