import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookController implements ActionListener {
    AddressBookModel model;

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputValue = e.getActionCommand().substring(4);

        if (e.getActionCommand().startsWith("add:")) {
            System.out.println("add");
            model.addBuddy(inputValue);

        } else if (e.getActionCommand().startsWith("remove:")) {
            model.removeBuddy(inputValue);
        }


    }
}
