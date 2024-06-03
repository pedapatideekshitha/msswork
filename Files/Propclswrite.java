import java.util.*;  
import java.io.*;  
public class Propclswrite {  
public static void main(String[] args)throws Exception{  
  
Properties p=new Properties();  
p.setProperty("name","Sonoo Jaiswal");  
p.setProperty("email","sonoojaiswal@javatpoint.com");  
  
p.store(new FileWriter("/home/miracle/Desktop/exam.properties")," ");  
  
}  
}  