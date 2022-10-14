public class ReverseLinkedList_Demo {

	public static void main(String[] args) {
		NumLinkedList myTestList = new NumLinkedList();
		myTestList.add(1);
		myTestList.add(2);
		myTestList.add(3);
		myTestList.add(4);
		myTestList.add(5);
		myTestList.add(6);
		myTestList.add(7);
		myTestList.add(8);
		myTestList.add(9);
		myTestList.printList();			//Printing the original order of the list
		
		System.out.println();
		
		myTestList.reverse();			//Calling the reverse method
		myTestList.printList();			//Printing the reversed order of the list

	}

}
