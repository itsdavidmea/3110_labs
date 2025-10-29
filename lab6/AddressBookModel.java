
import java.util.*;

public class AddressBookModel {
    private ArrayList<BuddyInfo> collectionBuddyInfo;
    private List<AddressBookView> views;

    public AddressBookModel() {
        this.collectionBuddyInfo = new ArrayList<BuddyInfo>();
        views = new ArrayList<>();
    }



    public void addAddressBookView(AddressBookView view){

        views.add(view);
    }
    public void removeAddressBookView(AddressBookView view){

        views.remove(view);
    }

    public void setCollectionBuddyInfo(ArrayList<BuddyInfo> collectionBuddyInfo) {
        this.collectionBuddyInfo = collectionBuddyInfo;
    }

    public void addBuddy(String buddyName) {

        collectionBuddyInfo.add(new BuddyInfo(buddyName));

        for (AddressBookView view: views) {
            view.handleAddBuddyInfo( collectionBuddyInfo);

        }
    }

    public void removeBuddy(String buddyName) {


        for (BuddyInfo contact: collectionBuddyInfo) {
            if (contact.getName().equals(buddyName)) {
                collectionBuddyInfo.remove(contact);
            }
        }

        for (AddressBookView view: views) {
            view.handleAddBuddyInfo( collectionBuddyInfo);

        }
    }
}
