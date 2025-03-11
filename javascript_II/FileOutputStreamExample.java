import java.io.FileInputStream;

public class FileOutputStreamExample
{  
    public static void main(String args[])
    {    
        try
        {    
            FileInputStream fout = new FileInputStream("out.txt");    
            int output = fout.read();    
            fout.close();    
            System.out.println((char)output);    
         }catch(Exception e){System.err.println(e);}    
    }    
} 