package practice;
import java.util.*;
public class Charcheck {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a character");
	char c=sc.nextLine().charAt(0);
	
	if(c>=65 && c<=90)
	{
		System.out.println("Upper Case");
	}
	else if(c>=97 && c<=122)
	{
		System.out.println("Lower Case");
	}
	else if(c>=48 && c<=57){
		System.out.println("Numercal Digits");
	}
	else if((c>=32 && c<=47)||(c>=58 && c<=64)||(c>=91 && c<=96)||(c>=123 && c<=126))
	{
		System.out.println("Special Character");
	}
}
}