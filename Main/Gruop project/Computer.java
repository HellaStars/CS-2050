
public class Computer { // by Asta Walor-Scott, Aysha Rida Puthan Veettil, Sokina Begum
	
	
	protected String cCPU; //computer CPU (Central Processing Unit)
	protected String cGPU; //computer GPU (Graphicical processing Unit)
	protected String cPSU; // computer PSU (Power Supply Unit)
	protected String cRAM; // comouter RAM (Random access Memory)
	protected String cStorage; // computer storage
	protected String cMB; // computer motherboard
	
	Computer(){}

	public String setCPU(String CPU) {
		cCPU = CPU;
		return(cCPU);
	}
	public String setGPU(String GPU) {
		cGPU = GPU;
		return(cGPU);
	}
	public String setMotherBoard(String MB) {
		cMB = MB;
		return(cMB);
	}
	public String setPSU(String powerSupply) {
		cPSU = powerSupply + "V";
		return(cPSU);
	}
	public String setRam(int Mem, int hrtz) {
		cRAM = Mem + "GB at " + hrtz + " megahertz";
		return(cRAM);
	}
	public String setStorage(int size, String type) {
		cStorage = size + "GB" + " " + type;
		return(cStorage);
	}
	private String computerSpecs() {
		String fSpecs = "Your CPU is: " + cCPU + "\r\n" 
				+ "Your GPU is: " + cGPU + "\r\n"
				+ "Your RAM is: " + cRAM + "\r\n"
				+ "Your MotherBoard is: " + cMB + "\r\n"
				+ "Your Powersupply is: " + cPSU + "\r\n"
				+ "Your Storage is: " + cStorage + "\r\n";
		return(fSpecs);
	}
	public String getSpecs() {
		return(computerSpecs());
	}
}

