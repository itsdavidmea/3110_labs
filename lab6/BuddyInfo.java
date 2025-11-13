public class BuddyInfo {
    private String name;
    private String address;



    private String age;

    public BuddyInfo(String name, String address) {
        this.name = name;
        this.address = address;


    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name + " -- "+ address + "   ";
    }

    public static BuddyInfo importBuddyInfo(String element) {

        String[] inputValue = element.split(" -- ", 3);
        BuddyInfo newElement = new BuddyInfo(inputValue[0], inputValue[1] );

        return newElement;
    }

}
