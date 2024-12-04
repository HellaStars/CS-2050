import java.util.ArrayList;

public class moduloHash { // modulo hash algorithm by Asta Walor-Scott

	public static class key {
		private String key;
		int uniqueCount;


		key (String key,int secondKey){
			this.key = key;
			this.uniqueCount = secondKey;

		}
		public int hashCalc(String key) {
			int num = 0;
			char[] array = key.toCharArray();

			//System.out.println(num);//debug

			for (int i = 0; i < array.length; i++) {
				num += (int)array[i];
			}
			num = uniqueCount * num % 9491;
			return num;
		}

		public boolean equal(Object obj) {
			if (this == obj) return true; // if it's the same object then return true

			if (obj == null || getClass() != obj.getClass()) return false; // safe gaurds against the wrong object (tho unliekly)

			key node = (key) obj;
			if (uniqueCount != node.uniqueCount) return false;
			return key != null ? key.compareTo(node.key) == 0 : node.key == null;
		}

	}

	private int clash = 0;

	private key[] modulo  = new key[9481];
	static int wordCount = 0;
	int num = 0;

	moduloHash (){}

	public void setHash(String key, int secondKey){
		key node = new key(key, secondKey);
		num = node.hashCalc(key);
		if (num >= 9481) {
			num = 0;
		}
		if (modulo[num] != null) {
			clash++;
		}
		while (modulo[num] != null){ //handles collisions 
			//System.out.println(modulo.length);//debug
			num++;
			if (num >= 9481) {
				num = 0;
			}
		}
		//System.out.println(node.hashCalc(key));//debug
		modulo[num] = node;
		num = 0;
	}

	public String getTable(){
		String print = "";
		for (int i = 0; i < modulo.length; i++) {
			if (modulo[i] != null) {
				print += modulo[i].key + " " +  "\n";
			}
		}

		return print;
	}
	public int getClash(){
		return clash;
	}
	public double getLoadFactor() {
		double load = 0;
		for (int i = 0; i < modulo.length; i++) {
			if (modulo[i] != null) {
				load += 1;
				//System.out.println(load);
				}
		}
		return load = load / 9491;
	}

}
