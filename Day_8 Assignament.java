


/*
 * 1) define your exception class by name "MyArithException"
 * (MyArithException.java) define class "Calculator" (Calculator.java) In this
 * class define a function,which will accept an int and return double of it. e.g
 * int caldouble(int) This function will check an int which is passed to it It
 * will raise the exception if 0 is passed or negative passed in case of 0
 * caller of this method should get error message "Zero not allowed" in case of
 * negative caller of this method should get error message
 * "negative not allowed" In case of positive value it should simply return the
 * double value. [ this method shouldn't handle the exception]
 * 
 * Now define class "MyCalcApp" (MyCalcApp.java) In this class you accept a
 * number from user and pass that no. to caldouble() method which is mentioned
 * above.
 */
import java.util.*;

class MyArithException extends Exception
{
	public MyArithException (String mess)
	{
	 super (mess);
	}
}
class Calculator
{
	 static int calDouble(int k) throws MyArithException
	{
		 if(k==0)
		 {
			 throw new MyArithException("Zero Not Allwed");
		 }
		 if(k<0) 
		 {
			 throw new MyArithException("nigative not allowed");
		 }
		 
		return k+k;
	}
}
public class MyCalcApp
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int a=sc.nextInt();
		try
		{
			int k=Calculator.calDouble(a);
			System.out.println(k);
		}
		catch(MyArithException m)
		{
			System.out.println(m);
		}
	
		System.out.println("Done");
	}
}




/*
 * 2) on the developer side create an exception:
 * NumberNotDivisibleBySevenException as a checked exception
 * 
 * create necessary jar and documentation.
 * 
 * on client side public class MyMath class with public void disp(int num) this
 * disp() method will check if the number passed is not divisible by 7 , it will
 * raise "NumberNotDivisibleBySevenException" or else it will simply display the
 * number passed. [ this method shouldn't handle the exception]
 * 
 * public class Demo main function invoke "disp()" of "MyMath" class.
 */



//Devloper Side

/**
 * 
 */
package dev;


public class NumberNotDivisibleBySevenException extends Exception
{
	public NumberNotDivisibleBySevenException(String mess)
	{
		super(mess);
	}
}


//Client Side

package client;

import dev.NumberNotDivisibleBySevenException;

public class MyMath 
{
	public static void disp(int num) throws NumberNotDivisibleBySevenException
	{
			if(num%7!=0)
			{
				throw new NumberNotDivisibleBySevenException("num is not divisible by 7");
			}
			System.out.println(num);
	}
}

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int a=sc.nextInt();
	
		try
		{
			MyMath.disp(a);		
		}
		catch(NumberNotDivisibleBySevenException m)
		{
			System.out.println(m);
		}
		System.out.println(num/7);
	}

}


/*
 * 3) define "MyException" as a checked exception.
 * 
 * define a class "Demo" with public void show1(), public void show2() , public
 * void show3() and main functions.
 * 
 * inside "show3()" accept a number and if it is greater than 10 raise
 * "MyException" else display the number. [ this method shouldn't handle the
 * exception]
 * 
 * main() function should call "show1()" , show1() function should call
 * "show2()", show2() function should call "show3()"
 * 
 * show2() should not handle the exception but show1() should handle.
 */

import java.util.Scanner;

class MyException extends Exception
{
	public MyException(String mess)
	{
		super(mess);
	}
}
public class Demo
{
	public void show1(int k) 
	{
		try 
		{
		show2(k);
		}
		catch(MyException m)
		{
			System.out.println(m);
		}
		
	}
	public void show2(int k) throws MyException
	{
		show3(k);
	}
	public void show3(int k) throws MyException
	{
		if(k>10)
		{
			throw new MyException("no is gretter than 10");
		}
		else
			System.out.println(k);
	}
public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a number");
	int a=sc.nextInt();
		Demo d=new Demo();
		d.show1(a);
	}
}


/*
 *4) on the developer side create following checked exception:
 *	InvalidLengthException
 *	create necessary jar file and documentation.
 *
 *on client side
 *
 *public class Authenticator
 *	with
 *a parameterized constructor which takes String as a password.
 *this class also will have "done()" method with "successful authentication" message.
 *Parameterized constructor should check the length of the password passed if it is less than 5 or more that 9 , it should raise "InvalidLengthException" 
 *	[ constructor shouldn't handle the exception]
 *
 *create a class "Demo" with main
 *	inside main function create the object of "Authenticator" class and invoke "done()" method.
*/


//Developer side
package ddd;


public class InvalidLengthException extends Exception
{
   public InvalidLengthException(String Mess)
   {
	   super(Mess);
   }
}

//Client Side
package client;

import java.util.Scanner;
import java.util.stream.IntStream;

import ddd.InvalidLengthException;

public class Authenticator 
{
	private String Password;
	public Authenticator(String Password) throws InvalidLengthException
	{
		if(Password.length()<5||Password.length()>9)
		{
			throw new InvalidLengthException("Invalide Password");
		}
		this.Password=Password;
	}
	static void Done()
	{
		System.out.println("successful authentication");
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Password");
		String Pass=sc.next();
		
		try
		{
			Authenticator A1=new Authenticator(Pass);
			Done();
		}
		catch(InvalidLengthException m)
		{
			System.out.println(m);
		}
	}
}

	


/*
 * 5) on the developer side create checked exception
 * "ResourceNotAllocatedException"
 * 
 * create a class:
 * 
 * public class MyResource implements AutoCloseable { public MyResource(int
 * capacity) throws ResourceNotAllocatedException { if(capacity>100) { throw new
 * ResourceNotAllocatedException("not sufficient space"); } } void disp() {
 * System.out.println("successful"); }
 * 
 * @Override public void close() { System.out.println("resource is closed");
 * 
 * } }
 * create necessary jar file and documentation
 * 
 * on the client side public class Demo with main function
 * 
 * inside main function, create object of "MyResource" and invoke "disp()"
 * method.
 */

import java.util.Scanner;

class ResourceNotAllocatedException extends Exception
{
	public ResourceNotAllocatedException(String Mess)
	{
		super (Mess);
	}
}
class MyResource implements AutoCloseable
{
	public MyResource(int capacity) throws ResourceNotAllocatedException
	{
		if(capacity>100)
		{
			throw new ResourceNotAllocatedException("not sufficient space");
		}
	}
    public void disp()
    {
    	System.out.println("successful");
    }
	@Override
	public void close()  {
		System.out.println("resource is closed");
		
	}
}
public class Demo 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("File size");
		int cap=sc.nextInt();
		try
		{
		MyResource M1=new MyResource(cap);
		M1.disp();
		M1.close();
		}
		catch(ResourceNotAllocatedException m)
		{
			System.out.println(m);
		}
	}
}
 
