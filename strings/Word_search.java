package strings;
import java.util.*;
public class Word_search {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a String");
String s=sc.nextLine();
System.out.println("Enter a word");
String w=sc.nextLine();
if(s.contains(w))
{
System.out.println("The word is found in the String at "+s.indexOf(w));
}
else
{
System.out.println("The word is not found in the String");
}

}
}