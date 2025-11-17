
import javax.swing.*;
import java.io.*;
import java.util.*;

public class AddressBookModel extends DefaultListModel<BuddyInfo> implements Serializable {


    private List<AddressBookView> views;


    public AddressBookModel() {

        views = new ArrayList<>();

    }


    public void addAddressBookView(AddressBookView view) {

        views.add(view);
    }

    public void removeAddressBookView(AddressBookView view) {

        views.remove(view);
    }

    public void addBuddy(BuddyInfo contact) {
        this.addElement(contact);
    }

    public void removeBuddy(BuddyInfo contact) {

        for (Object element : this.toArray()) {
            if (element.toString().equals(contact.toString())) {
                this.removeElement(element);
                break;
            }

        }

    }

    public void save(String fileName) {

        try (FileOutputStream file = new FileOutputStream(fileName)) {
            for (Object element : this.toArray()) {
                String data = element.toString() + "\n";
                file.write(data.getBytes());

            }

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void importAddressBook(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

                this.addElement(BuddyInfo.importBuddyInfo(line));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(toXML());
        }


    }

    //serialisation
    public void export(String fileName) {

        try (FileOutputStream file = new FileOutputStream(fileName)) {
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(this);


        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }


    }


    public void importFile(String fileName) {

        try (FileInputStream file = new FileInputStream(fileName)) {
            ObjectInputStream oos = new ObjectInputStream(file);
            AddressBookModel newList = (AddressBookModel) oos.readObject();
            System.out.println(newList);


        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.toXML();


    }

    public String toXML(){

        String addressBookContent = "";
        for (Object element : this.toArray()) {
            BuddyInfo anElement = (BuddyInfo) element;
            addressBookContent +=  anElement.toXML() + "\n";

        }

        return "<addressBook>\n" + addressBookContent + "\n</addressBook>";

    }


}
