import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Aug_11 {

    public static boolean TF[] = new boolean[10000];
    public static Queue<Integer> queue;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Prime(B);
            BFS(A,B);

        }
    }
    public static void BFS(int index){
        queue.add(index);
        while(!queue.isEmpty()){
            for(int i=1;i<=1000;i++){
                }
            }
            System.out.print(queue.poll()+" ");
        }

    public static void BFS(int A, int B) {
        A += 1;
        if (A == B) {
            if (!TF[A]) {
                BFS(A, B);
            }
        }
    }
    public static void Prime(int B) {
        TF[0] = true;
        TF[1] = true;
        for (int i = 0; i * i <= B; i++) {
            if (TF[i])
                continue;
            else {
                for (int j = i + i; j <= B; j += i) {
                    TF[j] = true;
                }
            }
        }
    }

    public static boolean check_Prime(int A){
        boolean P = true;
        for(int i=0;i*i<=A;i++){
            if(A%i==0){
                P = false;
                break;
            }
        }
        return P;
    }
}
