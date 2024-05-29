package patterns;
import java.util.*;
public class NPattern8 {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
System.out.println(1);
for(int i=1;i<=n;i++)
{
int c=1;
for(int j=1;j<=(2*i+1);j++)
{
if(j%2==0)
{
System.out.print("*");
}
else
{
System.out.print(c);
c++;
}


}
System.out.println("");
}

}
}