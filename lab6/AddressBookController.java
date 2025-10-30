import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookController implements ActionListener {
    AddressBookModel model;
    private AddressBookFrame frame; // or just the JTextField

    public AddressBookController(AddressBookModel model, AddressBookFrame frame) {
        this.model = model;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       String inputValue = frame.getInputName().getText();
       BuddyInfo inputBuddy = new BuddyInfo(inputValue);

        if (e.getActionCommand().startsWith("add")) {
            model.addBuddy(inputBuddy);

        } else if (e.getActionCommand().startsWith("remove")) {
            model.removeBuddy(inputBuddy);
        }


    }
}
