
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class AddressBookModel extends DefaultListModel<BuddyInfo> {


    private List<AddressBookView> views ;



    public AddressBookModel() {

        views = new ArrayList<>();

    }



    public void addAddressBookView(AddressBookView view){

        views.add(view);
    }
    public void removeAddressBookView(AddressBookView view){

        views.remove(view);
    }

    public void addBuddy(BuddyInfo contact) {
        this.addElement(contact);
    }

    public void removeBuddy(BuddyInfo contact) {

        for(Object element:  this.toArray()) {
            if (element.toString().equals(contact.toString())) {
                this.removeElement(element);
                break;
            }

        }

    }

    public void save(String fileName) {

        try(FileOutputStream file = new FileOutputStream(fileName)) {
            for(Object element:  this.toArray()) {
                String data = element.toString() + "\n";
                file.write(data.getBytes());

            }

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }



}
