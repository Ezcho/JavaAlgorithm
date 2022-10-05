import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sep_20 {
    public static void main(String args[]) throws IOException {

        long BT = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("1.in"));

        String str;
        while((str = br.readLine())!=null){
        }

        br.close();
        long AT = System.currentTimeMillis();
        double Time = AT-BT/1000;
        System.out.println(Time);


    }
}
