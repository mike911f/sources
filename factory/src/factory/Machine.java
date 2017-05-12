package factory;

public class Machine {
	private int powerPerPiece; //prikon na 1 soucastku
	private int capacity;	   //pocet soucastek za hodinu
	private int freeCapacity;
	private int numberOfMachines; //pocet stroju 0 pro neomezene
	private boolean breakDown; //muze se porouchat ?
	private boolean screw;     //sroubky ano ne
	private char type;
	private int actWork;
	
	public int getPowerPerPiece(){					//Gettery
		return this.powerPerPiece;
	}
	public int getCapacity(){
		return this.capacity;
	}
	public int getActWork(){
		return this.actWork;
	}
	public int getFreeCapacity(){				//Vyresit vraceni volne kapacity;
		this.freeCapacity = capacity - getActWork();
		return this.freeCapacity;
	}

	public boolean getBreakDown(){
		return this.breakDown;
	}
	
	public boolean getScrew(){
		return this.screw;
	}
	public char getType(){
		return this.type;
	}
	
	
	public void setPowerPerPiece(int powerPerPiece){   //Settery
		this.powerPerPiece = powerPerPiece;
	}
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	public void setActCapacity(int freeCapacity){
		this.freeCapacity = freeCapacity;
	}
	public void setActWork(int actWork){
		this.actWork = actWork;
	}
	
	public void setBreakDown(boolean breakDown){
		this.breakDown = breakDown;
	}
	
	public void setScrew(boolean screw){
		this.screw = screw;
	}
	
	public int getNumberOfMachines(){
		return this.numberOfMachines;
	}
	public void setNumberOfMachines(int numberOfMachines){
		this.numberOfMachines = numberOfMachines;
	}
	public void setType(char type){
		this.type = type;
	}
	
	
}
