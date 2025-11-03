
import static org.junit.Assert.*;

public class gameTest {



        @org.junit.Before





        @org.junit.Test
        public void getStatusForInitialTicTacToe(){
            TicTacToeModel model = new TicTacToeModel();
            assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        }


        @org.junit.Test
        public void getStatusAfterFirstMove(){
            TicTacToeModel model = new TicTacToeModel();
            assertTrue(model.getTurn());
            model.play(1, 1);
            assertFalse(model.getTurn());



        }

    @org.junit.Test
    public void TestXwins(){
        TicTacToeModel model = new TicTacToeModel();
        assertTrue(model.getTurn());
        model.play(1, 1);
        assertFalse(model.getTurn());
        model.play(0, 1);
        model.play(2, 2);
        model.play(0, 2);
        model.play(0, 0);

        assertEquals(TicTacToeModel.Status.X_WON, model.getStatus());


    }

    @org.junit.Test
    public void TestOwins(){
        TicTacToeModel model = new TicTacToeModel();

        model.play(1, 1);

        model.play(0, 0);
        model.play(2, 2);
        model.play(0, 1);
        model.play(1, 0);
        model.play(0, 2);

        assertEquals(TicTacToeModel.Status.O_WON, model.getStatus());


    }

    @org.junit.Test
    public void TestTie(){
        TicTacToeModel model = new TicTacToeModel();

        model.play(0, 0);

        model.play(0, 1);
        model.play(0, 2);

        model.play(1, 1);
        model.play(1, 0);
        model.play(1, 2);
        model.play(2, 2);
        model.play(2, 0);
        model.play(2, 1);

        assertEquals(TicTacToeModel.Status.TIE, model.getStatus());


    }


    }


