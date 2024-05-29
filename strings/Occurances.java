package strings;

public class Occurances{
  public static void main(String args[]){
      String s="hello";
              boolean[] visited = new boolean[s.length()];
       for(int i=0;i<s.length();i++){
                  int c=0;
                   if (visited[i]) {
              continue;
          }
         
          for(int j=1;j<s.length()-1;j++){
              if(s.charAt(i)==s.charAt(j)){
                  c++;
                  visited[j]=true;
              }}
                      System.out.println(s.charAt(i)+"-" +c);

         
      }
  }
}
