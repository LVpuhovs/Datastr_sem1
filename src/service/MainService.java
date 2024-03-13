package service;



import Datast.Myarraylist;
import model.Student;

public class MainService {

	private static Myarraylist<Student> allStudents = new Myarraylist<Student>();
	public static void main(String[] args) {
		
		Student st1 = new Student();
		Student st2 = new Student("Gatis", "Kandis","123415-12345");
		
		allStudents.addElement(st1);
		allStudents.addElement(st2);
		//System.out.println(st1);
		//System.out.println(st2);
		
		// TODO Auto-generated method stub
		/*
		Myarraylist mylist = new Myarraylist(3);
		
		mylist.addElement(100);
		mylist.addElement(200);
		mylist.addElement(-100);
		*/
		try {
			allStudents.print();
			//mylist.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
