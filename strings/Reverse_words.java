package strings;
import java.util.*;
public class Reverse_words {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();

String a[]=s.split(" ");

String str="";

for(int i=a.length-1;i>=0;i--)
{
str=str+a[i]+" ";
}
System.out.println(str);
}
}