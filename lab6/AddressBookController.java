import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookController implements ActionListener {
    private AddressBookModel model;
    private AddressBookFrame frame; // or just the JTextField

    public AddressBookController(AddressBookModel model, AddressBookFrame frame) {

        this.model = model;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {



       String name = frame.getInputName().getText();
       String address = frame.getInputAddress().getText();



        if (e.getActionCommand().startsWith("add")) {

            model.addBuddy(new BuddyInfo(name, address));



        } else if (e.getActionCommand().startsWith("remove")) {
            model.removeBuddy(new BuddyInfo(name, address));
        }

        System.out.println(model.toXML());


    }
}
