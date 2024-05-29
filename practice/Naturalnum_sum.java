
package practice;

import java.util.Scanner;

public class Naturalnum_sum {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			int s=0;
			
			for(int i=1;i<=n;i++)
			{
				s=s+i;
			}
			System.out.println("Sum of "+n+" natural numbers : "+s);
	 }
}