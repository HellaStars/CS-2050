import java.util.ArrayList;
import java.util.Collections;

public class linkList {
	static NodeLinkList head;

	public static class NodeLinkList {
		String Dracula;
		NodeLinkList next;
		int uniqueWordCount = 1;

		NodeLinkList(String Line) {
			this.Dracula = Line;
			next = null;
		}
	}

	static int wordCount = 0;
	static int nodeCount = 0;
	static linkList sorted = new linkList();
	static ArrayList<String> sort = new ArrayList<>();

	public static linkList insert(linkList list, String Line) {
		NodeLinkList node = compareSearch(list, Line);
		if (node != null) {
			node.uniqueWordCount += 1;
			wordCount += 1;
		} else {
			node = new NodeLinkList(Line);
			wordCount += 1;
			nodeCount += 1;
			if (head == null) {
				list.head = node;
			} else {
				NodeLinkList last = list.head;
				while (last.next != null) {
					last = last.next;
				}
				last.next = node;
			}
		}
		return list;
	}

	public ArrayList<String> printFiltered(char compare, linkList list) {
		NodeLinkList current = list.head;
		ArrayList<String> info = new ArrayList<String>();
		while (current != null) {
			if (compare == current.Dracula.charAt(0)) {
				info.add(current.Dracula + " " + current.uniqueWordCount);
				current = current.next;
			} else {
				current = current.next;
			}
		}
		return info;
	}

	public ArrayList<String> uniqueFilter(char compare, linkList list) {
		ArrayList<String> info = new ArrayList<>();
		listSortWithNum(compare, list);
		info = infoFilter (compare, info, list);
		return info;
	}

	private ArrayList<String> infoFilter(char compare,ArrayList<String> info,  linkList list) {
		NodeLinkList current = list.head;

		while (current != null) {
			if (compare == current.Dracula.charAt(0)) {
				info.add(current.Dracula);
				current = current.next;
			} else {
				current = current.next;
			}
		}
		return info;
	}
	
	public ArrayList<Integer> intFilter(ArrayList<Integer> array,  linkList list) {
		NodeLinkList current = list.head;

		while (current != null) {
				array.add(current.uniqueWordCount);
				current = current.next;
		}
		return array;
	}

	private void listSortWithNum(char compare,linkList list) {
		NodeLinkList current = list.head;
		while (current != null) {
			NodeLinkList index = current.next;
			NodeLinkList min = current;

			// Find the minimum element in the unsorted part of the list
			while (index != null) {
				if (index.uniqueWordCount < min.uniqueWordCount) {
					min = index;
				}
				index = index.next;
			}

			// Swap the minimum element with the current element
			String temp = current.Dracula;
			int temp2 = current.uniqueWordCount;

			current.Dracula = min.Dracula;
			current.uniqueWordCount = min.uniqueWordCount;

			min.Dracula = temp;
			min.uniqueWordCount = temp2;

			// Move to the next node
			current = current.next;
		}
	}



	private static NodeLinkList compareSearch(linkList list, String Line) {
		NodeLinkList current = list.head;
		while (current != null) {
			if (Line.compareTo(current.Dracula) == 0) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public void sortList() {
		NodeLinkList current = head;

		// Traverse through the list
		while (current != null) {
			NodeLinkList index = current.next;
			NodeLinkList min = current;

			// Find the minimum element in the unsorted part of the list
			while (index != null) {
				if (index.Dracula.compareTo(min.Dracula) < 0) {
					min = index;
				}
				index = index.next;
			}

			// Swap the minimum element with the current element
			String temp = current.Dracula;
			int temp2 = current.uniqueWordCount;

			current.Dracula = min.Dracula;
			current.uniqueWordCount = min.uniqueWordCount;

			min.Dracula = temp;
			min.uniqueWordCount = temp2;

			// Move to the next node
			current = current.next;
		}
	}

	/*public linkList sortList(linkList list) {
        sort.clear(); // Clear the ArrayList before sorting
        NodeLinkList current = list.head;

        while (current != null) {
            sort.add(current.Dracula);
            current = current.next;
        }

        System.out.println("Before sorting: " + sort);
        Collections.sort(sort);
        System.out.println("After sorting: " + sort);

        sorted = new linkList(); // Reset the sorted list
        for (int i = 0; i < sort.size(); i++) {
        	System.out.println(sort.get(i));
            sorted = sorted.insert(sorted, sort.get(i));
        }

        return sorted;
    }*/

	public ArrayList<String> printList(linkList list) {
		NodeLinkList current = list.head;
		ArrayList<String> info = new ArrayList<String>();
		while (current != null) {
			info.add(current.Dracula);
			current = current.next;
		}
		return info;
	}

	public String wordCount() {
		return Integer.toString(wordCount);
	}
}
