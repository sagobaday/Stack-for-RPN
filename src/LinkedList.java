public class LinkedList {
	private Node head, curr, prev;
	
	public LinkedList() {
		  curr = null;
		  head = null;
		  prev = null;
		}
	
	public void add(Object o) {
		if (head == null) {
			head = new Node(o, null);
			curr = head;
			prev = null;
		} else {
			curr.setNext(new Node(o, null));
			prev = curr;
			curr = curr.getNext();
		}
	}
	
	public void remove(Object o) {
		
	}
}