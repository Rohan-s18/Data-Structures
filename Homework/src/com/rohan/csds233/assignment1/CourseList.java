package com.rohan.csds233.assignment1;

public class CourseList {
	private Course[] listOfCourses = new Course[10];
	
	public CourseList(Course[] courseList) {				//Default Constructor
		if(courseList.length < listOfCourses.length) {
			int i = 0;
			for(Course c : courseList) {
				listOfCourses[i] = c;
				i++;
			}
		}
	}
	
	public CourseList() {				//Overloaded parameter-less constructor
	}
	
	int size() {                                       
		int size = 0;                                          
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null) {        //if the object at the i-th index is not null, then the size variable is increased by 1
				size++;
			}
		}
		return size;
	}
	
	void addCourse(int i, Course course) {             
		if(i < listOfCourses.length) {         //Adding Course to i-th index if it exists
			listOfCourses[i] = course;
		} else {
			listOfCourses[listOfCourses.length - 1] = course;    //Adding course to the last element if index is out of bounds
		}
	}
	
	boolean removeCourse(int i) { 
		if(i >= listOfCourses.length) 
			return false;                          //returning false if index is out of bounds
		for(int j = i; j < size(); j++) {          //Shifting every element to the right of i-th element by one index to the left
			listOfCourses[j] = listOfCourses[j+1];   
		}
		return true;
	}
	
	boolean changeCapacity(String courseID, int capacity) {             
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i].getCourseID().equals(courseID)) {       //Matching course ID
				listOfCourses[i].setCapacity(capacity);                 //Using set method of Course object to change the capacity
				return true;
			}
		}
		return false;                                                   //returning false if none of the course IDs match 
	}
	
	Course getCourseWithIndex(int i) {                           
		if(i < listOfCourses.length) {
			return listOfCourses[i];                                    //returning i-th element (if it is within bounds)
		}
		return null;
	}
	
	int searchCourseId(String courseID) {
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i].getCourseID().equals(courseID)) {  //Comparing the course ID of every course in the list to the argument
					return i;                                      //Returning the index of the match
			}
		}
		return -1;                                                 //Returning -1 if course ID doesn't match
	}
	
	int searchCourseName(String courseName) {
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null && listOfCourses[i].getCourseName().equals(courseName)) {   //Comparing the course name of every course in the list to the argument   
				return i;                                               //Returning the index of the match
			}
		}
		return -1;                                                      //Returning -1 if course name doesn't match
	}
	
	
	//Additional formatted print method
	
	void formattedPrint() {
		for(int i = 0; i < listOfCourses.length; i++) {
			if(listOfCourses[i] != null)                                //Checking if i-th element is null
				System.out.println(String.valueOf(i) + ". " + listOfCourses[i]);    //formatting string (overridden Course object toString() method)
		}
	}
	
}





