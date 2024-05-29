package strings;

public class Replace {
  public static void main(String args[]) {
      String s = "hello wel to mss";
      StringBuilder sb = new StringBuilder(s);

       for (int i = 1; i < sb.length(); i++) {
          if (sb.charAt(i) == ' ') {
               sb.setCharAt(i + 1, sb.charAt(i - 1));
          }
      }

      String modifiedString = sb.toString();
      System.out.println(modifiedString);
  }
}
