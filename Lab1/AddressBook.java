
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<BuddyInfo> collectionBuddyInfo;

    public AddressBook() {
        this.collectionBuddyInfo = new ArrayList<BuddyInfo>();
    }



    public void setCollectionBuddyInfo(ArrayList<BuddyInfo> collectionBuddyInfo) {
        this.collectionBuddyInfo = collectionBuddyInfo;
    }

    public void addBuddy(BuddyInfo buddy) {
        collectionBuddyInfo.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        collectionBuddyInfo.remove(buddy);
    }
}
