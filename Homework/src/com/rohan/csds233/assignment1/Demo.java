package com.rohan.csds233.assignment1;

public class Demo {

	public static void main(String[] args) {
		CourseList testList = new CourseList();			//Creating a CourseList Object 
		
		testList.addCourse(0, new Course("CSDS233","Data Structures",100));  //Using the add method to add new course objects to testList
		testList.addCourse(1, new Course("CSDS132","Intro to Java",150));
		testList.addCourse(2, new Course("CSDS281","Logic Design",100));
		testList.addCourse(1, new Course("MATH121","Calc 1",500));
		testList.addCourse(4, new Course("MATH122","Calc 2",350));
		testList.addCourse(5, new Course("MATH223","Calc 3",200));			//Adding course which is out of bounds (will be added to the end)
				
		testList.changeCapacity("MATH122", 400);		//Using the changeCapacity() method to change the capacity of class to 400
				
		testList.removeCourse(3);   					//Removing the course at index 3 (CSDS 281)
		
		System.out.println(testList.getCourseWithIndex(3));  //Printing the course at index 3 (Course Object has overridden toString() method) 
		System.out.println();
		
		System.out.println(testList.searchCourseId("CSDS233")); //Searching for the index of course with course id CSDS233 
		System.out.println(testList.searchCourseId("CSDS281")); //Searching for the index of course with course id CSDS281 (should return -1) 
		System.out.println();
		
		System.out.println(testList.searchCourseName("Intro to Java")); //Searching for the index of course with course name "Intro to Java" 
		System.out.println(testList.searchCourseId("Intro too Jaava")); //Searching for the index of course with course name "Intro too Jaava" (should return -1) 
		System.out.println();
		
		
		
	}

}
