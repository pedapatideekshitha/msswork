import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class ReadFile {
    // public static void main(String[] args) throws FileNotFoundException,IOException {
    //     FileInputStream fi= new FileInputStream("/home/miracle/Desktop/file1.txt");
    //     BufferedInputStream b=new BufferedInputStream(fi);
    //     // System.out.println(fi.read());
    //     int i;
    //     while ((i = b.read()) != -1) {
    //         System.out.print((char) i);
    //     }
    

    //     fi.close();
    // }

//     public static void main(String[] args) throws FileNotFoundException,IOException {
        
//    String s= " hello";
//    byte[] b= s.getBytes();
//    ByteArrayInputStream by = new ByteArrayInputStream(b);
//    int i = by.read();
//    while(i!=-1){
// System.out.println((char)i);
// i=by.read();
//    }
//     }


public static void main (String[] args) throws FileNotFoundException, IOException {
   FileInputStream f1= new FileInputStream("/home/miracle/Desktop/f1.txt");
   FileInputStream f2= new FileInputStream("/home/miracle/Desktop/f2.txt");
   SequenceInputStream s= new SequenceInputStream(f1, f2);
   FileOutputStream f3= new FileOutputStream("/home/miracle/Desktop/f3.txt");
   int i;
   while ((i = s.read()) != -1) {
       System.out.print((char) i);
       f3.write((char)i);

   }
   s.close();
   f1.close();
   f2.close();
   f3.close();
   

}
}
