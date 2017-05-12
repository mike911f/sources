package factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Manage extends Machine{
	 static int maxID = 10000;
	 static Machine[] data = new Machine[maxID];
	
	public Manage(){
		
	}
	
	
	public static void addNewMachine(char type, int id){	//Metoda pridat novy stroj

		try{
			if(type == 'A'){
				data[id] = new Machine_A(id);
			}
			else if(type == 'B'){
				data[id] = new Machine_B(id);
			}
			else {
				data[id] = new Machine_C(id);
			}
		}
		catch(NullPointerException e){
			System.out.println("Exception: "+e.toString());
		}
	}
	
	public static int getActFreeCapacity(char type){
		int freeCapacity = 0;
		try{
		if(type == 'A'){
			for (int i = 0; i < data.length; i++) {
				
				if(data[i].getType() == 'A'){
					freeCapacity += data[i].getFreeCapacity();
				}
			}
		}
		else if(type == 'B'){
			for (int i = 0; i < data.length; i++) {
				if(data[i].getType() == 'B'){
					freeCapacity += data[i].getFreeCapacity();
				}
			}
		}
		else {
			for (int i = 0; i < data.length; i++) {
				if(data[i].getType() == 'C'){
					freeCapacity += data[i].getFreeCapacity();
				}
			}	
		}
		}
		catch(NullPointerException e){
			System.out.println("Exception: "+e.toString());
		}
		return freeCapacity;
	}

	public static int setWorkC(int capacity){
		int max = 150;
		int pom;
		for (int i = 0; i < data.length; i++) {
			if(data[i].getType() == 'C'){
				if(data[i].getActWork()==0){
					data[i].setActWork(max);
					capacity -=max;
				}
				else{
					pom = data[i].getActWork();
					data[i].setActWork(max-pom);
					capacity -= (max-pom);
				}
			}
		}
		return capacity;
	}
	public static int setWorkB(int capacity){
		int max = 50;
		int pom;
		for (int i = 0; i < data.length; i++) {
			if(data[i].getType() == 'B'){
				if(data[i].getActWork()==0){
					data[i].setActWork(max);
					capacity -=max;
				}
				else{
					pom = data[i].getActWork();
					data[i].setActWork(max-pom);
					capacity -= (max-pom);
				}
			}
		}
		return capacity;
	}
	public static int setWorkA(int capacity){
		int max = 70;
		int pom;
		for (int i = 0; i < data.length; i++) {
			if(data[i].getType() == 'A'){
				if(data[i].getActWork()==0){
					data[i].setActWork(max);
					capacity -=max;
				}
				else{
					pom = data[i].getActWork();
					data[i].setActWork(max-pom);
					capacity -= (max-pom);
				}
			}
		}
		return capacity;
		
	}
	public static void setWork(int partType, int capacity){   //typ + kapacita souc na hodinu
		int pom, pom2, pom3; int count = 0;
		if(partType == 1){
			if((pom = setWorkC(capacity)) > 0){
				if((pom2 = setWorkB(pom)) > 0){
					if((pom3 = setWorkA(pom2))>0){
						System.out.println("Insuficient machine capacity. Please add machine.");
					}
				}
			}
		}
		else if(partType == 2){
			if((pom = setWorkB(capacity))>0){
				if((pom2 = setWorkC(pom))>0){
					if((pom3 = setWorkA(pom2))>0){
						System.out.println("Insuficient machine capacity. Please add machine.");
					}
				}
			}
			else{
				for (int i = 0; i < data.length; i++) {
					if(data[i].getType()=='B' && count < capacity){
						data[i].setActWork(0);
						count += 50;
					}
				}
				if((pom = setWorkB(capacity))>0){
					if((pom2 = setWorkC(pom))>0){
						if((pom3 = setWorkA(pom2))>0){
							System.out.println("Insuficient machine capacity. Please add machine.");
						}
					}
				}
			}
		}
		
	}
	
	public static void getActualWorkingParts(){
		int pomScrew = 0;
		int pomPart = 0;
		for (int i = 0; i < data.length; i++) {
			if(data[i].getActWork() != 0 && data[i].getScrew()){
				pomScrew += data[i].getActWork();
			}
			if(data[i].getActWork() != 0 && !data[i].getScrew()){
				pomPart += data[i].getActWork();
			}
		}
		if(pomPart != 0){
		System.out.println("Actual working parts: PART in amount of: "+ pomPart);
		}
		if(pomScrew != 0){
		System.out.println("Actual working parts: SCREW in amount of: "+ pomScrew);
		}
	}
	
	public static int getEnergyIntensity(){
		int pom = 0;
		for (int i = 0; i < data.length; i++) {
			pom += data[i].getActWork()*data[i].getPowerPerPiece();
		}
		return pom;
	}
	
	public static int getWholeFreeCapacity(char type){
		int pom = 0;
		try{
		for (int i = 0; i < data.length; i++) {
			if(type=='A'&&data[i].getType()=='A'){
				pom += data[i].getFreeCapacity();
			}
			else if (type =='B'&&data[i].getType()=='B'){
				pom += data[i].getFreeCapacity();
			}
			else if(type == 'C' && data[i].getType() == 'C'){
				pom += data[i].getFreeCapacity();
			}
		}
		}
		catch(Exception e){
			System.out.println("Exception: " + e.toString());
		}
		return pom;
	}
	
	public static int getNumberMachine(char type){ //pocet stroju typu
		int pom = 0;
		try{
		for (int i = 0; i < data.length; i++) {
			
			if(type=='A'&&data[i].getType()=='A'){
				pom++;
			}
			else if (type =='B'&&data[i].getType()=='B'){
				pom++;
			}
			else if(type == 'C' && data[i].getType() == 'C'){
				pom++;
			}
			
		}
		}
		catch(Exception e){
			System.out.println("Exception: " + e.toString());
		}
		return pom;
	}
	
	public void cancelWork(boolean screw, int capacity){
		
	}
	
	public void removeMachine(int id){
		
	}
	
	public void repairMachine(int id){
		
	}
	
	public void printNumberOfMachineInEachCategory(Machine[] data){
		
	}
	
	public void printWholeEnergyIntensity(Machine[] data){
		
	}
	
	public void printActualWorking(Machine[] data){
		int prace; int typ;		
		for (int i = 0; i < data.length; i++) {
			
		}
	}
	
	
	
	public static void saveToFile() throws IOException{
		FileOutputStream fos = new FileOutputStream("output.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (int j = 0; j < data.length; j++) {
			oos.writeObject(data);
		}
		fos.close();
	}
	

	
}
