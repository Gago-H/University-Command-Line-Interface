
public class Student extends Person{
	String major;
	
	Student(String fN, String lN, int mB, int dB, int yB, String mjr){
		super(fN, lN, mB, dB, yB);
		major = mjr;
	}
}
