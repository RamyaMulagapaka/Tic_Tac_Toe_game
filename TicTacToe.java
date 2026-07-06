import java.util.Scanner;
import java.util.Arrays;
public class TicTacToe{
    static String[] board=new String[9];
    static String turn;
    static String player1;
    static String player2;
    static void print_Board(){
        System.out.println("|-----|-----|-----|");
        System.out.println("|  "+board[0]+"  |  "+board[1]+"  |  "+board[2]+"  |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|  "+board[3]+"  |  "+board[4]+"  |  "+board[5]+"  |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|  "+board[6]+"  |  "+board[7]+"  |  "+board[8]+"  |");
        System.out.println("|-----|-----|-----|");
    }
    static String checkWinner(){
        for(int i=0;i<9;i++){
            String line="";
            switch(i){
                case 0:
                    line=board[0]+board[1]+board[2];
                    break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                case 2:
                    line=board[6]+board[7]+board[8];
                    break;
                case 3:
                    line=board[0]+board[4]+board[8];
                    break;
                case 4:
                    line=board[2]+board[4]+board[6];
                    break;
                case 5:
                    line=board[0]+board[3]+board[6];
                    break;
                case 6:
                    line=board[1]+board[4]+board[7];
                    break;
                case 7:
                    line=board[2]+board[5]+board[8];
                    break;
            }
            if(line.equals("XXX")){
                return "X";
            }
            else if(line.equals("OOO")){
                return "O";
            }
        }
        for(int i=0;i<9;i++){
            if(Arrays.asList(board).contains(String.valueOf(i+1))){
                break;
            }
            else if(i==8){
                return "Draw";
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String winner=null;
        System.out.println("----Welcome to Tic Tac Toe Game---");
        for(int i=0;i<9;i++){
            board[i]=String.valueOf(i+1);
        }
        print_Board();
        System.out.print("Enter Player 1 Name : ");
        player1=sc.nextLine();
        System.out.print("Enter Player 2 Name : ");
        player2=sc.nextLine();
        System.out.print(player1+" : X"+"\n"+player2+" : O\n");
        System.out.println("Okay "+player1+". Let's start the game with you...");
        turn="X";
        System.out.print("Enter a slot number  from the board to keep X in  : ");
        while(winner==null){
            int pos=sc.nextInt();
            sc.nextLine();
            if(pos < 1 || pos > 9){
                System.out.println("Invalid slot.Enter slot correctly");
                continue;
            }
            else if(board[pos-1].equals("X")||board[pos-1].equals("O")){
                System.out.println("The slot is already filled.Try to enter a new slot number");
                continue;
            }
            else{
                board[pos-1]=turn;
                print_Board();
                winner=checkWinner();
                if(winner==null){
                    turn=turn.equals("X")?"O":"X";
                    if(turn.equals("X")){
                        System.out.println("It's "+player1+"'s turn.\n Enter a slot number to keep X in  : ");
                    }
                    else{
                        System.out.println("It's "+player2+"'s turn.\n Enter a slot number to keep O in  : ");
                    }
                }
            }
        }
        if(winner.equalsIgnoreCase("draw")){
            System.out.println("It's a draw! Thanks for playing.");
        }
        else{
            if(winner.equals("X")){
                System.out.println("Congratualtions! "+player1+", You won the game");
            }
            else{
                System.out.println("Congratualtions! "+player2+", You won the game");
            } 
        }

    }
}