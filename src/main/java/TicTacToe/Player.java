package TicTacToe;

public class Player {
    private final int id;
    private final String name;
    private final char symbol;

    public Player(int id, String name, char symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public char getSymbol() {
        return symbol;
    }

}
