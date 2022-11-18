package TicTacToe;

public class Player {
    private final String id;
    private final String name;
    private final char symbol;

    public Player(String id, String name, char symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public char getSymbol() {
        return symbol;
    }

}
