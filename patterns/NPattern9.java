package patterns;
import java.util.*;
public class NPattern9 {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a number");
	int n=sc.nextInt();
	
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=2*i-1;j++)
		{
			if(i==j)
			{
				System.out.print(i);
			}
			else
			{
				System.out.print("*");
			}
		}
		System.out.println(" ");
	}
}
}