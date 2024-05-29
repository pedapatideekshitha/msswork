package practice;
import java.util.*;
public class Divisibleby3_5 {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a number :");
	int n=sc.nextInt();
	if(n%3==0 && n%5==0)
	{
		System.out.println("number is divisible by both 3 and 5");
	}
	else
	{
		System.out.println("number is not divisible by both 3 and 5");
		
	}
}
}