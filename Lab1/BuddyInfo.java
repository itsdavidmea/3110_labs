public class BuddyInfo {
    //What is the name of the default folders and files that appear in the Java project folder?
    //the folders are .idea and src once we open .idea

    //2. Name three default Java libraries included in a Java project by IntelliJ.
    // java.base, java.compiler, java.desktop

    //3. Copy-paste or screenshot of the code that appears in the BuddyInfo.java pane (Hello
    //World implementation)

    //4. The path where the file BuddyInfo.class lives
    // C:\Users\meada\OneDrive\Documents\3rd Year Course\SYSC 3110\Labs\Lab1

    //5. The JAR file containing your completed BuddyInfo class which has a main method that
    //instantiates a buddyInfo object and displays “Hello” followed by the name of the
    //buddyInfo object. This JAR file should contain BOTH the source file and the executable.

    public BuddyInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

}
