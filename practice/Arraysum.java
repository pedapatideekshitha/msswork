package practice;
import java.util.Scanner;

public class Arraysum {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			int a[]=new int[n];
			int s=0;
			for(int i=0;i<n;i++)
			{
				a[i]=sc.nextInt();
				s=s+a[i];
			}
			System.out.println("Sum of elements in array :"+s);
			
	 }
}