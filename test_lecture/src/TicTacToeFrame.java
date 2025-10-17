import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements  TicTacToeView{

    private JButton [][] buttons;
    TicTacToeModel model;

    public TicTacToeFrame() {
        super("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(333,300);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE,TicTacToeModel.SIZE));

        model = new TicTacToeModel();
        model.addTicTacToeView(this);


        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];
        JButton button;
        TicTacToeController tttc = new TicTacToeController(model);
        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                button = new JButton("");
                button.setActionCommand(i+ " " + j);
                buttons[i][j] =  button;
                button.addActionListener(tttc);
                this.add(button);
            }
        }
        this.setVisible(true);
    }

    @Override
    public void handelTicTacToeStatusUpdate(TicTacToeModel ticTacToeModel, TicTacToeModel.Status status, int x, int y) {
        String label = model.getTurn()? "X" :"O";
        this.buttons[x][y].setText(label);
    }

    public static void main(String[] args) {
        TicTacToeFrame frame = new TicTacToeFrame();
    }
}
