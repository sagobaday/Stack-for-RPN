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
	
	/*public void removeLast() {
		curr = curr.getPrev();
		
		if (curr == null) {
			head = new Node(null, null, null);
			curr = head;
		}
			curr.setNext(null);
	}*/
	
	public void removeLast() {
        if (head != null) {
            if (curr.getPrev() != null) {
                curr = curr.getPrev();
                curr.setNext(null);
            } else {
                head = null;
                curr = null;
            }
        }
    }
	
	public Object getLast() {
		if (curr != null)
			return curr.getData();
		else
			return null;
	}
	
	public void clear() {
		head = null;
		curr = null;
	}
}
