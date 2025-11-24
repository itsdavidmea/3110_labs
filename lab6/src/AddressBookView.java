import javax.swing.*;
import java.awt.event.ActionListener;

public interface AddressBookView extends ActionListener {

    default void handleAddBuddyInfo(DefaultListModel<String> collectionBuddyInfo) {

    };


}
