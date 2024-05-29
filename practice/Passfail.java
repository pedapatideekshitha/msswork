package practice;
import java.util.*;
public class Passfail {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter marks");
	int marks=sc.nextInt();
	if(marks<50)
	{
		System.out.println("Fail");
	}
	else
	{
		if(marks>=90 && marks<=100)
		{
			System.out.println("Passed with A grade");
		}
		else if(marks>=80 && marks<=89)
		{
			System.out.println("Passed with B grade");
		}
		else if(marks>=70 && marks<=79)
		{
			System.out.println("Passed with C grade");
		}
		else if(marks>=60 && marks<=69)
		{
			System.out.println("Passed with D grade");
		}
		else
		{
		 
				System.out.println("Passed with E grade");
			
		}
	}

}
}