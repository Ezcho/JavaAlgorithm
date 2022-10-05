import java.io.*;
public class Practice_1 {
    public static void main(String args[]) {
        try {
            double Time;
            long start = System.currentTimeMillis();                                     //시간 측정 시작
            BufferedReader br = new BufferedReader(new FileReader("1.in"));     //파일 읽어오기

            String str;                                                                  //각 줄을 읽을 문자열 선언
            while ((str = br.readLine()) != null) {   //readLine 으로 한 줄씩 읽고 맨끝라인까지 반복문 진행
                if (str.equals("6896383")) break;     //찾고싶은값이 나타나면 반복문 탈출
            }
            br.close();
            long end = System.currentTimeMillis();         //시간 측정 종료
            Time = (double) (end - start) / 1000;      //전체 시간 계산(소숫점 형태 표현을 위해 double 로 형변환)
            System.out.println(Time);
        } catch (FileNotFoundException e) {                    //파일이 존재하지 않을 경우
            System.out.println("File not found");          //File not    found 출력
        } catch (IOException e2) {                             //파일이 존재하나 읽을 수 없을 경우
            System.out.println("Cannot read file");        //Cannnot read file 출력
        }
    }
}
