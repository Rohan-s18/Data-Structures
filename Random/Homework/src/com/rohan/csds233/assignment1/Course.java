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
	
	public void setCourseID(String courseId) {               //Setter method for course ID
		this.courseId = courseId;
	}
	
	public void setCourseName(String courseName) {           //Setter method for course name
		this.courseName = courseName;
	}
	
	public void setCapacity(int capacity) {                  //Setter method for capacity
		this.capacity = capacity;
	}
	
	public String getCourseID() {                            //Getter method for course ID
		return courseId;
	}
	
	public String getCourseName() {                          //Getter method for course name
		return courseName;
	}
	
	public int getCapacity() {                               //Getter method for capacity
		return capacity;
	}
	
	public String toString() {                               //Overriding default toString() method to get formatted course details
		return "Course ID: " + courseId + ", course name: " + courseName + ", capacity: " + String.valueOf(capacity);
	}
	
	
}
