import java.util.ArrayList;
import java.util.List;

public class Element {


    private String tag;

    private List<Element> elementContent;

    public Element(String tag) {
        this.tag = tag;
        elementContent = new ArrayList<Element>();


    }

    public void addElement(Element el) {
        elementContent.add(el);


    }

    public String getTag() {
        return this.tag;
    }



    public List<Element> getElementContent() {
        return elementContent;
    }

    public void removeElement(Element el) {
        elementContent.remove(el);
    }

    @Override
    public String toString() {
        if (elementContent.getFirst() instanceof TextElement) {
            return "<" + tag + ">" +  elementContent.getFirst().toString() + "<" + tag + "/>";
        } else {

        }
        return null;
    }
}
