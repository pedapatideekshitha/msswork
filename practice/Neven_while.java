package practice;
import java.util.*;
public class Neven_while {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a number");
	int n=sc.nextInt();
	int cnt=0;
	int i=0;
	while(cnt<n)
	{
		if(i%2==0)
		{
			System.out.println(i);
			cnt++;
		}
		i++;
	}
}
}