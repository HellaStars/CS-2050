
public class compMainTest {

	public static void main(String[] args) {
		Computer comp = new Computer ();
		mac mac = new mac();
		windows windows = new windows();
		
		mac.setMacBool(true);
		windows.setWindowsVer(11);
		comp.setCPU(" Ryzen 5 5600x");
		comp.setGPU("Nvidia RTX 3060");
		comp.setPSU("1500");
		comp.setRam(16, 1000);
		comp.setStorage(125, "SSD");
		comp.setMotherBoard("Asus");

		System.out.println(comp.getSpecs());
		System.out.println(mac.getSpecs());
		System.out.println(windows.getSpecs());
	}

}
