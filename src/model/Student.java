package model;

public class Student {
	//1.variables
		private long sID;
		private String name;
		private String surname;
		private String personCode;
		
		private static long counter = 10000; //ne get, ne set funkcijas
		//2.get and set

		public long getsID() {
			return sID;
		}

		public void setsID() {
			this.sID = counter;
			counter++;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			if(name != null && name.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+")) {
				this.name = name;
			}
			else
				this.name = "Undefined";
			
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			if(surname != null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+")) 
				this.surname = surname;
			else
				this.surname = "Undefined";			
		}
		public String getPersonCode() {
			return personCode;
		}

		public void setPersonCode(String personCode) {
			if(personCode != null && personCode.matches("[0-9]{6}-[0-9]{5}"))
				this.personCode = personCode;
			else
				this.personCode = "Undefined";
		}
		
		//3. constructors
		


		public Student()
		{
			setsID();
			setName("Baiba");
			setSurname("Jaukā");
			setPersonCode("123456-12345");
		}
		
		public Student(String name, String surname, String personCode) {
			setsID();
			setName(name);
			setSurname(surname);
			setPersonCode(personCode);
		}
		//4. toString
		public String toString() {
			return sID + ": " + name + " " + surname + "(" + personCode + ")";
		}
		
		
		//5. other functions
}
