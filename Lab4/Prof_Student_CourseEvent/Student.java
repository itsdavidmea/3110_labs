/** Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class Student implements ProfListener {
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	private void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}

		public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	public void handleMidtermDate(ProfEvent event) {
		Prof prof;
		 prof = event.getProf();
		System.out.println(prof.getName());
		this.study(event.getMidtermDate());
	}

	@Override
	public void handelPostopnedMidterm(ProfEvent event) {
		this.party(event.getMidtermDate());
		System.out.println(event.getProf().getName());

	}
}
