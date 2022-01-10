
public class Person implements java.io.Serializable{
	String firstName;
	String lastName;
	int monthBirth;
	int dayBirth;
	int yearBirth;
	Person(String fN, String lN, int mB, int dB, int yB){
		firstName = fN;
		lastName = lN;
		monthBirth = mB;
		dayBirth = dB;
		yearBirth = yB;
	}
}
