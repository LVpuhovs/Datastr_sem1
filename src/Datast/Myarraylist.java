package Datast;

import java.util.ArrayList;
import java.util.Arrays;

public class Myarraylist<Ttype> {
	
	private Ttype[] list;
	private final int LIST_DEFAULT_SIZE = 10;
	private int size = LIST_DEFAULT_SIZE;
	private int counter = 0;
	
	//konstruktori
	public Myarraylist() {
		list = (Ttype[]) new Object[size]; 
	}
	
	public Myarraylist(int inputSize) {
		if (inputSize > 0) {
			size = inputSize;
		}
		list = (Ttype[]) new Object[size];
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
		
		Ttype[] listnew = (Ttype[]) new Object[newSize];
		
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
	public void addElement(Ttype element) {	
	//parbauda isfull tad resize izsaukms
		if (isFull()) resize();
	//ieliekam jaunu elementu
		//list[counter++] = element;
		list[counter] = element;
	//palielinam counter par 1
		counter++; 
	}
	
	public void addElementIndex(Ttype element, int index) throws Exception {
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
	public Ttype getElement(int index) throws Exception {
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
	public ArrayList search(Ttype element) throws Exception {
		if (isEmpty()) throw  new Exception("List Empty");
		
		ArrayList indexes = new ArrayList();
		
		for (int i = 0; i < counter; i++) {
			if(list[i] == element) indexes.add(i);
		}
		return indexes;
	}
	
	public Ttype[] nextElement(Ttype element) throws Exception {
		ArrayList indexes = search(element);
		
		int kaiminuSize = indexes.size();
		
		if((int)indexes.get(indexes.size()-1) == counter -1) kaiminuSize--;
		
		Ttype[] kaimini = (Ttype[]) new Object[kaiminuSize];
		for(int i = 0;i < kaiminuSize; i++) {
			int indexfromsearchTemp = (int) indexes.get(i);
			int indexkaiminiTemp = indexfromsearchTemp+1;
			kaimini[i] = list[indexfromsearchTemp];
		}
		return kaimini;
	}
	
	public void print() throws Exception {
		if (isEmpty()) throw  new Exception("List Empty");
		
		for(int i = 0; i < size; i++) {
			System.out.println(list[i] + " ");
		}
	}
	
	public void makeEmpty() {
		counter = 0;
		size = LIST_DEFAULT_SIZE;
		list = (Ttype[]) new Object[size];
		System.gc();
	}
	
	Ttype[] arraySort(Ttype[] array) throws Exception{
		if (array == null) throw new Exception("Wrong input parametrs");
		Arrays.sort(array);
		return array;
	}
	private void swap(int index1, int index2) {
		Ttype temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}
}
