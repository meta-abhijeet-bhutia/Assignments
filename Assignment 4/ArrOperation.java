package testing;
import java.util.*;
public class ArrOperation
{
	/**
	 * method to find largest mirror of intiger array
	 * 
	 * 
	 * @param arr
	 *            input intiger array
	 * @param n
	 *            size of array
	 * @return intiger denotes maximum length of mirror
	 */
public int LargestMirrorSection(int arr[])
{
	int count=0;
	int max=0;
	int len=arr.length;
	for(int i=0;i<len;i++)
	{
		count=0;
		for(int j=len-1;(i+count)<len&&j>=0;j--)
		{
			if(arr[i+count]==arr[j])
			{
				count++;
			}
			else
			{
				if(count>0)
				{
					max=Math.max(count,max);
					count=0;
				}
			}
		}
		max=Math.max(count,max);
	}
	return max;
}
/**
	 * method to find maximum clump
	 * 
	 * @param arr
	 *            input intiger array
	 * @param n
	 *            size of array
	 * @return intiger denotes mximum number of clumps present
	 */
public int NumberOfClumps(int arr[])
{
	int clump=0;
	int len=arr.length;
	int current=-1;
	for(int i=0;i<len-1;i++)
	{
		if(current!=arr[i]&&arr[i]==arr[i+1])
		{
			clump++;
		}
		current=arr[i];
	}
	return clump;
}
	/**
	 * method of xy shift place y adjsent to x without moving x
	 * 
	 * @param arr
	 *            input integer array
	 * @param x
	 *            value of x which will not move
	 * @param y
	 *            which will move,swap
	 * @param n
	 * @return
	 */
public int[] FixXY(int arr[],int x,int y)
{
	int n=arr.length;
	if(arr==null || arr.length==0)
		return null;
	if(arr[n-1]==x)
		return null;
	ArrayList<Integer>xin=new ArrayList<Integer>(1);
	ArrayList<Integer>yin=new ArrayList<Integer>(1);
	for(int i=0;i<n;i++)
	{
		if(arr[i]==x)
		{
			if(i!=0 && arr[i-1]==x)
				return null;
			xin.add(i);
		}
		if(arr[i]==y)
			yin.add(i);
	}
	if(xin.size()!=yin.size())
		return null;
	for(int i=0;i<yin.size();i++)
	{
		int temp;
		temp=arr[yin.get(i)];
		arr[yin.get(i)]=arr[xin.get(i)+1];
		arr[xin.get(i)+1]=temp;
	}

	return arr;
}
	/**
	 * method to find index of array by which array could be divided into 2
	 * equal parts having sum of elements is equal
	 * 
	 * @param arr
	 *            input array
	 * @param n
	 *            size
	 * @return integer denotes that index
	 */
public int SplitArray(int arr[])
{
	int splitin=-1;
	int sum=0;
	int sum2=0;
	int len=arr.length;
	for (int i=0;i<len;i++)
	{
		sum=sum+arr[i];
	}
	if(sum%2!=0)
		return splitin;
	for(int i=0;i<len;i++)
	{
		sum2=sum2+arr[i];
		if(sum2==(sum/2))
		{
			splitin=i;
			return splitin+1;
		}
	}
	return splitin;
}
}
