package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Largesmall {
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
			
			for(int i=0;i<n;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					if(a[i]>a[j])
					{
						int t=a[i];
						a[i]=a[j];
						a[j]=t;
					}
				}
			}
			System.out.println("largest element :"+a[n-1]);
			System.out.println("Smallest element : "+a[0]);
	 }
}