package practice;

import java.util.Scanner;

public class Duplicate {
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
				int c=0;
				for(int j=0;j<n;j++)
				{
					if(a[i]==a[j])
					{
						c++;
					}
				}
				if(c>1)
				{
					System.out.println(a[i]);
				}
			}
	 }
}
