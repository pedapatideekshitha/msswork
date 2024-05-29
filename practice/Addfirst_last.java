package practice;

import java.util.Scanner;

public class Addfirst_last {
	 public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			int c=1;
			int s=0;
			while(n!=0)
			{
				 
				int r=n%10;
				if(c==1 || n==1)
				{
					s=s+r;
				}
				n=n/10;
				c++;
			} 

		 System.out.println("Sum of First and last Digits"+s);
			 
	 }
}