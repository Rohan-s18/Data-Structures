package com.rohan.csds233.assignment1;

import java.util.Arrays;

public class Assignment1_Unit_Test {
	
	public static void main(String[] args) {
		Course[] arr = {new Course("CSDS132","Intro to Java",200),new Course("CSDS231","Data Structures",150),
						new Course("CSDS281","Logic Design",150),new Course("CSDS302","Discrete Mathematics",200),
						new Course("CSDS301","Artificial Intelligence",200),new Course("CSDS398","Software Engineering",200),
						new Course("MATH121","Calc 1",500),new Course("MATH122","Calc 2",300),
						new Course("MATH233","Calc 3",200)};
		CourseList myList = new CourseList(arr);
		myList.formattedPrint();
		
		/*Course crs1 = new Course();
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
		System.out.println(myList.searchCourseName("Calc 4"));
		myList.formattedPrint();
		
		System.out.println(foo(100));*/
		
	}
	
	/*
	boolean foo(int[]a, int val) {
		for(int i = 0; i < a.length; i++) {		//int i = 0 is a constant operation; i <= a.length & i++ are repeated operations
			if(a[i] == -1) {					//One repeated operation
				a[i] = val;
				return true;
			}
		}
		return false;							//One constant operation
	}*/
	
	static int foo(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for(int i = 1; i <= n; i++)
			for(int j = 2; j <= Math.sqrt(i); j++) 
				if(i%j == 0)
					isPrime[i] = false;
		int sum = 0;
		for(int k = 0; k <= n;k++) 
			sum += isPrime[k] ? k:0;
		return sum;
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