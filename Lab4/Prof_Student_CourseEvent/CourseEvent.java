import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject {
    private Date midtermDate;
    //private Prof prof;

    public CourseEvent(Date md, Prof prof) {
        super(prof);
        this.midtermDate = md;
     //   this.prof = prof;
    }

    public Date getMidtermDate() {
        return midtermDate;
    }

   public Prof getProf() {
        return (Prof) this.getSource();
    }
}