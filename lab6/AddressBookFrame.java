import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddressBookFrame extends JFrame implements AddressBookView {

    private AddressBookModel model;
    private JButton addButton;
    private JButton removeButton;
    private JTextField allContacts;
    private JTextField inputName;
    private AddressBookController controller;
    public AddressBookFrame() {
        super("AddressBook");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(333,300);
        this.setLayout(new BorderLayout());

        model = new AddressBookModel();
        model.addAddressBookView(this);

        //add textField to the west
        allContacts = new JTextField();
        //allContacts.setBounds(180, 50, 1000, 25);
        allContacts.setText("No Contacts Yet");
        this.add(allContacts, BorderLayout.WEST);




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





        // add Name textfield to the right

        //button add buddy

        //button remove buddy

        this.setVisible(true);

    }


    @Override
    public void handleAddBuddyInfo( ArrayList<BuddyInfo> collectionBuddyInfo) {
        StringBuilder container = new StringBuilder();
        for (BuddyInfo contact: collectionBuddyInfo) {
            container.append("\n").append(contact.getName());
        }
        System.out.println(container);

        if (container.toString().isEmpty()) {
            allContacts.setText("No contacts Yet");
        } else {
            allContacts.setText(container.toString());
        }



    }

    public JTextField getInputName() {
        return inputName;
    }

    public static void main(String[] args) {
        AddressBookFrame frame = new AddressBookFrame();
    }
}

