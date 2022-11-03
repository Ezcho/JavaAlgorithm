import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Oct_16 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken())+(2*N-1);
        int C1 = Integer.parseInt(st.nextToken())+(2*N-1);
        int R2 = Integer.parseInt(st.nextToken())+(2*N-1);
        int C2 = Integer.parseInt(st.nextToken())+(2*N-1);


        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {

                int ai = (i%((2*N)-1))+1;
                int aj = (j%((2*N)-1))+1;

                if(ai<=N&&aj<=N){
                    int ascii = 97 + 2*N - ai - aj;

                    if(ascii>=97+N)
                        System.out.print(".");
                    else {
                        if (ascii>=123)
                            while(ascii>=123)
                                ascii= ascii-26;
                        char c = (char)(ascii);
                        System.out.print(c);
                    }
                }
                else if(ai<=N&&aj>N){
                    int ascii = 97 + aj - ai;
                    if(ascii >= 97+N)
                        System.out.print(".");
                    else {
                        if (ascii>=123)
                            while(ascii>=123)
                                ascii= ascii-26;
                        char c = (char)(ascii);
                        System.out.print(c);
                    }
                }
                else if(ai>N&&aj<=N) {
                    int ascii = 97 - aj + ai;
                    if (ascii >= 97+N)
                        System.out.print(".");
                    else {
                        if (ascii>=123)
                            while(ascii>=123)
                                ascii= ascii-26;
                        char c = (char)(ascii);
                        System.out.print(c);
                    }
                }
                else if(ai>N&&aj>N) {
                    int ascii = 97 -2*N +ai + aj;
                    if (ascii >= 97+N)
                        System.out.print(".");
                    else {
                        if (ascii>=123)
                            while(ascii>=123)
                                ascii= ascii-26;
                        char c = (char)(ascii);
                        System.out.print(c);
                    }
                }
            }
            System.out.println("");
        }
    }
}