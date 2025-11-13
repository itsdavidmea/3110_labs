import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddressBookFrame extends JFrame implements AddressBookView {

    private AddressBookModel model;
    private AddressBookController controller;

    //south panel
    private JPanel southPanel;
    private JButton addButton;
    private JButton removeButton;


    //main panel
    private JPanel mainPanel;
    private JLabel buddyName = new JLabel("Buddy Name:");
    private JTextField inputName;
    private JOptionPane userInput;

    private JLabel buddyAddress = new JLabel("Buddy Address:");



    private JTextField inputAddress;


    //west panel
    private JPanel westPanel;
    private JList<BuddyInfo> allBuddy;

    //menubar
    private JMenuBar menuBar = new JMenuBar();
    private JMenu operations;
    private JMenuItem addBuddy;
    private JMenuItem removeBuddy;
    private JMenuItem saveAddressBook;



    public AddressBookFrame() {
        super("AddressBook");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());
        setResizable(false);

        model = new AddressBookModel();
        model.addAddressBookView(this);
        allBuddy = new JList<>(model);

        controller = new AddressBookController(model, this);

        //Set Menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        operations = new JMenu("Operations");
        menuBar.add(operations);

        addBuddy = new JMenuItem("Add Friend");
        removeBuddy = new JMenuItem("Remove Friend");
        saveAddressBook = new JMenuItem("Save");
        operations.add(addBuddy);
        operations.add(removeBuddy);
        operations.add(saveAddressBook);


        //westPanel
        westPanel = new JPanel(new BorderLayout());
        westPanel.add(new JTextArea("No contacts Yet"));




        JScrollPane scroll = new JScrollPane(westPanel);
        scroll.setPreferredSize(new Dimension(100, 300));






        //main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        inputName = new JTextField(10);
        inputAddress = new JTextField(10);

        mainPanel.add(buddyName);
        mainPanel.add(inputName);
        mainPanel.add(buddyAddress);
        mainPanel.add(inputAddress);

        // south panel
        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        addButton = new JButton("Add Buddy");
        removeButton = new JButton("Remove Buddy");
        southPanel.add(addButton);
        southPanel.add(removeButton);


        addButton.setActionCommand("add:");
        addButton.addActionListener(controller);

        removeButton.setActionCommand("remove:");
        removeButton.addActionListener(controller);

        addBuddy.setActionCommand("add:");
        addBuddy.addActionListener(controller);

        removeBuddy.setActionCommand("remove:");
        removeBuddy.addActionListener(controller);

        saveAddressBook.setActionCommand("save");
        saveAddressBook.addActionListener(this);

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(allBuddy, BorderLayout.WEST);




        setVisible(true);

    }

    @Override
    public void handleAddBuddyInfo(DefaultListModel<String> collectionBuddyInfo) {
//        westPanel.removeAll();



    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().startsWith("save")) {


            String fileName = JOptionPane.showInputDialog("enter the file name to export");
            model.save((fileName));
        }

    }


    public JTextField getInputName() {
        return inputName;
    }

    public JTextField getInputAddress() {
        return inputAddress;
    }

    public static void main(String[] args) {
        AddressBookFrame frame = new AddressBookFrame();
    }


}

