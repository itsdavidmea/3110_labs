import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface AddressBookView extends ActionListener {

    default void handleAddBuddyInfo(DefaultListModel<String> collectionBuddyInfo) {

    };


}
