import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {

    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;
    private int numberOfFreeSquares = 9;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED}

    ;

    private char[][] grid;
    private boolean turn;
    private Status status;
    private List<TicTacToeView> views;

    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
    }

    public void addTicTacToeView(TicTacToeView view) {
        views.add(view);
    }

    public void removeTicTacToeView(TicTacToeView view) {
        views.remove(view);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {
        return status;
    }

    private void updateStatus(int row, int col) {


        numberOfFreeSquares--;
        findWinner(row, col);





    }

    public boolean getTurn() {
        return turn;
    }


    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn ? 'X' : 'O';
        updateStatus(x, y);
        for (TicTacToeView view : views) {
            view.handelTicTacToeStatusUpdate(this, status, x, y);
        }
        changeTurn();
    }

    public void findWinner(int row, int col) {

        //check row
        if (grid[row][0] == (grid[row][1]) &&
                grid[row][0] == (grid[row][2])) {


            if (grid[row][0] == 'X') {
                status = Status.X_WON;
            } else {
                status = Status.O_WON;
            }
        }


        //check column
        if (grid[0][col] == (grid[1][col]) &&
                grid[0][col] == (grid[2][col])) {

            if (grid[0][col] == 'X') {
                status = Status.X_WON;
            } else {
                status = Status.O_WON;
            }

        }

        // if row=col check one diagonal
        if (row == col)
            if (grid[0][0] == grid[1][1] &&
                    grid[0][0] == grid[2][2]) {

                if (grid[0][0] == 'X') {
                    status = Status.X_WON;
                } else {
                    status = Status.O_WON;
                }

            }

        // if row=2-col check other diagonal
        if (row == 2 - col)
            if (grid[0][2] == grid[1][1] &&
                    grid[0][2] == grid[2][0]) {

                if (grid[1][1] == 'X') {
                    status = Status.X_WON;
                } else {
                    status = Status.O_WON;
                }
            }


        if (status != Status.O_WON || status != Status.X_WON ) {
            if (status == Status.UNDECIDED && numberOfFreeSquares == 0) {
                status = Status.TIE;
            }

        }

    }
}

