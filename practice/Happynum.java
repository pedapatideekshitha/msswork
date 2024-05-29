package practice;
import java.util.*;
public class Happynum {
	static int happy(int n)
	{
		int num=0;
		while(n!=0)
		{
			int r=n%10;
			num=num+r*r;
			n=n/10;
		}
		return num;
	}
	static boolean ishappy(int n)
	{
		 
		HashSet<Integer> hs=new HashSet<Integer>();
		while(true)
		{
	    n=happy(n);
		if(n==1)
		{
			return true;
		}
		else if(hs.contains(n))
		{
		return false;	
		}
		hs.add(n);
		}
		
	}
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			
			if(ishappy(n))
			{
				System.out.println("It is a happy number");
			}
			else
			{
				System.out.println("It is not a happy number");
			}
			
			
	 }
}