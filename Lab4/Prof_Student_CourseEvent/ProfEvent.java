import java.util.Date;
import java.util.EventObject;

public class ProfEvent extends EventObject {

    private Date midetermDate;
    private Date assignmentPostponed;

    /**
     * Constructs a prototypical Event.
     *
     * @param prof the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ProfEvent(Date midtermDate, Prof prof) {
        super(prof);
        this.midetermDate = midtermDate;
    }

    public Date getMidtermDate() {
        return midetermDate;
    }

    public Prof getProf() {
        return (Prof) this.getSource();
    }
}
