import java.util.Scanner;

public class Practice_4 {

    static int Num[][] = new int[16][16];
    public static int cnt = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double N = sc.nextInt();
        int hole_x = sc.nextInt();
        int hole_y = sc.nextInt();
        double pow = Math.pow(2, N);
        int size = (int)pow;

        Num[hole_y-1][hole_x-1] = -1;
        tile_board_DC(size, 0, 0);
        Print_tile(Math.pow(2,N));
    }

    public static void tile_board_DC(int l, int x, int y) {
        cnt++;
        l = l / 2;
        if (check(l, x, y)) {
            Num[x + l - 1][y + l - 1] = cnt;
        }
        if (check(l, x + l, y)) {
            Num[x + l][y + l - 1] = cnt;
        }
        if (check(l, x, y + l)) {
            Num[x + l - 1][y + l] = cnt;
        }
        if (check(l, x + l, y + l)) {
            Num[x + l][y + l] = cnt;
        }
        if (l == 1) return;

        tile_board_DC(l, x, y);
        tile_board_DC(l, x + l, y);
        tile_board_DC(l, x, y + l);
        tile_board_DC(l, x + l, y + l);

    }


    public static void Print_tile(double size) {
        for (int i = 0; i < size; i++) {
            System.out.print("\n");
            for (int j = 0; j < size; j++) {
                System.out.print(Num[i][j] + " ");
            }
        }
    }

    public static boolean check(int l, int x, int y) {
        for (int i = x; i < x + l; i++)
            for (int j = y; j < y + l; j++) {
                if (Num[i][j] != 0) return false;
            }
        return true;
    }

}