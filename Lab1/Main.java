public class Main {
    public static void main(String[] args) {



        BuddyInfo aBuddy = new BuddyInfo("David");
        AddressBook aBook = new AddressBook();
        aBook.addBuddy(aBuddy);
        aBook.removeBuddy(aBuddy);

        System.out.println("Address Book");
        System.out.println("new change");
        //try editing the code on github
        //this is a change from the testing-branch
    }
}

