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



        }

        if (e.getActionCommand().startsWith("remove")) {
            model.removeBuddy(new BuddyInfo(name, address));
        }

        if (e.getActionCommand().startsWith("save")) {


            String fileName = JOptionPane.showInputDialog("enter the file name to export");
            model.save((fileName));
        } else if (e.getActionCommand().startsWith("import")) {


            String fileName = JOptionPane.showInputDialog("enter the file name to import");
            model.importAddressBook((fileName));
        } else if (e.getActionCommand().startsWith("Seri_import")) {


            String fileName = JOptionPane.showInputDialog("enter the file name to import");
            model.importFile((fileName));

        } else if (e.getActionCommand().startsWith("Seri_save")) {


            String fileName = JOptionPane.showInputDialog("enter the file name to import from");
            model.export((fileName));
        } else if (e.getActionCommand().startsWith("XMLimport")) {


            String fileName = JOptionPane.showInputDialog("enter the file name to import from ");
            model.importFromXmlFile((fileName));

        } else if (e.getActionCommand().startsWith("XMLexport")) {


            String fileName = JOptionPane.showInputDialog("enter the file name to export to");
            model.exportToXmlFile((fileName));

        }



    }
}
