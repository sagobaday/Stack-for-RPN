public class LinkedList {
	private Node head, curr;
	
	public LinkedList() {
		  curr = null;
		  head = null;
		}
	
	public void add(Object o) {
		if (head == null) {
			head = new Node(o, null, null);
			curr = head;
		} else {
			curr.setNext(new Node(o, null, curr));
			curr = curr.getNext();
		}
	}
	
	public void removeLast(Object o) {
		if (head != null) {
			curr = curr.getPrev();
			curr.setNext(null);
		}
	}
	
	public Node getLast() {
		return curr;
	}
}
