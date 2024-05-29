package practice;

import java.util.Scanner;

public class Evenodd {
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
			for(int j=0;j<n;j++)
			{
				if(a[j]%2==0)
				{
					System.out.println("Even :"+a[j]);
				}
				else
				{
					System.out.println("Odd :"+a[j]);
				}
			}
	 }
}