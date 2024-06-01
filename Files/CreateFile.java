import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateFile extends IOException{
public static void main(String[] args) throws FileNotFoundException,IOException{
    File f= new File("/home/miracle/Desktop/file1.txt");
    try{
    if(f.createNewFile()){
        System.out.println("done");
    }
    }
    catch(FileNotFoundException e){
        System.out.println(e);
    }
    System.out.println(f.length());
}    
}
