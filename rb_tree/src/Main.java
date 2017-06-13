/**
 * Created by zaGamer on 2017-06-06.
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        File f = new File("input//");
        if(!f.isDirectory())
            throw new IOException();
        File[] inputs = f.listFiles();
        for(int i = 0; i < inputs.length; i++) {
            if (inputs[i].isDirectory()) continue;
            if (!inputs[i].getName().contains("test")) continue;
            BufferedReader br = new BufferedReader(new FileReader(inputs[i]));
            rb_tree rb = new rb_tree();
            int n;

            while (true) {
                String line = br.readLine();
                line = onlyNum(line);
                n = Integer.parseInt(line);
                if (n > 0) rb.insert(n);
                else if (n < 0){
                    n = Math.abs(n);
                    //if(rb.search(rb.root,n)==null) System.out.println("Cannot delete "+n+": does not exist");
                    rb.delete(n);
                } else if (n == 0) break;
            }

            rb.numbering(rb.root);

            System.out.println("File Name: " + inputs[i].getName());
            System.out.println("total = " + rb.total);
            System.out.println("insert = " + rb.ins);
            System.out.println("deleted = " + rb.del);
            System.out.println("miss = " + rb.miss);
            System.out.println("nb = " + rb.nb);
            System.out.println("bh = " + rb.b_height());
            rb.inorder(rb.root);
            System.out.println();
        }
        }

    public static String onlyNum(String str) {
        if ( str == null ) return "";
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if( Character.isDigit( str.charAt(i) ) || str.charAt(i) == '-' ) { sb.append( str.charAt(i) ); }
        } return sb.toString();
    }
}