public class BuddyInfo {
    private String name;



    private String age;

    public BuddyInfo(String name) {
        this.name = name;


    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
