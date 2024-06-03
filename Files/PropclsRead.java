import java.util.*;  
import java.io.*;  
public class PropclsRead {  
public static void main(String[] args)throws Exception{  
    FileReader reader=new FileReader("/home/miracle/Desktop/example.properties");  
      
    Properties p=new Properties();  
    p.load(reader);  
      
    System.out.println(p.getProperty("user"));  
    System.out.println(p.getProperty("pass"));  
    System.out.println(p.getProperty("password"));  

}  
}  