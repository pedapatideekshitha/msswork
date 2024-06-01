import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ObjSer implements Serializable{
    int i;
    String s;
    ObjSer(int i,String s){
        this.i=i;
        this.s=s;
    }

public static void main(String[] args) throws IOException,ClassNotFoundException {
    ObjSer o1= new ObjSer(1, "hii");
    ObjSer o2= new ObjSer(2, "world");

    ArrayList<Object> a= new ArrayList<>();
    a.add(o1);
    a.add(o2);
    FileOutputStream fo= new FileOutputStream("/home/miracle/Desktop/ObjSer.txt");
    ObjectOutputStream oo= new ObjectOutputStream(fo);
    oo.writeObject(a);


    FileInputStream fi=new FileInputStream("/home/miracle/Desktop/ObjSer.txt");
    ObjectInputStream oi= new ObjectInputStream(fi);
    ArrayList<ObjSer> o3= (ArrayList<ObjSer>) oi.readObject();
    Iterator i = o3.iterator();

    while (i.hasNext()) {
        ObjSer o=(ObjSer)i.next();
        System.out.println(o.i+" "+o.s);
        
    }
}
}
