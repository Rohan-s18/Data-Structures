package com.rohan.csds233.Classwork;

public class Sep_2 {
	
	public static void main(String[]args) {
		
	}
	
	public static int sum(int n){
		int partialSum = 0;                         // One constant operation
		for(int i = 1; i <=n; i++) {                // int i = 1 is a constant operation; i <= n & i++ are repeated operations
			partialSum += i*i*i;                    // +,=,triple multiplication are repeated operations
		}
		return partialSum;                          // One constant operation
	}                                               // Runtime = 6N+4, time complexity = O(N)

}



//Notes Over Here

/*

----------------------------------------------------------------------------------------------------------------------------------------------
Growth Rate Notations 

1)Big O Notation:-
	T(N) = O(f(N)) if there are positive constants c and n0 such that T(N) =< cf(n) for all N > n0

	Example:
	T(N) = 10*N^2 + 10000 = O(N^3)
	=> T(n) =< c(N^3) 
	=> 10N^2 +10000 =< c(N^3)           N^3 is not tightest bound, if we use N^2 is the tightest bound


2)Big Omega Notation:-
	T(N) = O(f(N)) if there are positive constants c and n0 such that T(N) < cf(n) for all N > n0

	Example:
	T(N) >= 10*N^2 + 10000 = O(N^3)
	=> T(n) >= c(N^3) 
	=> 10N^2 +10000 >= c(N^3)
	

3)Big Theta Notation:-          (Gives tightest bound)
	T(N) = O(f(N)) if there are positive constants c and n0 such that T(N) < cf(n) for all N > n0

	Example:
	T(N) = 10*N^2 + 10000 = O(N^3)
	=> T(n) = c(N^3) 
	=> 10N^2 +10000 = c(N^3)
	
4)Little o Notation:-
	T(N) = o(f(N)) if there are positive constants c and n0 such that T(N) < cf(n) for all N > n0

	Example:
	T(N) < 10*N^2 + 10000 = o(N^3)
	=> T(n) < c(N^3) 
	=> 10N^2 +10000 < c(N^2)





-------------------------------------------------------------------------------------------------------------------------------------------------

Properties of big-O Notation:

1) If T1(N) = O(f(N)) and T2(N) = O(g(N), then T1(N) + T2(N) = O(f(N) + g(N))     <= back-to-back for loops
2) If T1(N) = O(f(N)) and T2(N) = O(g(N), then T1(N)*T2(N) = O(f(N)*g(N))         <= nested for loops
3) Only Dominating terms matter, smaller terms and constants do not matter.

--------------------------------------------------------------------------------------------------------------------------------------------------


Computing running general rules:

1) 	Simple statements: constant
	++,=,< etc.

2) 	Simple loops: #number of iterations times the cost of theloop body
	i=0;while(i<n);....++....

3) 	Nested for loops: the product of # of iterations and inner for loops, times times the cost of the inner loop body
	for(i =.....){
	for(j =.....){
		........
	}
}

4)	Consecitive statements: count the more expensive one
	while(.....){
		......                                           
	}
	for(......){
		for(......){
			....                                 //Only nested for loop will be considered
		}
	}


5) 	if/Else: count the more expensive branch (for worst case scenario)


----------------------------------------------------------------------------------------------------------------------------------------------

Answers:

1) Time complexity is N

2) Time complexity is N^2
















*/