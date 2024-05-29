package practice;

import java.util.Scanner;

public class Samedigits {
	static String check(int n)
	{
		 int d=n%10;
		 while(n!=0)
			{
				 
			   int r=n%10;
				 
				 if(r!=d)
				 {
					 return "NO";
				 }
				n=n/10;
			 
			}
			 return "yes";
	}
 public static void main(String[] args)
 {
	 Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int n=sc.nextInt();
		
	 System.out.println(check(n));
		 
 }
}