package com.rohan.csds233.assignment1;

public class CourseList {
	private Course[] listOfCourses = new Course[10];
	
	public CourseList(Course[] courseList) {				//Default Constructor
		if(courseList.length < listOfCourses.length) {
			int i = 0;
			for(Course c : courseList) {					//Using an enhanced for-loop to store courses from array to the listOfCourses
				listOfCourses[i] = c;
				i++;
			}
		}
	}
	
	public CourseList() {				//Overloaded parameter-less constructor
	}
	
	public int size() { 
		int size = 0;                                          
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null) {        //if the object at the i-th index is not null, then the size variable is increased by 1
				size++;
			}
		}
		return size;
	}
	
	public void addCourse(int i, Course course) { 
		System.out.println("Operation: Add a course to index " + String.valueOf(i));
		System.out.println(course);
		System.out.println("List before the operation:");
		formattedPrint();
		if(i < listOfCourses.length) {         //Adding Course to i-th index if it exists
			listOfCourses[i] = course;
		} else {
			listOfCourses[listOfCourses.length - 1] = course;    //Adding course to the end if index is out of bounds
		}
		System.out.println("List after the operation:");
		formattedPrint();		
	}
	
	public boolean removeCourse(int i) {
		System.out.println("Operation: Removing a course from index " + String.valueOf(i));
		System.out.println(listOfCourses[i]);
		System.out.println("List before the operation:");
		formattedPrint();
		if(i >= listOfCourses.length) { 
			System.out.println("List after the operation:");
			formattedPrint();
			return false; 							//returning false if index is out of bounds
		}
		if(listOfCourses[i] == null) {              //returning false if there is no course at index i
			System.out.println("List after the operation:");
			formattedPrint();
			return false;
		}
		for(int j = i; j < listOfCourses.length - 1; j++) {           //Shifting every element to the right of i-th element by one index to the left
			listOfCourses[j] = listOfCourses[j+1]; 
		}
		if(i == listOfCourses.length-1) {							  //In case the element is at the last position of the CourseList, that index will be set to null
			listOfCourses[i] = null;
		}
		System.out.println("List after the operation:");
		formattedPrint();
		return true;
	}
	
	public boolean changeCapacity(String courseID, int capacity) {
		System.out.println("Operation: Change the capacity of course to " + String.valueOf(capacity));
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null && listOfCourses[i].getCourseID().equals(courseID)) {       //Matching course ID
				System.out.println("Course: " + listOfCourses[i]);
				System.out.println("List before operation:");
				formattedPrint();
				listOfCourses[i].setCapacity(capacity);                 //Using set method of Course object to change the capacity
				System.out.println("List after operation:");
				formattedPrint();
				return true;
			}
		}
		return false;                                                   //returning false if none of the course IDs match 
	}
	
	public Course getCourseWithIndex(int i) {
		System.out.println("Operation: Retrieving course at index " + String.valueOf(i));
		if(i < listOfCourses.length) {
			return listOfCourses[i];                                    //returning i-th element (if it is within bounds)
		}
		return null;
	}
	
	public int searchCourseId(String courseID) {
		System.out.println("Operation: Search for course with course id " + courseID);
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null && listOfCourses[i].getCourseID().equals(courseID)) {  //Comparing the course ID of every course in the list to the argument (extra check is to prevent null pointer exception)
					return i;                                      //Returning the index of the match
			}
		}
		return -1;                                                 //Returning -1 if course ID doesn't match
	}
	
	public int searchCourseName(String courseName) {
		System.out.println("Operation: Search for course with course name " + courseName);
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null && listOfCourses[i].getCourseName().equals(courseName)) {   //Comparing the course name of every course in the list to the argument (extra check is to prevent null pointer exception) 
				return i;                                               //Returning the index of the match
			}
		}
		return -1;                                                      //Returning -1 if course name doesn't match
	}
	
	
	//Additional formatted print method
	
	public void formattedPrint() {
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null)                                //Checking if i-th element is null
				System.out.println(String.valueOf(i) + ". " + listOfCourses[i]);    //formatting string (overridden Course object toString() method)
		}
		System.out.println();
	}
	
}





