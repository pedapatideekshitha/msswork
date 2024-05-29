package practice;

import java.util.Scanner;

public class Narmstrong {
	static boolean armstrong(int n)
	{
		int s=0;
		int temp=n;
		while(n!=0)
		{
			int r=n%10;
			s=s+r*r*r;
			n=n/10;
		}
		if(temp==s)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			
			for(int i=1;i<n;i++)
			{
			 if(armstrong(i))
			 {
				 System.out.println(i);
			 }
			}
	 }
}