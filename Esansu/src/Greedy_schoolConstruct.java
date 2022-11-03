import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_schoolConstruct {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);            //정점의 개수 선언
        int E = Integer.parseInt(ip[1]);            //간선의 개수 선언

        boolean[][] map = new boolean[N+1][N+1];    //간선저장 배열
        int[] cnt = new int[N+1];                   //정점의 간선 갯수 세는 배열
        int[] res = new int[N];                     //선택받은 정점 저장 배열


        for(int i=0;i<E;i++){                                               //간선의 개수 입력받는 반복문
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;                                               //간선이 존재하면 부울값을 true 로 해준다.
        }

        int exit = N;                              //while 탈출변수
        int res_cnt = 0;                           //res 배열 인덱싱을 위한 변수

        while(exit>0){                              //exit 는 최초에 N(모든 정점의 수) 이고 정점이 탐색될 때마다 exit 를 감소시켜 탐색 완료후 탈출
            for(int i=1;i<=N;i++){                  //간선에 대한 접근을 위한 이중배열
                for(int j=1;j<=N;j++){
                    if(map[i][j]&&(cnt[i]!=-1)&&(cnt[j]!=-1)){  //간선이 존재하거나, 방문안했으면
                        cnt[i]++;                               //두 정점에 대해 count 증가
                        cnt[j]++;
                    }
                }
            }
            int max = Integer.MIN_VALUE;                        //최댓값 찾기 위한 max 변수 선언
            for(int i=1;i<=N;i++){                              //최댓값 찾는 반복문
                max = Math.max(cnt[i],max);
            }                                                   //최댓값 찾아서 max 로 선언
            int index = 0;                                      //cnt 가 가장큰 index 를 저장할 index 변수 선언
            for(int k=1;k<=N;k++){                              //cnt 배열에 대한 조사를 위한 반복문
                if(max == cnt[k]) {                             //max == cnt[k]즉 앞에서 찾은 cnt 의 배열과 max 값이 같을 때
                    index = k;              //그 k값은 index 에 저장
                    cnt[k] = -1;            //그리고 해당 index(k)의 cnt 값은 방문했다는 표시를 위해 -1로 정의
                    exit--;                 //index 하나를 찾았기 때문에 exit 감소(즉 전체배열(ex,1~10)에서 하나 배제되었다는 뜻)
                    res[res_cnt] = index;   //res 배열에 index 값을 넣어준다.
                    res_cnt++;              //그다음 배열에 값 삽입을 위해 res_cnt 변수 증가
                    break;                  //최대 간선갯수(cnt)를 갖는 index 찾았으니까 탈출
                }
            }
            for(int l=1; l<=N;l++){                                 //찾은 index 에 대해 인접 정점들을 탐색하기 위한 반복문
                if(map[index][l] || map[l][index] &&(cnt[l]!=-1)){  //index 를 포함하는 모든 간선들을 찾아준다(만약 그때 그 정점이 탐색되었다면 배제)
                    cnt[l] = -1;                        //찾은 정점에 대해 그 정점은 index 값에 의해 학교 건설이 필요없으므로 -1로 정의
                    for(int m=1;m<=N;m++){              //그다음 찾은 정점(l)에 대해 l 정점과 연결된 모든 간선을 제거
                        map[l][m] = false;
                        map[m][l] = false;
                    }
                    exit--;                             //찾은 정점들도 방문했으므로 전체 배열에서 빼 주어야 한다. 따라서 exit 를 감소
                }
            }
        }
        Arrays.sort(res);                               //찾은 index 들이 있는 배열 res 정렬
        for(int i=0;i<res.length;i++){                  //res 출력을 위한 반복문 선언
            if(res[i]!=0)                               //res 의 크기가 크기 떄문에, 원소가 0인 index 배제
                System.out.print(res[i]+" ");           //출력
        }
    }
}