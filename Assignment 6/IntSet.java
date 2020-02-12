package assignment6;

import java.util.Scanner;


public final class IntSet {

	final int[] universal;
	final int[] arr2;

	/**
	 * Constructor to initialize the input array
	 * 
	 * @param input2
	 *            denotes the input array
	 */
	public IntSet(int[] input2) {
		int c = -1;
		universal = new int[10];
		for (int i = 1; i <= 10; i++) {
			this.universal[++c] = i;
		}
		this.arr2 = input2;
	}

	/**
	 * Return true if x is a member of the set else false
	 * 
	 * @param x
	 *           denotes the number that has to be checked in the set
	 * @return true if it is a member else return false
	 */
	public boolean isMember(int x) {
		for (int i = 0; i < universal.length; i++) {
			if (this.universal[i] == x)
				return true;
		}
		return false;
	}
	/**
	 * Returns the size of the set
	 * 
	 * @return size of the set
	 */
	public int size() {
		return arr2.length;
	}

	/**
	 * Returns true if arr5 is subset of arr4 else false
	 * 
	 * @param arr4
	 *            denotes first set
	 * @param arr5
	 *            denotes first set
	 * @return true if arr5 is subset of arr4 else false
	 */
	public boolean isSubset(int[] arr4, int[] arr5) {
		int i, j;
		for (i = 0; i < arr4.length; i++) {
			for (j = 0; j < arr5.length; j++) {
				if (arr4[i] == arr5[j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns array which is the complement of the set
	 * 
	 * @return array which is the complement of the set
	 */
	public int[] getComplement() {
		int k, l, count = 0;
		for (k = 0; k < universal.length; k++) {
			count = 0;
			for (l = 0; l < arr2.length; l++) {
				if (universal[k] == arr2[l]) {
					count++;
				}
			}
		}
		int flag, c = -1;
		int size = universal.length - count;
		int[] arr3 = new int[size];
		for (int i = 1; i <= 10; i++) {
			flag = 0;
			for (int j = 0; j < arr2.length; j++) {
				if (i == this.arr2[j]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				arr3[++c] = i;
		}
		return arr3;
	}

	/**
	 * Returns array which is the union of the two sets
	 * 
	 * @param arr4
	 *            denotes first set
	 * @param arr5
	 *            denotes second set
	 * @return array which is the union of the two sets
	 */
	public int[] union(int[] arr4, int[] arr5) {
		int k, l, count = 0;
		;
		for (k = 0; k < arr4.length; k++) {
			for (l = 0; l < arr5.length; l++) {
				if (arr4[k] == arr5[l]) {
					count++;
				}
			}
		}
		int i = 0, j = 0;
		int size = arr4.length + arr5.length - count;
		int[] newArr = new int[size];
		int c = -1;
		while (i < arr4.length && j < arr5.length) {
			if (arr4[i] < arr5[j]) {
				newArr[++c] = arr4[i];
				i++;
			} else if (arr5[j] < arr4[i]) {
				newArr[++c] = arr5[j];
				j++;
			} else {
				newArr[++c] = arr4[i];
				i++;
				j++;
			}
		}

		if (i < arr4.length)
			while (i < arr4.length) {
				newArr[++c] = arr4[i];
				i++;
			}

		if (j < arr5.length)
			while (j < arr5.length) {
				newArr[++c] = arr5[j];
				j++;
			}

		return newArr;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Size of Set1:");
		int size1=sc.nextInt();
		int[] arr = new int[size1];
		System.out.println("Enter Choice:\n1. Is Member\n2. Size\n3. Is Subset\n4. Get Complement\n5. Union\n6. Exit");
		int choice=sc.nextInt();
		System.out.println("Enter values in Set1");
		for(int i=0;i<size1;i++)
		{
				arr[i]=sc.nextInt();
		}
		
		switch(choice)
		{
			case 1:
				IntSet set1=new IntSet(arr);
				System.out.println("Enter Item:");
				int item=sc.nextInt();
				boolean b = set1.isMember(item);
				System.out.println(b);
				break;
			case 2:
				IntSet set2=new IntSet(arr);
				int n = set2.size();
				System.out.println(n);
				break;
			case 3:
				IntSet set3=new IntSet(arr);
				System.out.println("Enter Size of Set2:");
				int size2=sc.nextInt();
				int[] brr= new int[size2];
				for(int i=0;i<size2;i++)
				{
						brr[i]=sc.nextInt();
				}
				boolean c=set3.isSubset(arr, brr);
				System.out.print(c);
				break;
			case 4:
				IntSet set4=new IntSet(arr);
				int crr[] = set4.getComplement();
				for(int i=0;i<crr.length;i++)
				System.out.print(crr[i]+"\t");
				break;
			case 5:
				IntSet set5=new IntSet(arr);
				System.out.println("Enter Size of Set2:");
				int size3=sc.nextInt();
				int[] drr= new int[size3];
				for(int i=0;i<size3;i++)
				{
						drr[i]=sc.nextInt();
				}
				int[] err=set5.union(arr, drr);
				for(int i=0;i<err.length;i++)
					System.out.print(err[i]+"\t");
				break;
			case 6:
				System.exit(0);
				break;
			default:System.out.println("Wrong Choice");
		sc.close();
		}
	}
}
