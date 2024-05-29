package practice;
import java.util.*;
public class Neven {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a number");
	int n=sc.nextInt();
	System.out.println("Even numbers using For loop");
	for(int i=1 ;i<=n;i++)
	{
		if(i%2==0)
		{
		System.out.println(i);
		}
	}
	System.out.println("Even numbers using while loop");
	
	int i=1;
	while(i<=n)
	{
		if(i%2==0)
		{
		System.out.println(i);
		}
		i++;
	}
	System.out.println("Even numbers using do while loop");
	
	int j=1;
	
	do {
		if(j%2==0)
		{
		System.out.println(j);
		}
		j++;
	}
	while(j<=n);
	{
		if(i%2==0)
		{
		System.out.println(j);
		}
		j++;
	}

}
}