package practice;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			
			int temp=n;
			int s=0;
			while(n!=0)
			{
				int r=n%10;
				s=s+r*r*r;
				n=n/10;
			}
			if(s==temp)
			{
				System.out.println("Armstrong Number");
			}
			else
			{
				System.out.println("Not an Armstrong number");
			}
	 }
}