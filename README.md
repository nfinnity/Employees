# Employees
This project demonstrates the concept of abstract classes, inheritance, and polymorphism by creating different kinds of employees.


Problem Description

The purpose of this project is to create a program that displays a menu, creates employee objects that are either of 
type Salaried or Hourly (payed hourly or by salary), and perform various operations on the employee objects. These 
operations include creating new employees (command n), computing paychecks (command c), raising wages (command r), 
printing out the records of the current employees (command p), downloading the employees in the active record to a 
data file (command d), uploading the employees stored in that same data file into active records of the program 
(command u), and exiting the program (command q). 


Program Specification

For this program, a menu will first be displayed with various options for operations and their corresponding commands. 
The user will input a letter (command), and the program will then use a case structure to call the appropriate method 
that will perform the called operation. There is one base class named Employee class, and two derived classes named 
HourlyEmployee and SalariedEmployee. When the create employee option is called, either an HourlyEmployee object or a 
SalariedEmployee object is created (specified by user), and is then casted into an ArrayList of employee objects that 
contains all of the employees. All other operations are then performed on that ArrayList of employee objects. When 
the download command is called, the ArrayList of employees is then converted into binary code and placed inside of a 
data file named employee.dat.  When the upload command is called, the binary code inside of employee.dat is then 
converted and read back in to the program. The program knows that it is an ArrayList of type Employee because it is 
casted as such. This is possible because all objects can be casted to an Object type, which is how the binary file 
is read back in. 
 
Classes:

-Employee

	Methods:  
		
		(public) splitName():
		Method to split name into first and last name when entered as First Last; no parameters because the variables 
		that are used are global.

		(abstract) computePay(): 
		Method created in parent class to be used by derived classes to compute the pay of the employee for the week.

		(protected) Employee(): 
		Constructor that creates an employee object and set the global variables for hourly wage and employee name.

		(public) setName(String name): 
		Method to set the employees name to the String parameter name.

		(public) setHourlyWage(double hourlyWage): 
		Method to set the hourly wage for the employee to the double parameter hourlyWage.

		(public) getName(): 
		Method to return a String containing the employees name.

		(public) getHourlyWage(): 
		Method to return a double representing the employees hourly wage.

		(public) increaseWage(double percentage): 
		Method that increases the hourly wage by the percentage sent in as a parameter.

-HourlyEmployee

	Methods: 
		
		(public) HourlyEmployee(String name, double hourlyWage): 
		Creates an HourlyEmployee object by supering the Employee constructor and also increases the count for 
		the number of employees.

		(public) computePay(): 
		Method that returns the weekly pay for the employee based on the number of hours that were worked 
		(overtime accounted for).

		(public) toString(): 
		(Overriding) Method that returns the formatted output of the employees name and the their pay. 

		(public) waitForResponse(): 
		Method that pauses the system and waits for an entry from the user before continuing. 

-SalariedEmployee

	Methods:
		
		(public) SalariedEmployee(String name, double salary): 
		Creates a SalariedEmployee object that supering the Employee constructor and also increases the 
		count for the number of employees.

		(public) getSalary(): 
		Returns a double that represents the employees salary.

		(public) setSalary(double salary): 
		Method that sets the salary of the employee to the double value sent in as a parameter. Achieved by 
		altering the global variable hourlyWage for the employee.

		(public) computePay(int hours): 
		Method that computes and returns the employees weekly pay, which is irrelevant to how many hours were worked. 	

		(public) toString(): 
		Method that returns the formatted output of the employees name and their pay.

		(public) waitForResponse(): 
		Method that pauses the system and waits for an entry from the user before continuing. 

-Personnel

	Methods:
		
		(public) displayMenu(): 
		Method that displays a formatted menu with the various options of commands the 
		user can enter.

		(public) createEmployee(): 
		Method that prompts the user for the name, type, and pay for the employee.
		Depending on the type, the corresponding constructor is then called and either an HourlyEmployee 
		or SalariedEmployee is created (an Employee object is always created and added to a global ArrayList).

		(public) computePayChecks(): 
		Method that goes through the entire ArrayList of Employee objects and 
		computes their checks and prints the information using the toString methods.

		(public) raiseWages(): 
		Method that prompts the user to enter the percentage the wage should be increased, 
		and then goes through the entire ArrayList of Employee objects and increases the wages.

		(public) printRecords(): 
		Method that goes through the entire ArrayList of Employee objects and uses the toString() method 
		to print out the employees information.

		(public) downloadData():
		Method that creates a file named employee.dat and downloads/writes the binary data into the file.

		(public) uploadData(): 
		Method that uploads the binary data from the file employee.dat and adds the uploaded employees to the program.

		(public) quit(): 
		Method that exits the program.

		(public) waitForResponse(): 
		Method that pauses the system and waits for an entry from the user before continuing. 
