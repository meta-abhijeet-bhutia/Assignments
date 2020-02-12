package assignment6;

import java.util.Scanner;

public final class Poly {

	final int[] coeff;
	final int[] power;
	final int[] coeff2;
	final int[] power2;
	
	/**
	 * Constructor to initialize the input arrays
	 * @param input denotes input coefficient of 1st polynomial
	 * @param input2 denotes input power of 1st polynomial
	 * @param input3 denotes input coefficient of 2nd polynomial
	 * @param input4 denotes input power of 2nd polynomial
	 */
	public Poly(int[] input,int[] input2,int[] input3,int[] input4)
	{
		coeff=input;
		power=input2;
		coeff2=input3;
		power2=input4;
		
	}
	
	/**
	 * Returns the evaluated result of the polynomial
	 * @param x denotes the value of x
	 * @return evaluated result of the polynomial
	 */
	public double Evaluate(double x)
	{
		double result=0;
		for(int i=0;i<=2;i++)
		{
			result+=(coeff[i]*Math.pow(x, power[i]));
		}
		return result;
	}

	/**
	 * Returns the degree of the polynomial
	 * @return degree of the polynomial
	 */
	public int Degree()
	{
		int max=0;
		for(int i=0;i<coeff.length;i++)
		{
			if(power[i]>max)
				max=power[i];
		}
		return max;
	}
	
	/**
	 * Returns the string which shows the addition of two polynomials
	 * @return the string which shows the addition of two polynomials
	 */
	public String AddPoly()
	{
		String str="";
		int sum,flag;
		for(int i=0;i<coeff.length;i++)
		{
			sum=0;
			flag=0;
			for(int j=0;j<coeff2.length;j++)
			{
				if(power[i]==power2[j]){
					sum=coeff[j]+coeff2[j];
					str+="+"+sum+"x^"+power[j];
					flag=1;
					break;
				}
			}
				if(flag==0)
				{
					str+="+"+coeff[i]+"x^"+power[i];
				}
		}
		
		for(int i=0;i<coeff2.length;i++)
		{
			sum=0;
			flag=0;
			for(int j=0;j<coeff.length;j++)
			{
				if(power[i]==power2[j]){
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				str+="+"+coeff2[i]+"x^"+power2[i];
			}
		}
		return str;
	}

	/**
	 * Returns the string which shows the multiplication of two polynomials
	 * @return the string which shows the multiplication of two polynomials
	 */
	public String MultiPoly()
	{
		String str="";
		int coe;
		int pow;
		for(int i=0;i<coeff.length;i++)
		{
			for(int j=0;j<coeff2.length;j++)
			{
				coe=coeff[i]*coeff2[j];
				pow=power[i]+power2[j];
				str+="+"+coe+"x^"+pow;
			}
		}
		return str;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int[] iCoeff1={1,0,1};
		int[] iPower1={1,2,3};
		int[] iCoeff2={1,1,1};
		int[] iPower2={1,2,3};
		Poly p1=new Poly(iCoeff1,iPower1,iCoeff2,iPower2);
		System.out.println("Enter Choice:\n1. Degree\n2. Add Polynomial\n3. Multiply Polynomial\n4. Exit");
		int choice=sc.nextInt();
		
		switch(choice)
		{
			case 1:
				int max=p1.Degree();
				System.out.println(max);
				break;
			case 2:
				String str=p1.AddPoly();
				System.out.println(str);
				break;
			case 3:
				String str1=p1.MultiPoly();
				System.out.print(str1);
				break;
			case 4:
				System.exit(0);
				break;
			default:System.out.println("Wrong Choice");
		sc.close();
		}
	}
			
}

