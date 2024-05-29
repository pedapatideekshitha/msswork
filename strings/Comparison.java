package strings;
 class Comparison {
	
 public static void compare(String s1, String s2){
 if(s1.length()!=s2.length()){
 System.out.println("not equal");
 }
 else{
                 boolean areEqual = true;
 for(int i=0;i<s1.length();i++){
 if(s1.charAt(i)!=s2.charAt(i)){
     areEqual=false;
 break;
 }}
 if(areEqual){
 System.out.println("equal");
 }
 else{
     System.out.println("not equal");
 }

 }
 }
 public static void main(String args[]) {
 String s= "hello";
 String s1="hello4";
 Comparison st = new Comparison();
         st.compare(s, s1);
 }
 }

