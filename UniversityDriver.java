import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.FileOutputStream;

public class UniversityDriver {
	
	static University thor;
	static Scanner in = new Scanner(System.in);
	static boolean running = true;
	

	public static void main(String[] args) {
		
		try {
	         FileInputStream fileIn = new FileInputStream("UniversityPersons.per");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         thor = (University) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	    	  thor = new University("HERO UNIVERSITY","ex tenebris ad lucem alis novis volabimus");
	      } catch (ClassNotFoundException c) {
	         System.out.println("University class not found");
	         c.printStackTrace();
	         return;
	      }
		
		System.out.println("Welcome to " + thor.universityName + ".");
		System.out.println(thor.motto);
		System.out.println("What would you like to do?\n");
		System.out.println("Enter \"hire\" to hire a new faculty member.");
		System.out.println("Enter \"admit\" to admit a new student.");
		System.out.println("Enter \"find student\" to list information about a student.");
		System.out.println("Enter \"find faculty\" to list information about a faculty member.");
		System.out.println("Enter \"list students\" to list the names of all students.");
		System.out.println("Enter \"list faculty\" to list the names of all faculty members.");
		System.out.println("Enter \"quit\" to end this program and save data.\n\n");
		
		
		while(running == true) {
			String str = in.nextLine();
			String done = "";
			String fN = "";
			String lN = "";
			int mB, dB, yB;
			String[] courses = thor.courses;
			String[] hiredCourses = new String[30];
			String[] majors = thor.majors;
			String[] chosenMajor = new String[1];
			String major;
			Person[] getSList;
			Person[] getFList;
			Student getS, admittedStudent;
			Faculty getF, hiredFaculty;
			
			if(str.equals("hire")) {
				System.out.println("What is the person's first name?");
				fN = in.nextLine();
				System.out.println("What is the person's last name?");
				lN = in.nextLine();
				System.out.println("What is the person's month of birth?");
				mB = Integer.parseInt(in.nextLine());
				System.out.println("What is the person's day of birth?");
				dB = Integer.parseInt(in.nextLine());
				System.out.println("What is the person's year of birth?");
				yB = Integer.parseInt(in.nextLine());
				System.out.println("Assign a course to this Faculty\nEnter \"done\" if there are no other courses.\n");
				System.out.println("The courses offered are: \n");
				for(int i = 0; i < courses.length; i++) {
					System.out.println(courses[i]);
				}
				int j = 0;
				done = in.nextLine();
				while(true) {
					if(done.equals("done")) {
						break;
					}
					else	
					{
						
							if(thor.check(courses, done)) {
								hiredCourses[j] = done;
								j++;
							} 
							else{
								System.out.println("That is not an offered course.");
							}	
					}
					System.out.println("Assign a course to this Faculty\nEnter \"done\" if there are no other courses.");
					done = in.nextLine();
				}
				hiredFaculty = new Faculty(fN, lN, mB, dB, yB, hiredCourses);
				thor.hire(hiredFaculty);
			} else if(str.equals("admit")) {
				System.out.println("What is the person's major?\n");
				System.out.println("The majors offered are: \n");
				for(int i = 0; i < majors.length; i++) {
					System.out.println(majors[i]);
				}
				int j = 0;
				while(true) {
					major = in.nextLine();			
						
							if(thor.check(majors, major)) {
								chosenMajor[j] = major;
								break;
							} 
							else{
								System.out.println("That is not an offered major.");
							}	
					
					System.out.println("What is the person's major?\n");
				}
				
				System.out.println("What is the person's first name?");
				fN = in.nextLine();
				System.out.println("What is the person's last name?");
				lN = in.nextLine();
				System.out.println("What is the person's month of birth?\nEnter an integer representing the month of birth");
				mB = Integer.parseInt(in.nextLine());
				System.out.println("What is the person's day of birth?\nEnter an integer representing the day of birth");
				dB = Integer.parseInt(in.nextLine());
				System.out.println("What is the person's year of birth?\nEnter an integer representing the year of birth (4 digits)");
				yB = Integer.parseInt(in.nextLine());
				
				admittedStudent = new Student(fN, lN, mB, dB, yB, major);
				thor.admit(admittedStudent);
			} else if(str.equals("find student")) {
				System.out.println("What is the student's first name?");
				fN = in.nextLine();
				System.out.println("What is the student's last name?");
				lN = in.nextLine();
				getS = thor.findStudent(fN, lN);
				
				
					if(getS == null){
						System.out.println("Student not found.");
					}
					else {
						if(fN.equals(getS.firstName) && lN.equals(getS.lastName)) {
							System.out.println("Student: " + getS.firstName + " " +  getS.lastName);
							System.out.println("DOB: " + getS.monthBirth + "/" + getS.dayBirth + "/" + getS.yearBirth);
							System.out.println("Major: " + ((Student) getS).major);
						} 
					}
			} else if(str.equals("find faculty")) {
				System.out.println("What is the faculty's first name?");
				fN = in.nextLine();
				System.out.println("What is the faculty's last name?");
				lN = in.nextLine();
				getF = thor.findFaculty(fN, lN);
				
				if(getF == null){
					System.out.println("Faculty not found.");
				}
				else {
					if(fN.equals(getF.firstName) && lN.equals(getF.lastName)) {
						System.out.println("Student: " + getF.firstName + " " +  getF.lastName);
						System.out.println("DOB: " + getF.monthBirth + "/" + getF.dayBirth + "/" + getF.yearBirth);
						System.out.println("Courses: ");
						for(int i = 0; i < getF.courses.length; i++) {
							if(getF.courses[i] != null) {
								System.out.println(getF.courses[i]);
							}
						}
					} 
				}
			} else if(str.equals("list students")) {
				getSList = thor.getStudents();
				for(int i = 0; i < getSList.length; i++) {
					if(getSList[i] != null) {
						System.out.println(getSList[i].firstName + " " + getSList[i].lastName);
					}
				}
			} else if(str.equals("list faculty")) {
				getFList = thor.getFaculty();
				for(int i = 0; i < getFList.length; i++) {
					if(getFList[i] != null) {
						System.out.println(getFList[i].firstName + " " + getFList[i].lastName);
					}
				}
			} else if(str.equals("quit")) {
				try {
			         FileOutputStream fileOut =
			         new FileOutputStream("UniversityPersons.per");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(thor);
			         out.close();
			         fileOut.close();
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
				running = false;
			} else {
				System.out.println("input error");
			}
				
			
		}
		

	}

}
