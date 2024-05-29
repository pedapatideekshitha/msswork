package practice;

import java.util.Scanner;

public class Evenoddsum {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			int es=0;
			int os=0;
 
	while(n!=0)
	{
		 
		int r=n%10;
		if(r%2==0)
		{
			es=es+r;
		}
		else
		{
			os=os+r;
		}
		n=n/10;
		 }
	System.out.println("Sum of even digits :"+es);
	System.out.println("Sum of odd digits :"+os);
	 }
	}