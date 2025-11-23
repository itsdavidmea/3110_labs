import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookController implements ActionListener {
    private AddressBookModel model;
    private AddressBookFrame frame; // or just the JTextField
    private String currentFolder = "C:\\Users\\meada\\OneDrive\\Documents\\3rd Year Course\\3110_labs\\lab6";

    public AddressBookController(AddressBookModel model, AddressBookFrame frame) {

        this.model = model;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String name = frame.getInputName().getText();
        String address = frame.getInputAddress().getText();


        String command = e.getActionCommand();

        switch (command) {

            case "add":

                model.addBuddy(new BuddyInfo(name, address));
                break;

            case "remove":

                model.removeBuddy(new BuddyInfo(name, address));
                break;

            case "save":

                String fileName = saveItem();
                model.save((fileName));
                break;

            case "import":

                String fileImportName = importItem();
                model.importAddressBook((fileImportName));
                break;
            case "Seri_import":

                String fileNameSeriImport = importItem();
                model.importSerialization((fileNameSeriImport));
                break;
            case "Seri_save":

                String fileNameSeriSave = saveItem();
                model.exportSerialization((fileNameSeriSave));
                break;
            case "XMLimport":

                String fileNameXMLimport = importItemXML();
                model.importFromXmlFile((fileNameXMLimport));
                break;
            case "XMLexport":

                String fileNameXMLsave = saveItemXML();
                model.exportToXmlFile((fileNameXMLsave));
                break;
        }


    }

    public String saveItemXML() {

        FileDialog filePath = new FileDialog(this.frame, "Choose a file", FileDialog.SAVE);
        filePath.setDirectory(this.currentFolder);
        filePath.setFile("*.xml");
        filePath.setVisible(true);

        return filePath.getFile();

    }

    public String importItemXML() {

        FileDialog filePath = new FileDialog(this.frame, "Choose a file to import", FileDialog.LOAD);
        filePath.setFile("*.xml");
        filePath.setDirectory(this.currentFolder);
        filePath.setVisible(true);
        return filePath.getFile();

    }

    public String saveItem() {

        FileDialog filePath = new FileDialog(this.frame, "Choose a file", FileDialog.SAVE);
        filePath.setDirectory(this.currentFolder);
        filePath.setVisible(true);

        return filePath.getFile();

    }

    public String importItem() {

        FileDialog filePath = new FileDialog(this.frame, "Choose a file to import", FileDialog.LOAD);
        filePath.setDirectory(this.currentFolder);
        filePath.setVisible(true);
        return filePath.getFile();

    }


}
