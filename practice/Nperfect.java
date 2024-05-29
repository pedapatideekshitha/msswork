package practice;

import java.util.Scanner;

public class Nperfect {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			int cnt=0;
			int i=1;
			while(cnt!=n)
			{
				int s=0;
				for(int j=1;j<i;j++)
				{
					if(i%j==0)
					{
						s=s+j;
					}
				}
				if(s==i)
				{
					System.out.println(s);
					cnt++;
				}
				i++;
				
			}
	 }
}