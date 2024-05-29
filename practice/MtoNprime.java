package practice;

import java.util.Scanner;

public class MtoNprime {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter  m");
			int m=sc.nextInt();
			System.out.println("enter n");
			int n=sc.nextInt();
			for(int i=m;i<n;i++)
			{
				int c=0;
				for(int j=1;j<=i;j++)
				{
					if(i%j==0)
					{
						c++;
					}
					
				}
				if(c==2)
				{
					System.out.println(i);
				}
			}
	 }
}