import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DateValidator {

    public static int M,N,K;
    public static int[][] pos;
    public static int cnt;

    public static void jss(int x, int y){

        if(x<0 || x>M || y<0 || y>N || pos[x][y] == 2||pos[x][y]==0)
            return;
        pos[x][y] = 2;
        jss(x+1,y);
        jss(x,y+1);
        jss(x-1,y);
        jss(x,y-1);

    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            pos = new int[M+1][N+1];

            for(int j = 0;j<K;j++){
                String[] ip = br.readLine().split(" ");
                int x = Integer.parseInt(ip[0]);
                int y = Integer.parseInt(ip[1]);
                pos[x][y] = 1;
                }

            for(int a = 0;a<M;a++)
                for(int b=0;b<N;b++){
                    if(pos[a][b]==1){
                        jss(a,b);
                        cnt++;
                    }
                    else
                        continue;
                }
            sb.append(cnt).append("\n");
            cnt = 0;
        }
        System.out.print(sb);
    }
}
