/** Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prof {
	private String name;
	private Date midtermDate;
	private List<ProfListener> profListeners;
	//private TeachingAssistant ta;

	public Prof(String aName) {
		this.name = aName;
		this.profListeners = new ArrayList<>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date, Prof prof) {
		this.midtermDate = date;
		ProfEvent event = new ProfEvent(date, prof);
		for(ProfListener s: this.profListeners){
			s.handleMidtermDate(event);
		}
	}
	
	public void postponeMidterm(Date date, Prof prof){
		this.midtermDate = date;
		for(ProfListener s: this.profListeners){
			s.handelPostopnedMidterm(new ProfEvent(date,prof));
		}
	}
	
	public void addProfListener(ProfListener pl){
		this.profListeners.add(pl);
	}

	public void removeProfListener(ProfListener pl){
		this.profListeners.remove(pl);
	}
	
	public static void main(String[] args) {

		Prof p = new Prof("Safaa");
		ProfListener s = new Student("Justin");
		ProfListener s2 = new Student("Emma");
		ProfListener ta = new TeachingAssistant("Mutakabbir");
	
	
		p.addProfListener(s);
		p.addProfListener(s2);
		p.addProfListener(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm,p);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000),p);
	}

}
