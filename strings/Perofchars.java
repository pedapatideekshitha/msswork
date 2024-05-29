package strings;
import java.util.*;
public class Perofchars {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();
double splcnt=0;
double vcnt=0;
double ccnt=0;
double cnt=0;
double ucnt=0;
double lcnt=0;
String s1=s.toLowerCase();
for(int i=1;i<s.length();i++)
{


if(s1.charAt(i)=='a' || s1.charAt(i)=='e' || s1.charAt(i)=='i' || s1.charAt(i)=='o' || s1.charAt(i)=='u')
{
vcnt++;
}

else if(s.charAt(i)>=48 && s.charAt(i)<=57)
{
cnt++;
}
else if(s.charAt(i)<=32 && s.charAt(i)<=47)
{
splcnt++;
}
else if(s.charAt(i)>='a' && s.charAt(i)<='z')
{lcnt++;
}
else if(s.charAt(i)>='A' && s.charAt(i)<='Z')
{
ucnt++;
}
else
{
ccnt++;
}
}
System.out.println("Percentage of upper case :"+((ucnt/s.length())*100));
System.out.println("Percentage of lower case :"+(lcnt/s.length())*100);
System.out.println("Percentage of vowels :"+(vcnt/s.length())*100);
System.out.println("Percentage of consonents :"+(ccnt/s.length())*100);
System.out.println("Percentage of digits :"+(cnt/s.length())*100);
System.out.println("Percentage of Special Characters :"+(splcnt/s.length())*100);



}
}