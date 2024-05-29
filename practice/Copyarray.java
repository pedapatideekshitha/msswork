package practice;

import java.util.Scanner;

public class Copyarray {
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
			int b[]=new int[n];
			for(int j=0;j<n;j++)
			{
				b[j]=a[j];
				System.out.println(b[j]);
			}
	 }
}