
import javax.swing.*;
import java.util.*;

public class AddressBookModel {


    private List<AddressBookView> views;
    public DefaultListModel<String> collectionBuddyInfo = new DefaultListModel<>();

    public AddressBookModel() {

        views = new ArrayList<>();
    }



    public void addAddressBookView(AddressBookView view){

        views.add(view);
    }
    public void removeAddressBookView(AddressBookView view){

        views.remove(view);
    }



    public void addBuddy(BuddyInfo buddy) {

        collectionBuddyInfo.addElement(buddy.toString());

        for (AddressBookView view: views) {
            view.handleAddBuddyInfo(collectionBuddyInfo);

        }
    }

    public void removeBuddy(BuddyInfo buddyTodelete) {

        for (int i =0; i < collectionBuddyInfo.size(); i++) {
            String buddyMatch = collectionBuddyInfo.get(i).toString();
            if (buddyMatch.equals(buddyTodelete.toString())){

                for (AddressBookView view: views) {
                    collectionBuddyInfo.remove(i);
                    view.handleAddBuddyInfo( collectionBuddyInfo);


                }
                break;
            }
        }




    }
}
