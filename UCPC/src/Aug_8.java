import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Aug_8 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;

        for(int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());
            int[][] p = new int[2][N];
            for(int j=0;j<N;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[0][j] = Integer.parseInt(st.nextToken());
                p[1][j] = Integer.parseInt(st.nextToken());
                System.out.println(p[0][j] + ", "+ p[1][j]);


            }
        }
    }
}
