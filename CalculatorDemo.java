//@Gopika V
//27-07-2018
//Question:
//Develop a calculator  application to perform addition, subtraction, multiply and divide two number based on the choice 1 add 2 sub 3 mul 4 div   without using any control statement like if, else if, case
//1)	Create an abstract class Arithmetic with has 2 instance variable num1, num2, num3. Methods to read, and display with the constructor to initialize. Abstract method calculate
//2)	Create sub class for addition, subtraction, multiplication and divide and override calculate method.
//3)	Create a array of reference for arithmetic class and initialize object of sub call (addition, subtraction, multiplication and division) 
//4)	Read two numbers and choice perform the calculation base on choice without using control statement.




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Arithmetic {
    double num1, num2;

    Arithmetic(double num1, double num2) {
	super();
	this.num1 = num1;
	this.num2 = num2;
    }

    abstract public void calculate();
}

class addition extends Arithmetic {

    addition(double num1, double num2) {
	super(num1, num2);
    }

    public void calculate() {
	double sum = num1 + num2;
	System.out.println("Sum = " + sum);
    }
}

class subtraction extends Arithmetic {

    subtraction(double num1, double num2) {
	super(num1, num2);
    }

    public void calculate() {
	double diff = num1 - num2;
	System.out.println("Difference = " + diff);

    }
}

class multiplication extends Arithmetic {
    multiplication(double num1, double num2) {
	super(num1, num2);

    }

    public void calculate() {
	double pro = num1 * num2;
	System.out.println("Product = " + pro);
    }
}

class division extends Arithmetic {
    division(double num1, double num2) {
	super(num1, num2);

    }

    public void calculate() {
	try {
	    double quo = num1 / num2;
	    System.out.println("Quotient = " + quo);
	} catch (ArithmeticException ae) {
	    System.out.println("Division by zero is not possible");
	}
    }
}

public class CalculatorDemo {

    public static void main(String[] args) throws IOException {
	double num1;
	double num2;
	int choice;
	InputStreamReader ist = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(ist);
	System.out.println("Enter number1: ");
	num1 = Double.parseDouble(br.readLine());
	System.out.println("Enter number2: ");
	num2 = Double.parseDouble(br.readLine());
	addition a = new addition(num1, num2);
	subtraction s = new subtraction(num1, num2);
	multiplication m = new multiplication(num1, num2);
	division d = new division(num1, num2);
	Arithmetic[] arr = {a,s,m,d};
	

	System.out.println("Select one:  \n 1.Addition \n 2.Subraction \n 3.Multiplication \n 4.Division");
	try {
	    choice = Integer.parseInt(br.readLine());
	    choice=choice-1;
	    arr[choice].calculate();
	} catch (ArrayIndexOutOfBoundsException z) {
	    System.out.println("Invalid choice");
	}

    }

}
