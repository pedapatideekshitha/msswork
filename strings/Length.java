package strings;
public class Length{
public static void main(String args[]){
  String s= "hello world";
  int length = 0;
 
   while (true) {
      try {
           s.charAt(length);
           length++;
      } catch (IndexOutOfBoundsException e) {
           break;
      }
  }
   System.out.println("The length of the string is: " + length);
}
}
