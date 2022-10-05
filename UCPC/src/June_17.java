
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class June_17 {
    public static boolean[] visited = new boolean[1001];
    public static boolean[] visited_B = new boolean[1001];
    public static Queue<Integer>queue = new LinkedList<Integer>();
    public static int[][] g = new int[1001][1001];
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N; int M; int V;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            g[a][b] = 1; g[b][a] = 1;
        }
        DFS(V);
        System.out.print("\n");
        BFS(V);
    }
    public static void DFS(int index){
        System.out.print(index+" ");
        visited[index] = true;
        for(int i=1;i<=1000;i++){
            if(g[index][i]==1 && !visited[i])
                DFS(i);
        }
    }
    public static void BFS(int index){
        queue.add(index);
        while(!queue.isEmpty()){
            for(int i=1;i<=1000;i++){
                if(g[queue.peek()][i]==1 && !visited_B[i]){
                    queue.add(i);
                    visited_B[i] = true;
                }
            }
            System.out.print(queue.poll()+" ");
        }
    }
}

