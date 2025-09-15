public static void main(String[] args) {



    BuddyInfo aBuddy = new BuddyInfo("David");
    ArrayList<BuddyInfo> aCollection = new ArrayList<BuddyInfo>();

    aCollection.add(aBuddy);
    AddressBook aBook = new AddressBook(aCollection);
}