import java.util.Scanner;

public class Marbles {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Marbles!");
        System.out.println("In this game, there are n marbles in a bag");
        System.out.println("On each turn, the current player may pick up 1 to k marbles.");
        System.out.println("The player who picks up the last marble loses the game.");

        String option;

        String P1 = null, P2 = null;
        boolean name_check = true;
        boolean game_progress = true;

        while(game_progress){
            System.out.print("Options: (P)LAY, (H)ELP, (E)XIT. Enter your choice: ");
            option = sc.next();

            switch(option){
                case "E": case "e": case "exit": case "EXIT":
                    System.out.print("Thanks for playing Marbles!");
                    game_progress = false;
                    break;

                case "H": case "h": case "HELP": case "help":
                    System.out.println("In this game, there are n marbles in a bag.");
                    System.out.println("On each turn, the current player may pick up 1 to k marbles.");
                    System.out.println("The player who picks up the last marble loses the game.");
                    break;

                case "P": case "p": case "play": case "PLAY":
                    if(name_check) {
                        System.out.print("Enter player 1's name: ");
                        P1 = sc.next();
                        System.out.print("Enter player 2's name: ");
                        P2 = sc.next();
                        name_check = false;
                    }
                    String ipN, ipK;
                    int N, K;
                    while(true){
                        System.out.print("Enter the total number of marbles in the bag: ");
                        ipN = sc.next();
                        boolean b_N = true;
                        for(int i=0; i<ipN.length();i++){
                            if(ipN.charAt(i)<48||ipN.charAt(i)>57){
                                System.out.println(ipN + " is not a valid number of marbles. Try again.");
                                b_N = false;
                                break;
                            }
                        }
                        if(b_N) {
                            N = Integer.parseInt(ipN);
                            if(N!=0)
                                break;
                            else
                                System.out.println(N + " is not a valid number of marbles. Try again.");
                        }
                    }
                    while(true){
                        System.out.print("Enter the max number of marbles a player can pick, each turn: ");
                        ipK = sc.next();
                        boolean b_K = true;
                        for(int i=0; i<ipK.length();i++){
                            if(ipK.charAt(i)<48||ipK.charAt(i)>57){
                                System.out.println(ipK + " is not a valid number of marbles. Try again.");
                                b_K = false;
                                break;
                            }
                        }
                        if(b_K) {
                            K = Integer.parseInt(ipK);
                            if(K>=1&&K<=N)
                                break;
                            else
                                System.out.println(K + " is not a valid number of marbles. Try again.");
                        }
                    }
                    while(true){

                        int pick_marbles;
                        while(true){
                            System.out.println("There are "+N+" marble(s) in the bag.");
                            System.out.print(P1+", how many marbles do you want to pick? ");
                            pick_marbles = sc.nextInt();
                            if(pick_marbles>K||pick_marbles<=0||pick_marbles>N) {
                                System.out.println(pick_marbles+" is not a valid number of marbles. Try again.");
                            }
                            else
                                break;
                        }
                        N = N - pick_marbles;
                        if(N==0) {
                            System.out.println(P1 + " picks up the last marble.");
                            System.out.println(P2 + " wins!");
                            break;
                        }
                        while(true){
                            System.out.println("There are "+N+" marble(s) in the bag.");
                            System.out.print(P2+", how many marbles do you want to pick? ");
                            pick_marbles = sc.nextInt();
                            if(pick_marbles>K||pick_marbles<=0||pick_marbles>N) {
                                System.out.println(pick_marbles+" is not a valid number of marbles. Try again.");
                            }
                            else
                                break;
                        }
                        N = N - pick_marbles;
                        if(N==0) {
                            System.out.println(P2 + " picks up the last marble.");
                            System.out.println(P1 + " wins!");
                            break; 
                        }
                    }
                    break;

                default:
                    System.out.println("Option not recognized.");
            }
        }
    }
}
