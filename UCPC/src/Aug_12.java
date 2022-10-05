import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Aug_12 {

    public static boolean[] TF;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));


        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        TF = new boolean[N+1];
        jss();
        int res = 0;
        int min = 10000;
        for(int k=M;k<=N;k++){
            if(!TF[k]) {
                res += k;
                if(k<min)
                    min = k;
            }
        }
        if(res == 0)
            System.out.println(-1);
        else{
            System.out.println(res);
            System.out.println(min);
        }
    }

    public static void jss(){

        TF[0] = true;
        TF[1] = true;


        for(int i=0;i*i<=TF.length;i++){
            if(TF[i])
                continue;
            for(int j=i+i;j< TF.length;j+=i)
                TF[j]=true;
        }

    }

}

