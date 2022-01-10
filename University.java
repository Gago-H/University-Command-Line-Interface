//import java.util.ArrayList;

public class University implements School, java.io.Serializable{
	String universityName;
	String motto;
	String[] courses;
	String[] majors;
	Person[] people;
		University(String uniName, String uniMotto){
			universityName = uniName;
			motto = uniMotto;
			courses = new String[] {"Computers","Advanced Physics","Quantum Entanglement","Parallel Programming","Advanced Algorithms","FPGA Programming",
									"Hardware Design","Embedded Systems","Signal Processing","Artificial Intelligence","Bayesian Logic","Probability"};
			majors = new String[] {"Hardware Architecture", "Information Analytics","Quantum Computing","Undecided"};
			people = new Person[50];
			people[0] = new Student("Billy","Baston",7,12,1990,"Information Analytics");
			people[1] = new Student("Carol","Danvers",4,9,1992,"Quantum Computing");
			people[2] = new Student("Clark","Kent",5,5,1994,"Hardware Architecture");
			people[3] = new Student("Kara","Zorel",4,13,1989,"Hardward Architecture");
			people[4] = new Student("Peter","Parker",6,25,1997,"Quantum Computing");
			people[5] = new Student("Tony","Stark",2,2,2004,"Hardware Architecture");
			people[6] = new Student("Stephen","Strange",12,15,1976,"Quantum Computing");
			people[7] = new Student("Bruce","Banner",9,9,2000,"Undecided");
			
			people[8] = new Faculty("Bruce","Wayne",9,27,1995,new String[] {"Bayesian Logic","Artificial Intelligence","Hardware Design"});
			people[9] = new Faculty("Diana","Prince",11,5,2006, new String[] {"Hardware Design","FPGA Programming","Embedded Systems"});
			people[10] = new Faculty("Barbara","Gordon",5,23,1980,new String[] {"Probability","Signal Processing","Advance Algorithms"});
			people[11] = new Faculty("Charles","Xavier",11,5,1966,new String[] {"Signal Processing","Embedded Systems","Parallel Programming"});
		}
	
		public boolean check(String[] cArr, String in) {
			for(int i = 0; i < cArr.length; i++) {
				if(in.equals(cArr[i])) {
					return true;
				}
			}
			return false;
		}
		//returns the Student specified by fn(firstName) and ln (lastName)		
		public Student findStudent(String fn, String ln) {
			//System.out.println(fn + ln);
			for(int i = 0; i < people.length; i++) {
				//.out.println(people[i].firstName + people[i].lastName);
				if(people[i] != null) {
					//System.out.println(people[i].firstName + people[i].lastName);
					if(people[i].firstName.equals(fn) && people[i].lastName.equals(ln) && people[i] instanceof Student) {
						return (Student) people[i];
					}
				}
			}
			return null;
		}
		
		//returns the Faculty specified by fn(firstName) and ln (lastName)
		public Faculty findFaculty(String fn, String ln) {
			for(int i = 0; i < people.length; i++) {
				if(people[i] != null) {
					if(people[i].firstName.equals(fn) && people[i].lastName.equals(ln) && people[i] instanceof Faculty) {
						return (Faculty) people[i];
					}
				}
			}
			return null;
		}
		
		//adds a Faculty object to the Person []
		public Faculty hire(Person p) {
			for(int i = 0; i < people.length; i++) {
				if(people[i] == null) {
					people[i] = p;
					break;
				}
			}
			return (Faculty) p;
		}
		
		//adds a Student object to the Person []
		public Student admit(Person p) {
			for(int i = 0; i < people.length; i++) {
				if(people[i] == null) {
					people[i] = p;
					break;
				}
			}
			return (Student) p;
		}
		
		//returns the people variable for the university
		public Person [] getAllPersons() {
			return people;
		}
		
		//returns the majors variable for the university
		public String [] getAllMajors() {
			return majors;
		}
		
		//returns the courses variable for the university
		public String [] getAllCourses() {
			return courses;
		}
		
		//returns a Person [] of all Students only
		public Person [] getStudents() {
			Person[] peep = new Person[50];
			int index = 0;
			for(int i = 0; i < people.length; i++) {
					if(people[i] instanceof Student) {
						peep[index] = (Student) people[i];
						index++;
				}
			}
			return peep;
		}
		
		//returns a Person [] of all Faculty only
		public Person [] getFaculty() {
			Person[] peep = new Person[50];
			int index = 0;
			for(int i = 0; i < people.length; i++) {
					if(people[i] instanceof Faculty) {
						peep[index] = (Faculty) people[i];
						index++;
				}
			}
			return peep;
			
		}
		
}
