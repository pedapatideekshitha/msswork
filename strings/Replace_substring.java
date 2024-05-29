package strings;
import java.util.*;
public class Replace_substring {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a String");
String s=sc.nextLine();

System.out.println("enter a substring");
String s1=sc.nextLine();
System.out.println("enter a position");
int p=sc.nextInt();
String s2=s.substring(p,p+s1.length());
 
s=s.replace(s2,s1);

System.out.println(s);
}
}