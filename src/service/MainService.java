package service;



import java.util.Arrays;

import Datast.Myarraylist;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		
Myarraylist<Integer> myList = new Myarraylist<Integer>(3);
		
		myList.addElement(100);
		myList.addElement(200);
		myList.addElement(-100);
		try {
			myList.print();//100 200 -100
			myList.addElementIndex(1000, 1);
			myList.print();//100 1000 200 -100
			myList.deleteIndexElement(0);
			myList.print();//1000 200 -100
			myList.addElement(200);
			myList.addElement(200);
			myList.print();//1000 200 -100 200 200
			System.out.println(myList.search(200));//1 3 4
			//-100 200
			myList.print();//1000 200 -100 200 200
			myList.sort();
			myList.print();
			
			myList.makeEmpty();
			myList.addElement(100000);
			myList.print();//100000
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("-----------------------------");
		Myarraylist<Student> allStudents = new Myarraylist<Student>();
		
		Student s1 = new Student("Janis", "Berzins");
		Student s2 = new Student("Liga", "Jauka");
		Student s3 = new Student("Baiba", "Kalnina");
		
		allStudents.addElement(s1);//Janis
		allStudents.addElement(s2);//Janis Liga
		try
		{
			allStudents.addElementIndex(s3,1); //Baiba Janis Liga
			allStudents.print();//Baiba Janis Liga
			
			System.out.println(allStudents.search(s1));//1
			System.out.println(Arrays.toString(allStudents.nextElement(s1)));//Liga
			
			allStudents.print();//Baiba Janis Liga
			//allStudents.sort();
			allStudents.print();//Baiba Janis Liga
				
			
			allStudents.deleteIndexElement(1);
			allStudents.print();//Baiba Liga
			
			allStudents.makeEmpty();
			allStudents.addElement(s1);
			allStudents.print();//Janis
			
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		
			
	}
}
