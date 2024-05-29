package practice;

import java.util.Scanner;

public class Reversearray {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=sc.nextInt();
			}
			
			for(int j=n-1;j>=0;j--)
			{
				System.out.println(a[j]);
			}
	 }
}