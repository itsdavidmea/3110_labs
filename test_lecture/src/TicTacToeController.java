import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {
    TicTacToeModel model;

    public TicTacToeController(TicTacToeModel model) {
        this.model = model;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String [] coord = actionEvent.getActionCommand().split(" ");
        model.play(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));

    }
}
