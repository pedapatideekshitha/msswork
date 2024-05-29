package practice;

import java.util.Scanner;

public class Bigdigit {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int n=sc.nextInt();
		 
		int m=0;
		while(n!=0)
		{
			int r=n%10;
			m=Math.max(m, r);
			n=n/10;
		}
		System.out.println("Biggest digit in given number :"+m);
	}
}