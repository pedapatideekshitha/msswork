package practice;

import java.util.Scanner;

public class Alternatesum {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int n=sc.nextInt();
		int s=0;
		while(n!=0)
		{
			int r=n%10;
			if(r%2!=0)
			{
				s=s+r;
				
			}
			n=n/10;
		}
		System.out.println("Alternate sum :"+s);
	}
}
