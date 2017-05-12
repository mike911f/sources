package factory;

public final class Machine_A extends Machine{

	private int id;
	
	public Machine_A(int id){
		setType('A');
		setPowerPerPiece(4);
		setCapacity(70);
		setBreakDown(false);
		setNumberOfMachines(0);
		setScrew(false);
	
		this.id = id;
	}
	
}
