
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<BuddyInfo> collectionBuddyInfo = new ArrayList<BuddyInfo>();

    public AddressBook(ArrayList<BuddyInfo> collectionBuddyInfo) {
        this.collectionBuddyInfo = collectionBuddyInfo;
    }

    public ArrayList<BuddyInfo> getCollectionBuddyInfo() {
        return collectionBuddyInfo;
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
