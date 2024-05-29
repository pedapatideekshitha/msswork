package practice;

import java.util.Scanner;

public class Sort_desc {
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
					if(j>i)
					{
						int t=a[i];
						a[i]=a[j];
						a[j]=t;
					}
				}
			}
			
			for(int x=0;x<n;x++)
			{
				System.out.print(a[x]+" ");
			}
	 }
}