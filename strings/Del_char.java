package strings;
import java.util.*;
public class Del_char {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();
System.out.println("Enter a char to remove");

char a=sc.nextLine().charAt(0);

for(int i=0;i<s.length();i++)
{
if(s.charAt(i)==a)
{
s=s.substring(0,i)+s.substring(i+1);
}
}

System.out.println("New string : "+s);



}
}