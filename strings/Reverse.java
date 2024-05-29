package strings;

public class Reverse {
  public static void main(String args[]) {
      String s = "hello world";
      String s1 = "";
      String s2 = "";
      int c = 0;
     
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) != ' ') {
              s1 += s.charAt(i);
              c++;
          } else {
              for (int j = c - 1; j >= 0; j--) {
                  s2 += s1.charAt(j);
              }
              s2 += " "; 
              s1 = ""; 
              c = 0; 
          }
      }
     
      for (int j = c - 1; j >= 0; j--) {
          s2 += s1.charAt(j);
      }
     
      System.out.println(s2.trim()); 
  }
}