public class Main {
    public static void main(String[] args) {

        XML root = new XML("Course");

        Element aclass = new Element("class");
        TextElement code = new TextElement("SYSC3110", "Code");
        TextElement prof = new TextElement("Wafa", "prof");

        TextElement student1 = new TextElement("Michael", "student");
        TextElement student2 = new TextElement("Alan", "student");

        aclass.addElement(student1);
        aclass.addElement(student2);



        root.addElementToRoot(code);
        root.addElementToRoot(prof);
        root.addElementToRoot(aclass);
        root.print();


    }
}