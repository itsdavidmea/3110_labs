public class TextElement extends Element{


    private String textElement;

    public TextElement (String aText, String parentTag) {
        super(parentTag);
        textElement = aText;
    }

    public void changeTextElement(String aText) {
        this.textElement = aText;
    }



    @Override
    public String toString() {
        String parentTag = super.getTag();
        return  "<"+ parentTag + ">"   +  textElement +  "</"+ parentTag + ">" ;
    }
}
