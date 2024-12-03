public class mac extends Computer { // By Asta Walot-Scott, Aysha Rida Puthan Veettil, Sokina Begum
	mac(){}
	protected Boolean hasMac = false;

	public void setMacBool(Boolean Mac) {
		hasMac = Mac;
	}
	private String computerSpecs() {
			String fSpecs = "Your CPU is: " + cCPU + "\r\n" 
					+ "Your GPU is: " + cGPU + "\r\n"
					+ "Your RAM is: " + cRAM + "\r\n"
					+ "Your MotherBoard is: " + cMB + "\r\n"
					+ "Your Powersupply is: " + cPSU + "\r\n"
					+ "Your Storage is: " + cStorage + "\r\n" + 
					"do you have access to iCloud? " + hasMac;
			return(fSpecs);
	}
	public String getSpecs() {
		return(computerSpecs());
	}
}
