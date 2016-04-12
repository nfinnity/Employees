import java.util.*;
import java.io.*;
import java.awt.*;
import java.lang.*;

abstract class Employee implements Serializable
{
	protected String name;
	protected double hourlyWage;
	protected String firstName = null;
	protected String lastName = null;
	protected int counter = 0;
	
	//Method to split name into first and last name when entered as "First Last"
	public void splitName()
	{
		Scanner namePartitioner = new Scanner(name);
		firstName = namePartitioner.next();
		lastName = namePartitioner.next();
	}
	
	//Abstract method for computePay
	public abstract double computePay(int hours);
	
	//Constructor for class
	protected Employee(String name, double hourlyWage)
	{
		this.name = name;
		this.hourlyWage = hourlyWage;
	}
	
	//Setter method for name
	public void setName(String name)
	{
		this.name = name;
	}
	
	//Setter method for wage
	public void setHourlyWage(double hourlyWage)
	{
		this.hourlyWage = hourlyWage;
	}
	
	//Getter method for name
	public String getName()
	{
		return name;
	}
	
	//Getter method for wage
	public double getHourlyWage()
	{
		return hourlyWage;
	}

	//Setter method for wage increase
	public void increaseWage(double percentage)
	{
		hourlyWage = hourlyWage + hourlyWage*(percentage/100.0);
	}	
}


class HourlyEmployee extends Employee implements Serializable
{
	//Constructor for HourlyEmployee
	public HourlyEmployee(String name, double hourlyWage)
	{
		super (name, hourlyWage);
		counter++;
	}

	//Method to compute the pay for the person using the number of hours they have worked.
	public double computePay(int hours)
	{
		double totalPayment = 0;
		if (hours > 40)
		{
			totalPayment = 40*hourlyWage + (hours - 40)*(1.5*hourlyWage); 
		}
		else if ((hours <= 40) && !(hours < 0))
		{
			totalPayment  = hours*hourlyWage;	
		}
		else
		{
			Scanner input = new Scanner(System.in);
			System.out.print("There was an error in the number of hours entered. Please enter the value again. ");
			waitForResponse();
			int newHours = input.nextInt();
			computePay(newHours);
		}
		return totalPayment;
	}
	
	//String to print the name and hourly wage of the person.
	public String toString()
	{
		String information;
		if (name.contains(","))
		{
			String formattedWage = String.format("%.2f", hourlyWage);
			String stringWage = "$" + formattedWage;
			information = String.format("%-20s %20s/hour", name, stringWage);
		}
		else
		{
			splitName();
			String name = lastName + ", " + firstName;
			String formattedWage = String.format("%.2f", hourlyWage);
			String stringWage = "$" + formattedWage;
			information = String.format("%-20s %20s/hour", name, stringWage);
		}
		return information;
	}
	
	//Pauses the system and waits for input before continuing.
	public static void waitForResponse()
    {
        Scanner listener = new Scanner(System.in);
        listener.nextLine();
    }
}




class SalariedEmployee extends Employee implements Serializable
{
	//Constructor for SalariedEmployee
	public SalariedEmployee(String name, double salary)
	{
		super (name, (salary/(40.0*52.0)));
		counter++;
	}
	
	//Method to retrieve the salary of the employee.
	public double getSalary()
	{
		return hourlyWage*(40.0*52.0);
	}
	
	//Method to set the salary of the employee.
	public void setSalary(double salary)
	{
		hourlyWage = salary/(40.0*52.0);
	}
	
	//Method to compute the pay for the person using the number of hours they have worked.
	public double computePay(int hours)
	{
		double pay = 40.0*hourlyWage;
		return pay;
	}
	
	//String to print the name and hourly wage of the person.
	public String toString()
	{
		String information;
		if (name.contains(","))
		{
			String formattedWage = String.format("%.2f", hourlyWage*(40.0*52.0));
			String stringWage = "$" + formattedWage;
			information = String.format("%-20s %20s/year", name, stringWage);
		}
		else
		{
			splitName();
			String name = lastName + ", " + firstName;
			String formattedWage = String.format("%.2f", hourlyWage*(40.0*52.0));
			String stringWage = "$" + formattedWage;
			information = String.format("%-20s %20s/year", name, stringWage);
		}
		return information;
	}
	
	//Pauses the system and waits for input before continuing.
	public static void waitForResponse()
    {
        Scanner listener = new Scanner(System.in);
        listener.nextLine();
    }
	
}


public class Personnel {

	
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	static ArrayList<String> employeeList = new ArrayList<String>();
	static String name = null;
	static double wage = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		boolean continueProgram = true;
		
		//While loop that runs the program until "q" is entered.
		while (continueProgram)
		{
		displayMenu();
		System.out.print("Enter command: ");
		String command = input.nextLine();
		command = command.toLowerCase();
		command = command.replaceAll("\\s", "");
		int selector = 0;
		

		if (command.equalsIgnoreCase("n"))
			selector = 1;
		else if (command.equalsIgnoreCase("c"))
			selector = 2;
		else if (command.equalsIgnoreCase("r"))
			selector = 3;
		else if (command.equalsIgnoreCase("p"))
			selector = 4;
		else if (command.equalsIgnoreCase("d"))
			selector = 5;
		else if (command.equalsIgnoreCase("u"))
			selector = 6;
		else if (command.equalsIgnoreCase("e"))
			selector = 7;
		else if (command.equalsIgnoreCase("q"))
			selector = 8;

		
		
		switch (selector) 
		{
			case 1:
			{
				createEmployee();
				break;
			}
			case 2:
			{
				computePayChecks();
				break;
			}
			case 3:
			{
				raiseWages();
				break;
			}
			case 4:
			{
				printRecords();
				break;
			}
			case 5:
			{
				downloadData();
				break;
			}
			case 6:
			{
				uploadData();
				break;
			}
			case 7:
			{
				eraseData();
				break;
			}
			case 8:
			{
				continueProgram = false;
				break;
			}
			default:
			{
				System.out.print("Command was not recognized; please try again.");
				waitForResponse();
			}
		}
	}
		quit();
}
		//Formatting for the menu display.
		public static void displayMenu()
		{
			System.out.println("----------------------------------");
			System.out.println("|Commands: n - New Employee      |");
			System.out.println("|          c - Compute Paychecks |");
			System.out.println("|          r - Raise Wages       |");
			System.out.println("|          p - Print Records     |");
			System.out.println("|          d - Download data     |");
			System.out.println("|          u - Upload data       |");
			System.out.println("|          e - Erase data        |");
			System.out.println("|          q - Quit              |");
			System.out.println("----------------------------------");
		}

		//Menu that gets the information to create a new employee and creates 
		//a new employee based on the type that is entered.
		public static void createEmployee()
		{
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter the name of the new employee:  ");
			name = input.nextLine();
			System.out.print("Hourly (h) or salaried (s):  ");
			String type = input.nextLine();

			if (type.equals("s"))
			{
				System.out.print("Enter annual salary: ");
				wage = input.nextDouble();
				SalariedEmployee person = new SalariedEmployee(name, wage);
				employees.add(person);
			}
			
			if (type.equals("h"))
			{
				System.out.print("Enter hourly wage: ");
				wage = input.nextDouble();
				HourlyEmployee person = new HourlyEmployee(name, wage);
				employees.add(person);
			}
			if (!(type.equals("h")) && !(type.equals("s")))
			{
				System.out.println("Input was not h or s; Please try again.");
				waitForResponse();
				displayMenu();
				createEmployee();
			}
		}

		//Method that goes through the global ArrayList of all of the employees,
		//prompts the user to enter the amount of hours each employee worked,
		//and then calculates and prints the paychecks.
		public static void computePayChecks()
		{
			Scanner input = new Scanner(System.in);
			double payment = 0;
			for (int i = 0; i < employees.size(); i++)
			{
				Employee person = employees.get(i);
				System.out.print("Enter number of hours worked by " + person.getName() + ": ");
				int hoursWorked = input.nextInt();
				if (person instanceof SalariedEmployee)
				{
					SalariedEmployee person1 = (SalariedEmployee) person;
					payment = person1.computePay(hoursWorked);
				}
				if (person instanceof HourlyEmployee)
				{
					HourlyEmployee person1 = (HourlyEmployee) person;
					payment = person1.computePay(hoursWorked);
				}
				String output = String.format("Pay: $%.2f", payment);
				System.out.println(output);
			}
		}

		//Method that prompts user to enter the percentage for the wage increase,
		//goes through the entire ArrayList of employees, and modifies the wage
		//to be increased by the percentage.
		public static void raiseWages()
		{
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the percentage you'd like to increase the wages by: ");
			double percentIncrease = input.nextDouble();
			
			for (int i = 0; i < employees.size(); i++)
			{
				Employee person = employees.get(i);
				person.increaseWage(percentIncrease);		
			}
			
			System.out.println("\nNew Wages\n---------");
			for (int i = 0; i < employees.size(); i++)
			{
				Employee person = employees.get(i);
				System.out.println(person.toString());
			}
			System.out.println();
		}
		
		//Method to print all of the employees and their information.
		public static void printRecords()
		{
			if (employees.size() == 0)
			{
				System.out.println("There are currently no employees.");
			}
			else
			{
				for (int i = 0; i < employees.size(); i++)
				{
					Employee person = employees.get(i);
					System.out.println(person.toString());
				}
			}
				System.out.println();	
		}
		
		//Method to download the data
		public static void downloadData()
		{
			 String fileName = "employee.dat";		 
		        try {
		          FileOutputStream fileOut =
		            new FileOutputStream(fileName);
		          ObjectOutputStream out =
		            new ObjectOutputStream(fileOut);
		          out.writeObject(employees);
		          out.close();
		        }
		        catch (IOException e) {
		          System.out.println(e.getMessage());
		        }
		}
		
		//Method to upload the data
		public static void uploadData()
		{
			ArrayList<Employee> temp = null;
			String fileName = "employee.dat";
			 try {
		          FileInputStream fileIn =
		            new FileInputStream(fileName);
		          ObjectInputStream in =
		            new ObjectInputStream(fileIn);
		          temp = (ArrayList<Employee>) in.readObject();
		          in.close();
		        }
		        catch (IOException e) {
		          System.out.println(e.getMessage());
		        }
		        catch (ClassNotFoundException e)
		        {
		          System.out.println(e.getMessage());
		        }
			for (int i = 0; i < temp.size(); i++)
			{
				Employee person = temp.get(i);
				System.out.println(person.toString());
				employees.add(person);
			}
		}
		
		public static void eraseData()
		{
			employees.clear();
		}

		//Method to exit the program.
		public static void quit()
		{
			System.out.println("Exiting program...  ");
		    System.exit(0);
		}
		
		public static void waitForResponse()
	    {
	        Scanner listener = new Scanner(System.in);
	        listener.nextLine();
	    }
}