package patterns;
import java.util.*;
public class NPattern6 {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();

 

for(int i=1;i<=n;i++)
{
    for(int j=1;j<n-i;j++)
    {
    System.out.print(" ");
    }
    for(int k=i;k>=2;k--)
    {
    System.out.print(k);
    }
    for(int j=1;j<=i;j++)
    {
        System.out.print(j);
    }
    
    
    System.out.println("");
}


}
}