
import static org.junit.Assert.*;


public class TicTacToeModelTest {

    @org.junit.Before



    @org.junit.Test
    public void getStatusForInitialTicTacToe(){
        TicTacToeModel model = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
    }


    @org.junit.Test
    public void getStatusAfterFirstMove(){
        TicTacToeModel model = new TicTacToeModel();
        model.play(1, 1);
        assertEquals();
    }
}

