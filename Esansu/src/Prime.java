import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prime {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int [][] graph = new int[n+1][n+1];

        for(int i=0;i<m;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int length = Integer.parseInt(st2.nextToken());

            graph[a][b] = length;
            graph[b][a] = length;

        }

        System.out.println(prim(n,graph));
    }

    public static int prim(int n, int [][] graph){
        boolean[] visited = new boolean[n+1];
        int [][] graph2 = new int[n+1][n+1];
        visited[0] = true;
        visited[1] = true;
        int res = 0;
        int v = 1;
        int cnt = 1;

        while(cnt<n){
            for(int i=1;i<=n;i++){
                if(graph[v][i] != 0){
                    graph2[v][i] = graph[v][i];
                }
            }
            int min = compare(n, graph2);
            //System.out.print("min: "+ min + " ");

            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if (graph2[j][k]==min&&!visited[j]){
                        visited[j]=true;
                        res+=min;
                        cnt++;
                       // System.out.println("j: "+ j +"k: "+k);
                        graph2[j][k] = 0;
                        graph2[k][j] = 0;
                        graph[j][k] = 0;
                        graph[k][j] = 0;
                        v = j;
                       // System.out.println("v: " + v);
                    }
                    else if(graph2[j][k]==min&&!visited[k]){
                       // System.out.println("j: "+ j +" k: "+k);
                        visited[k]=true;
                        cnt++;
                        res+=min;
                        graph2[j][k] = 0;
                        graph2[k][j] = 0;
                        graph[j][k] = 0;
                        graph[k][j] = 0;
                        v = k;
                        // System.out.println("v: " + v);
                    }
                    else if((graph2[j][k] == min)&&visited[j]&&visited[k]){
                        graph[j][k] = 0;
                        graph[k][j] = 0;
                        graph2[k][j] = 0;
                        graph2[j][k] = 0;
                    }
                }
            }
        }
        return res;
    }
    public static int compare(int n, int [][] graph2){
        //System.out.println("compare 진입");
        int min = 2000000000;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(graph2[i][j]!=0)
                    min = Math.min(graph2[i][j], min);
            }
        }
        return min;
    }
}
