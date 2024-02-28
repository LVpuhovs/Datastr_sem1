package service;

import Datast.Myarraylist;

public class MainService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myarraylist mylist = new Myarraylist(3);
		
		mylist.addElement(100);
		mylist.addElement(200);
		mylist.addElement(-100);
		try {
			mylist.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
