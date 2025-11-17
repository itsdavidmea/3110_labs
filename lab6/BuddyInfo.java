public class BuddyInfo {
    private String name;
    private String address;


    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BuddyInfo(String name, String address) {
        this.name = name;
        this.address = address;


    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " -- " + address ;
    }

    public static BuddyInfo importBuddyInfo(String element) {

        System.out.println(element);
        String[] inputValue = element.split(" -- ", 2);
        BuddyInfo newElement = new BuddyInfo(inputValue[0], inputValue[1]);

        return newElement;
    }

    public String toXML() {

        return "\t<BuddyInfo>\n\t\t\t"
                + "<name>" + this.name + "</name>\n\t\t\t"
                + "<address>" + this.address + "</address>\n"
                + "\t</BuddyInfo>";

    }

}
