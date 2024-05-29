package practice;
import java.util.*;
public class Evensumfor {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a number");
	int n=sc.nextInt();
	int sum=0;
	for(int i=1;i<=n;i++)
	{
		if(i%2==0)
		{
			sum=sum+i;
		}
	}
	System.out.println("sum of even numbers between 1 and "+n+" is :"+sum);
}
}