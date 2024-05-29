package practice;

import java.util.Scanner;

public class Digitsum_recursion {
	static int sum(int n)
	{
		
		if(n==0)
		{
			return 0;
		}
		else
		{
		int r=n%10;
		return r+sum(n/10);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int n=sc.nextInt();
		
		System.out.println(sum(n));
		
		
	}
}