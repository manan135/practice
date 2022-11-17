package TicTacToe;

import java.util.Arrays;

public class Board {
    final int size;
    private char[][] playboard;

    public boolean setValueOnBoard(int position, Player player) {
        int row =  ((position % size == 0) ? (position / size) - 1 : position / size);
        int col =  ((position % size == 0 ? size : position % size) - 1);
        playboard[row][col] = player.getSymbol();
        return checkIfPlayerWon(row, col);
    }

    private boolean checkIfPlayerWon(int row, int col) {
        char sym = playboard[row][col];
        int hor = 0, ver = 0, fwdDia = 0, backDia = 0;
        for (int i = 0; i < size; i++) {
            if (playboard[row][i] == sym)
                hor++;
            if(playboard[i][col] == sym)
                ver++;
            if(row == col && playboard[i][i] == sym)
                fwdDia++;
            if(row + col == size - 1 && playboard[i][size - i - 1] == sym) {
                backDia++;
            }
        }
        return backDia == size || hor == size || ver == size|| fwdDia == size;
    }

    public boolean validPosition(int position) {
        if (position < 1 || position > (size * size)) return false;
        int row = ((position % size == 0) ? (position / size) - 1 : position / size);
        int col = ((position % size == 0 ? size : position % size) - 1);
        return playboard[row][col] == '_';
    }

    public void  printBoard(){
        for (char[] row : playboard) {
            for (char col : row) {
                System.out.print(col+" ");
            }
            System.out.println();
        };
    }
    public Board(int size) {
        this.size = size;
    }

    public void init() {
        playboard = new char[size][size];
        for(int i=0;i<size;i++){
          for(int j=0;j<size;j++){
              playboard[i][j] = '_';
          }
        }

    }
}