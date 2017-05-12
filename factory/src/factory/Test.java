package factory;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Test {

	public static int positiveIntegers(Scanner sc)
	{
		int choice = 0;
		try{
			choice = sc.nextInt();
		}
		catch(Exception e){
			System.out.println("Exception type: "+e.toString());
			System.out.println("Type whole number");
			sc.nextLine();
			choice = positiveIntegers(sc);
		}
		return choice;
	}
	
	public static void main(String[] args) throws IOException {	
		int choice = 0;
		boolean start=true;
		int order;
		char machineType;
		int machineID;
		int partType;
		int amountOfParts;
		int actFreeCapacityA = 0;
		int actFreeCapacityB = 0;
		int actFreeCapacityC = 0;
		int maxID = 10000;
		
		
		int factoryCapacity = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(start){
			System.out.println("=========================");
			System.out.println("FACTORY WITH CNC MACHINES");
			System.out.println("=========================");
			System.out.println("1...ADD new CNC machine  ");
			System.out.println("2...Set Work             ");
			System.out.println("3...Cancel Work          ");
			System.out.println("4...Remove Machine       ");
			System.out.println("5...Breakdown            ");
			System.out.println("6...Print number of machines and free capacity");
			System.out.println("7...Print energy intensity");
			System.out.println("8...Print actualworking proces");
			System.out.println("9...Insert database to file");
			System.out.println("10...EXIT                 ");
			System.out.println("=========================");
			
			choice = positiveIntegers(sc);
			
			switch(choice){
			case 0: break;
			case 1: 
				sc.nextLine();
				System.out.println("Select TYPE and put ID");
				System.out.println("\ta...type A");
				System.out.println("\tb...type B");
				System.out.println("\tc...type C");
				
				try{
					machineType = sc.next().charAt(0);
				}
				catch(Exception e){
					System.out.println("Exception: "+e.toString());
					System.out.println("Insert char a - c: ");
					sc.nextLine();
					machineType = sc.next().charAt(0);
				}
				
				machineID = sc.nextInt();
				sc.nextLine();
				
				switch(machineType){
				case 'a':
					if(machineID < maxID){
					Manage.addNewMachine('A', machineID);
					}
					else
					{
						System.out.println("No factory capacity.");
					}
					break;
				case 'b':
					if(machineID < maxID){
					Manage.addNewMachine('B', machineID);
					}
					else
					{
						System.out.println("No factory capacity.");
					}
					break;
				case 'c':
					if(machineID < maxID){
						Manage.addNewMachine('C', machineID);
					}
					else{
						System.out.println("No factory capacity.");
					}
					break;
			    default: 
			    	System.out.println("Machine "+machineType+" not recognized");
			    	break;
				}
				break;
			case 2:
				System.out.println("Chose parts and set amount");
				System.out.println("\t1...normal part");
				System.out.println("\t2...screw");
				partType = positiveIntegers(sc);
				amountOfParts = positiveIntegers(sc);
				
				actFreeCapacityA = Manage.getActFreeCapacity('A');
				actFreeCapacityB = Manage.getActFreeCapacity('B');
				
				if(Manage.getActFreeCapacity('C')!=0){
					actFreeCapacityC = Manage.getActFreeCapacity('C');
				}
				factoryCapacity = actFreeCapacityA + actFreeCapacityB + actFreeCapacityC;
				if(factoryCapacity==0){
					System.out.println("Factory capacity is full. No more orders");
					break;
				}
				
				if(amountOfParts > factoryCapacity){
					System.out.println("Capacity exceeded by "+(amountOfParts - factoryCapacity));
					System.out.println("1...Lower the order at "+factoryCapacity+"parts");
					System.out.println("2...Cacnel the order");
					order = positiveIntegers(sc);
					
					if(order == 1){
						amountOfParts = factoryCapacity;
					}
					else{
						break;
					}
				}
				
				switch(partType){
				case 1:
					Manage.setWork(partType, amountOfParts);
					break;
				case 2:
					Manage.setWork(partType, amountOfParts);
					break;
				}
				
			case 3:
				System.out.println("Choce part type to cancel and number of parts");
				System.out.println("\t1...PART");
				System.out.println("\t2...SCREW");
				
				partType = positiveIntegers(sc);
				amountOfParts = positiveIntegers(sc);
				
				
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("Number of machines type A: " + Manage.getNumberMachine('A')+ " Actual free capacity: "+Manage.getWholeFreeCapacity('A'));
				System.out.println("Number of machines type B: " + Manage.getNumberMachine('B')+ " Actual free capacity: "+Manage.getWholeFreeCapacity('B'));
				System.out.println("Number of machines type C: " + Manage.getNumberMachine('C')+ " Actual free capacity: "+Manage.getWholeFreeCapacity('C'));
				break;
			case 7:
				System.out.println("Factory energy intensity: " + Manage.getEnergyIntensity());
				break;
			case 8:
				Manage.getActualWorkingParts();
				break;
			case 9:
				Manage.saveToFile();
				break;
			case 10:
				start = false;
				break;
			default:
				System.out.println("Insert your choice (1-9)");
				break;
			}
		}
	}

}
