package patterns;

import java.util.Scanner;

public class CPattern1 {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			char c='A';
			for(int i=n;i>0;i--)
			{
				for(int j=0;j<i;j++)
				{
				System.out.print((char)(c+j));	 
				}
				
				 System.out.println(" ");
				 
			}
}
}