import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddressBookFrame extends JFrame implements AddressBookView {

    private AddressBookModel model;
    private JButton addButton;
    private JButton removeButton;
    private JList<String> allContacts;

    private JTextField inputName;
    private AddressBookController controller;
    private JPanel westPanel;
    private JTextArea emptyContact;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu operations;
    private JMenuItem addBuddy;
    private JMenuItem removeBuddy;

    public AddressBookFrame() {
        super("AddressBook");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(333, 300);
        this.setLayout(new BorderLayout());

        model = new AddressBookModel();
        model.addAddressBookView(this);
        controller = new AddressBookController(model, this);


        westPanel = new JPanel(new BorderLayout());
        westPanel.add(new JTextArea("No contacts Yet"));
        JScrollPane scroll = new JScrollPane(westPanel);
        this.add(scroll, BorderLayout.WEST);



        inputName = new JTextField(20);
        addButton = new JButton("Add Buddy");
        removeButton = new JButton("Remove Buddy");

        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 5, 5));

        // === Row 1 (1 column) ===
        JPanel row1 = new JPanel();
        row1.add(inputName);

        // === Row 2 (2 columns) ===
        JPanel row2 = new JPanel(new GridLayout(1, 2, 5, 5));
        row2.add(addButton);
        row2.add(removeButton);

        mainPanel.add(row1);
        mainPanel.add(row2);

        addButton.setActionCommand("add:" + inputName.getText());
        removeButton.setActionCommand("remove:" + inputName.getText());

        addButton.addActionListener(controller);
        removeButton.addActionListener(controller);

        this.add(mainPanel, BorderLayout.CENTER);

        this.setVisible(true);

    }

    @Override
    public void handleAddBuddyInfo(DefaultListModel<String> collectionBuddyInfo) {
        westPanel.removeAll();
        allContacts = new JList<>(collectionBuddyInfo);
        westPanel.add(allContacts);

        if (allContacts.getModel().getSize() == 0) {
            westPanel.add(new JTextArea("No Contacts Yet"));
        }


    }

    public JTextField getInputName() {
        return inputName;
    }

    public static void main(String[] args) {
        AddressBookFrame frame = new AddressBookFrame();
    }
}

