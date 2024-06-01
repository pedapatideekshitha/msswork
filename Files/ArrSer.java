import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ArrSer implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList a= new ArrayList<>();
        a.add(1);
        a.add("hi");
        a.add('a');

        ArrayList a1= new ArrayList<>();
        a1.add(3);
        a1.add("vc");


        FileOutputStream fo= new FileOutputStream("/home/miracle/Desktop/ser.txt");
        ObjectOutputStream oo= new ObjectOutputStream(fo);
        oo.writeObject(a);
        oo.writeObject(a1);

        fo.close();
        oo.close();


        FileInputStream fi=new FileInputStream("/home/miracle/Desktop/ser.txt");
        ObjectInputStream oi=new ObjectInputStream(fi);
        try{
        while(true){
        System.out.println(oi.readObject());
        }
        }
        catch(Exception e){
        }
    }
}
