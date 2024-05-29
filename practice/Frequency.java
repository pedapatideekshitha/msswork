package practice;

import java.util.Scanner;

public class Frequency {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int n=sc.nextInt();
		int temp=n;
		while(n!=0)
		{
			int c=0;
			int r=n%10;
			while(temp!=0)
			{
				int a=temp%10;
				if(a==r)
				{
					c++;
				}
				temp=temp/10;
			}
		 
			System.out.println("number of occurences of "+r+ "is :"+c);
			n=n/10;
		}
		
	}
}
