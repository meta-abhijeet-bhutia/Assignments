import java.util.Scanner;
import java.lang.ArithmeticException;
class Area
{ 
    static double AreaOfTriangle(double Width, double Height)
    {
           return(0.5*Width*Height);
    }
	static double AreaOfRectangle(double Width, double Height)
    {
           return(Width*Height);
    }
	static double AreaOfSquare(double Width)
    {
           return(Width*Width);
    }
	static double AreaOfCircle(double Radius)
    {
           return(3.14*Radius*Radius);
    }
    public static void main(String args[]) throws ArithmeticException
    {   
        Scanner sc=new Scanner(System.in);
		int x=0;
        while(x!=5)
		{
			System.out.println("Select the shape to calculate area\n1. Triangle\n2. Rectangle\n3. Square\n4. Circle\n5. Exit");
			x=sc.nextInt();
			if(x==1)
			{
				System.out.println("Enter Width and Height");
				double Width=sc.nextDouble();
				double Height=sc.nextDouble();
				double Area=AreaOfTriangle(Width,Height);
				System.out.println("Area of triangle="+Area);
			}
			else if(x==2)
			{
				System.out.println("Enter Width and Height");
				double Width=sc.nextDouble();
				double Height=sc.nextDouble();
				double Area=AreaOfRectangle(Width,Height);
				System.out.println("Area of rectangle="+Area);
			}
			else if(x==3)
			{
				System.out.println("Enter Width");
				double Width=sc.nextDouble();
				double Area=AreaOfSquare(Width);
				System.out.println("Area of square="+Area);
			}
			else if(x==4)
			{
				System.out.println("Enter Radius");
				double Radius=sc.nextDouble();
				double Area=AreaOfCircle(Radius);
				System.out.println("Area of Circle="+Area);
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