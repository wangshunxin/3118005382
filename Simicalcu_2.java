package xiangsidu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Simicalcu_2{
    public static void main(String[] args) throws IOException{
    	String str1="";
        File file1=new File(args[0]);
        FileInputStream in1= null;
        in1 = new FileInputStream(file1);
        // size  为字串的长度 ，这里一次性读完
        int size1=in1.available();
        byte[] buffer1=new byte[size1];
        in1.read(buffer1);
        in1.close();
        str1=new String(buffer1,"utf8");

        String str2="";
        File file2=new File(args[1]);
        FileInputStream in2=new FileInputStream(file2);
        // size  为字串的长度 ，这里一次性读完
        int size2=in2.available();
        byte[] buffer2=new byte[size2];
        in2.read(buffer2);
        in2.close();
        str2=new String(buffer2,"utf8");
        DecimalFormat df= new DecimalFormat("######0.00");
        String result = df.format(Computeclass.SimilarDegree(str1, str2));
        System.out.print("重复率:"+result);        
        String str3 = args[2];
        FileOutputStream  ou = new FileOutputStream(str3);        
        ou.write(result.getBytes());
        ou.close();
        
    }
}
