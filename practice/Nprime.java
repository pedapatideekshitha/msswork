package practice;

import java.util.Scanner;

public class Nprime {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			
			int cnt=0;
			int i=1;
			while(cnt!=n)
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
					cnt++;
				}
				i++;
			}
	 }
}