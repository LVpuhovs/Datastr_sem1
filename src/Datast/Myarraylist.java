package Datast;

import java.util.ArrayList;

public class Myarraylist {
	
	private int[] list;
	private final int LIST_DEFAULT_SIZE = 10;
	private int size = LIST_DEFAULT_SIZE;
	private int counter = 0;
	
	//konstruktori
	public Myarraylist() {
		list = new int[size]; 
	}
	
	public Myarraylist(int inputSize) {
		if (inputSize > 0) {
			size = inputSize;
		}
		list = new int[size];
	}
	
	//Isempty
	public boolean isEmpty() {
		//1. long if - else
		/*
		if (counter == 0) 
			return true;
		else
			return false;
		*/
		//2. short if - else
		/*
		return (counter == 0)? true : false;
		*/
		//3.
		return (counter == 0);
		
	}
	
	//IsFull
	public boolean isFull() {
		return (counter == size);
	}
	//HowManyEelements
	public int howManyElements() {
		return counter;
	}
	
	
	//1. Funkcijas dekleracija
	private void resize() {
		
	//2. ja bus ienakosais parametrs,  tad noteikti tas japarbauda
	//3. aptrekinat .at newSize
		int newSize = (counter <= 100)? size * 2 : (int) (size *1.5);
		
		/*
		if (counter <= 100) 
			int newSize = size * 2;
		else
			int newSize = (int) (size *1.5;
		
		*/
	//4. Izveidot listNew ar newSize izmeru
		
		int[] listnew = new int[newSize];
		
	//5. veikt kopesanu no veca masiva uz jauno
		for (int i = 0; i < size; i++) {	
			listnew[i] = list[i];
		}
	//6. nomainam list newreferenci uz listNew
		list = listnew;
	//7. izsaukt garbage collector
		System.gc();
	//8. size nomainam uz newSize
		size = newSize;
	}
	
	
	//funkcijas dekleracija
	public void addElement(int element) {	
	//parbauda isfull tad resize izsaukms
		if (isFull()) resize();
	//ieliekam jaunu elementu
		//list[counter++] = element;
		list[counter] = element;
	//palielinam counter par 1
		counter++; 
	}
	
	public void addElementIndex(int element, int index) throws Exception {
		//parbaude par index, ja nav pareizs izmet iznemumu
		if (index < 0 || index > counter) throw  new Exception("Wrong index");
		//parbauda isfull
		if (isFull()) resize();
		//vekt parkopesanu , lai elemeti sakot no noradita pabiditos pa labi
		if ( index == counter) addElement(element);
		else {
			for (int i = counter; i > index; i--) {	
				list[i] = list[i-1];
			}
		}
		//ievieto index  suna pasu elementu
		list[index] = element;
		//palielinam counter pa 1
		counter++;
	}
	
	public void deleteIndexElement(int index) throws Exception {
		//parbaude par index, ja nav pareizs izmet iznemumu
		if (index < 0 || index >= counter) throw  new Exception("Wrong index");
		//parbauda isempty
		if (isEmpty()) throw  new Exception("List Empty");
		//vekt parkopesanu , lai elemeti sakot no noradita pabiditos pa kreisi
		
			for (int i = index; i < counter - 1; i++) {	
				list[i] = list[i+1];
			}
		//samazinam counter pa 1
		counter--;
	}
	public int getElement(int index) throws Exception {
		//parbaude par index, ja nav pareizs izmet iznemumu
		if (index < 0 || index > counter) throw  new Exception("Wrong index");
		if (isEmpty()) throw  new Exception("List Empty");
		return list[index];
	}
	/*
	public int findElement(int element) throws Exception {
		if (isEmpty()) throw  new Exception("List Empty");
		
		for(int i = 0; i < counter; i++) {
			if(list[i] == counter) 
				return i;
		}
		throw  new Exception("Element with this index not found");
	}
	*/
	public ArrayList search(int element) throws Exception {
		if (isEmpty()) throw  new Exception("List Empty");
		
		ArrayList indexes = new ArrayList();
		
		for (int i = 0; i < counter; i++) {
			if(list[i] == element) indexes.add(i);
		}
		return indexes;
	}
	
	public int[] nextElement(int element) throws Exception {
		ArrayList indexes = search(element);
		
		int kaiminuSize = indexes.size();
		
		if((int)indexes.get(indexes.size()-1) == counter -1) kaiminuSize--;
		
		int[] kaimini = new int[kaiminuSize];
		for(int i = 0;i < kaiminuSize; i++) {
			int indexfromsearchTemp = (int) indexes.get(i);
			int indexkaiminiTemp = indexfromsearchTemp+1;
			kaimini[i] = list[indexfromsearchTemp];
		}
		return kaimini;
	}
	
}
