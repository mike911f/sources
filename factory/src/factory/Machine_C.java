package factory;

public final class Machine_C extends Machine {

	private int id;
	
	public Machine_C(int id){
		setType('C');
		setPowerPerPiece(2);
		setCapacity(150);
		setBreakDown(true);
		setNumberOfMachines(1);
		setScrew(false);
		
		this.id = id;
	}
}
