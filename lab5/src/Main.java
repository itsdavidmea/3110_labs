public class Main {
    public static void main(String[] args) {

        XML root = new XML("Course");

        Element parent = new Element("parent");
        TextElement text1 = new TextElement("text1", "course");
        parent.addElement(text1);

        root.addElementToRoot(parent);
        root.print();


    }
}