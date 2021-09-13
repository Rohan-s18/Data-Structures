package com.rohan.csds233.assignment1;

public class Course {
	private String courseId;
	private String courseName;
	private int capacity;
	
	public Course() {								  //Parameter-less constructor
	}
	
	public Course(String courseId, String courseName, int capacity) {	//Overloaded constructor with parameters
		this.courseId = courseId;
		this.courseName = courseName;
		this.capacity = capacity;
	}
	
	void setCourseID(String courseId) {               //Setter method for course ID
		this.courseId = courseId;
	}
	
	void setCourseName(String courseName) {           //Setter method for course name
		this.courseName = courseName;
	}
	
	void setCapacity(int capacity) {                  //Setter method for capacity
		this.capacity = capacity;
	}
	
	String getCourseID() {                            //Getter method for course ID
		return courseId;
	}
	
	String getCourseName() {                          //Getter method for course name
		return courseName;
	}
	
	int getCapacity() {                               //Getter method for capacity
		return capacity;
	}
	
	public String toString() {                               //Overriding default toString() method to get formatted course details
		return "Course ID: " + courseId + ", course name: " + courseName + ", capacity: " + String.valueOf(capacity);
	}
	
	
}
