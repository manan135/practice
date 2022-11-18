package TicTacToe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private int id;
    private ArrayList<Player> players = new ArrayList<>();
    private Board board;
    Scanner input = new Scanner(System.in);
    private int currTurn;
    private int playCount;

    public void setup() {
        playCount = 0;
        //create players
        //get board instance
        System.out.println("Enter Player1 name:");
        Player p1 = new Player("1", input.nextLine(), 'X');
        players.add(p1);
        System.out.println("Enter Player2 name:");
        Player p2 = new Player("2", input.nextLine(), '0');
        players.add(p2);

        currTurn = 0;

        this.board = new Board(4);
        board.init();
        board.printBoard();
    }

    public String play() {
        int noOfSlots = board.size * board.size;
        while (playCount < noOfSlots) {
            System.out.println(players.get(currTurn).getName() + ", Choose a number between 1 - " + noOfSlots + ":");

            try{
            int in = input.nextInt();

            if (board.validPosition(in)) {
                if (board.setValueOnBoard(in, players.get(currTurn))) {
                    board.printBoard();
                    return players.get(currTurn).getName() + " has won the match";
                }
                board.printBoard();
                currTurn = (1 + currTurn) % players.size();
                playCount++;
            } else {
                System.out.println("Enter a valid position");
            }} catch (InputMismatchException e){
                System.out.println("Enter a valid Integer");
            }
        }
        return "Match Drawn";
    }
}
