import javax.swing.*;
import java.util.ArrayList;

public interface AddressBookView {

    default void handleAddBuddyInfo(DefaultListModel<String> collectionBuddyInfo) {

    };
}
