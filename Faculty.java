
public class Faculty extends Person{
	String[] courses;
	
	Faculty(String fN, String lN, int mB, int dB, int yB, String[] cors){
		super(fN, lN, mB, dB, yB);
		courses = cors;
	}
	
}
