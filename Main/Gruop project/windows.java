public class windows extends Computer { // by Asta Walor-Scott, Aysha Rida Puthan Veettil, Sokina Begum
	windows() {}
	String OStype;

	public String setWindowsVer(int OS) {
		switch(OS) {
		case 7:
			OStype = "VII";
			return (OStype);
		case 8:
			OStype = "VIII (but why?)";
			return (OStype);
		case 10:
			OStype = "X";
			return (OStype);
		case 11:
			OStype = "XI";
			return (OStype);
		default:
			OStype = "null"; // really this is just for old OS's
			return (OStype);
		}
	}
	private String computerSpecs() {
		String fSpecs = "Your CPU is: " + cCPU + "\r\n" 
				+ "Your GPU is: " + cGPU + "\r\n"
				+ "Your RAM is: " + cRAM + "\r\n"
				+ "Your MotherBoard is: " + cMB + "\r\n"
				+ "Your Powersupply is: " + cPSU + "\r\n"
				+ "Your Storage is: " + cStorage + "\r\n" + 
				"Windows Version: " + OStype;
		return(fSpecs);
	}
	public String getSpecs() {
		return(computerSpecs());
	}
}
