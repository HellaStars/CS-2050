import java.util.ArrayList;

public class linkList {
	static nodeLinkList head;
	public static class nodeLinkList {

		String Dracula;
		nodeLinkList next;
		int uniqueWordCount = 1;
		static int wordCount= 1;

		nodeLinkList(String Line){
			wordCount++;
			this.Dracula = Line;
			next = null;
		}
	}


	public static linkList insert(linkList list, String Line) {
		nodeLinkList node = new nodeLinkList(Line); // makes the new data
		if (compareSearch(list, Line)) {
			node.wordCount =+ 1;
		} else {
		node.wordCount =+ 1;
		if (head == null) {
			list.head = new nodeLinkList(Line); //makes a new head
		} else {
			nodeLinkList last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;

		}
		}
		return list;
	}
	public ArrayList <String> printFiltered(char compare, linkList list) {
		nodeLinkList current = list.head;
		ArrayList <String> info = new ArrayList<String>();
		while (current != null) {
			if (compare == current.Dracula.charAt(0)) {
			 info.add(current.Dracula +" " + Integer.toString(current.uniqueWordCount));
			current = current.next;
			}else {
				current = current.next;
			}
		}
		return info;
	}
	private static Boolean compareSearch(linkList list, String Line) { //kinda gonna be slow
		nodeLinkList current = list.head;
		while (current != null) {
			 if (Line.compareTo(current.Dracula) == 0) {
					current.uniqueWordCount = current.uniqueWordCount + 1;
				 return true;
			 }
			current = current.next;
		}
		return false;
	}
}
