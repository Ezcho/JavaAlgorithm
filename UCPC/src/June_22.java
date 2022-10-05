import java.util.Scanner;


public class June_22 {
    public static int V;    //정점의 개수
    public static int E;    //간선의 개수
    public static int[][] G;    //간선을 정의할 배열
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] NV = sc.nextLine().split(" ");
        V = Integer.parseInt(NV[0]);
        E = Integer.parseInt(NV[1]);
        G = new int[E +1][E +1];    //0일때는 생각안하고 간선의 개수에 G의 개수를 맞춘다.
        int K = sc.nextInt();
        System.out.println("K is "+ K);

        for(int i = 1; i<= E; i++){  //간선배열 입력받기 a b w
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            if(0!=G[a][b] && G[a][b]>w) {
                G[a][b] = w;
                G[b][a] = w;
            }
            else if(G[a][b] == 0){
                G[a][b] = w;
                G[b][a] = w;
            }
        }
        Dijkstra(K);
    }

    public static void Dijkstra(int start){
        System.out.println("함수 진입");
        int[] distance = new int[E+1];        //거리배열
        boolean[] visit = new boolean[E+1];   //방문여부 배열
        distance[start] = 0;
        visit[start] = true;

        for(int i = 1; i< V +1; i++){
            if(G[start][i]>0){
                distance[i] = G[start][i];
            }
        }

        System.out.println("초기화 반복문 통과");

        for(int j = 1; j<= E-1; j++){
            int min_index = min_index(distance, visit);
            visit[min_index] = true;
            for(int k = 1; k<= E; k++){
                if(!visit[k]){
                    int add = distance[min_index] + G[min_index][k];
                    if(add>distance[k]){
                        distance[k] = add;
                    }
                }
            }

        }

        for(int i = 0; i< E; i++){
            if(distance[i] == 0) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
    public static int min_index(int[] d, boolean[] visit){
        int min = Integer.MAX_VALUE;
        int index = E +1;
        for(int i=1;i<=E;i++){
            if(d[i] !=0 && d[i]<min && !visit[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }
}
