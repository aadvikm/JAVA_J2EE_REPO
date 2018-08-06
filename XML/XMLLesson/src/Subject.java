import java.util.List;

public class Subject {

	private List<String> subjectName;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(List<String> subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + "]";
	}

	
}
