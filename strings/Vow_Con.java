package strings;

public class Vow_Con {
  public static void main(String[] args) {
      String s = "hello world";
      int v = 0;  
      int co = 0;  
     
      String s1 = s.toUpperCase();
     
      for (int i = 0; i < s1.length(); i++) {
          char c = s1.charAt(i);
          if (c != ' ') {
              if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                  v++;
              } else {
                  co++;
              }
          }
      }
     
      System.out.println("Vowels: " + v);
      System.out.println("Consonants: " + co);
  }
}
