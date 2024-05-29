package patterns;

import java.util.Scanner;

public class CPattern2 {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
		     char a='A';
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<=i;j++)
				{
				System.out.print((char)(a+j));	 
				}
			 
				System.out.println(" ");
				
				 
				 
			}
	 }
}