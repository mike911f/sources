package factory;

public final class Machine_B extends Machine{

	private int id; 
	
	public Machine_B(int id){
		setType('B');
		setPowerPerPiece(3);
		setCapacity(50);
		setBreakDown(true);
		setNumberOfMachines(0);
		setScrew(true);
		
		this.id = id;
	}
}
