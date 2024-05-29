package strings;
public class Printalpha {
  public static void main(String[] args) {
      String t = "";
      String s = "12dh3r1dvf%7";
     
      for (int i = 0; i < s.length(); i++) {
          char currentChar = s.charAt(i);
          if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z')) {
              t += currentChar;
          }
      }
     
      System.out.println(t);
  }
}