package com.rohan.csds233.assignment1;

import java.util.*;

public class Assignment1_Unit_Test {
	
	public static void main(String[] args) {
		CourseList myList = new CourseList();
		Course crs1 = new Course();
		crs1.setCapacity(50);
		crs1.setCourseID("CSDS132");
		crs1.setCourseName("Intro to Java");
		myList.addCourse(0, crs1);
		Course crs2 = new Course();
		crs2.setCapacity(50);
		crs2.setCourseID("CSDS233");
		crs2.setCourseName("Data Structures");
		myList.addCourse(1, crs2);
		Course crs3 = new Course();
		crs3.setCapacity(50);
		crs3.setCourseID("CSDS281");
		crs3.setCourseName("Logic Design");
		myList.addCourse(2, crs3);
		Course crs4 = new Course();
		crs4.setCapacity(50);
		crs4.setCourseID("MATH121");
		crs4.setCourseName("Calc 1");
		myList.addCourse(3, crs4);
		Course crs5 = new Course();
		crs5.setCapacity(50);
		crs5.setCourseID("MATH122");
		crs5.setCourseName("Calc 2");
		myList.addCourse(4, crs5);
		Course crs6 = new Course();
		crs6.setCapacity(50);
		crs6.setCourseID("MATH233");
		crs6.setCourseName("Calc 3");
		myList.addCourse(5, crs6);
	
		System.out.println(myList.size());
		
		myList.removeCourse(3);
		
		System.out.println(myList.size());
		
		myList.changeCapacity("CSDS233", 100);
		System.out.println(myList.getCourseWithIndex(1).getCapacity());
		
		System.out.println(myList.searchCourseId("MATH233"));
		System.out.println(myList.searchCourseName("Calc 3"));
		myList.formattedPrint();
		
	}
	
	
}



class PrimitiveTypeChecker{
	
	public void checkType(byte x) {
		System.out.println("It is a byte");
	}
	
	public void checkType(int x) {
		System.out.println("It is an int");
	}
	
	public void checkType(double x) {
		System.out.println("It is a double");
	}
	
	public void checkType(char x) {
		System.out.println("It is a char");
	}
	
	public void checkType(long x) {
		System.out.println("It is a long");
	}
	
	public void checkType(float x) {
		System.out.println("It is a float");
	}
	
	
	
	
}