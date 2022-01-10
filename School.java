
public interface School {
	//returns the Student specified by fn(firstName) and ln (lastName)
	Student findStudent(String fn, String ln);
	//returns the Student specified by fn(firstName) and ln (lastName)
	Faculty findFaculty(String fn, String ln);
	//adds a Faculty object to the Person []
	Faculty hire(Person p);
	//adds a Student object to the Person []
	Student admit(Person p);
	//returns the people variable for the university
	Person [] getAllPersons();
	//returns the majors variable for the university
	String [] getAllMajors();
	//returns the courses variable for the university
	String [] getAllCourses();
	//returns a Person [] of all Students only
	Person [] getStudents(); 
	//returns a Person [] of all Faculty only
	Person [] getFaculty(); 
}
