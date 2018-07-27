import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

//@Gopika V
//27-07-2018
//Question:
//Develop java application to compute income tax of employee based on annual income.
//Create class EmplyeeVo which contain instance variable empid, empname, annualincome, incometax. Create setter and getter methods 
//Override the following methods:
//1)	 toString method which returns all the employee details.
//2)	Hashcode method to return the hashcode of the data
//3)	Equals method to compare the object
//4)	Add the parameter constructor to add data
 //Create class EmplyeeBo which contains instance method calincomeTax (), return type is void, argument is EmplyeeVo. Take the annualincome for emplyeeVo and compute income tax and store it back to emplyeeVo.
//Create class Emplyeesort implement comparator interface and override compareTo method do sort the data on incometax in descending order.
//Create an EmplyeeMain with main method and do the following
//1)	Accept no of employees
//2)	Create an array of EmplyeeVo based on number of employees
//3)	Read empid, empname, annualincome and calculate income tax calling calincomeTax method of EmplyeeBo object.
//4)	Display the data of the all the employee
//5)	Sort the data of the employee based on income tax and re print.



class EmplyeeVo
{
    int empid;
    String empname;
    double annualincome;
    double incometax;
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }
    public double getAnnualincome() {
        return annualincome;
    }
    public void setAnnualincome(double annualincome) {
        this.annualincome = annualincome;
    }
    public double getIncometax() {
        return incometax;
    }
    public void setIncometax(double incometax) {
        this.incometax = incometax;
    }
    @Override
    public String toString() {
        
        return this.empid+"    "+this.empname+"    "+this.annualincome+"          "+this.incometax;
    }
   
    @Override
    public int hashCode() {
	final int prime = 66;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(annualincome);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + empid;
	result = prime * result + ((empname == null) ? 0 : empname.hashCode());
	temp = Double.doubleToLongBits(incometax);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	EmplyeeVo other = (EmplyeeVo) obj;
	if (Double.doubleToLongBits(annualincome) != Double.doubleToLongBits(other.annualincome))
	    return false;
	if (empid != other.empid)
	    return false;
	if (empname == null) {
	    if (other.empname != null)
		return false;
	} else if (!empname.equals(other.empname))
	    return false;
	if (Double.doubleToLongBits(incometax) != Double.doubleToLongBits(other.incometax))
	    return false;
	return true;
    }
   
  
    public EmplyeeVo(int empid, String empname, double annualincome, double incometax) {
	super();
	this.empid = empid;
	this.empname = empname;
	this.annualincome = annualincome;
	this.incometax = incometax;
    }
}
class EmplyeeBo
{
    public void calincomeTax(EmplyeeVo e)
    {
	double incometax=e.getAnnualincome()*0.4;
	e.setIncometax(incometax);
    }
}
class Emplyeesort implements Comparator
{

    @Override
    public int compare(Object o1, Object o2) {
	 EmplyeeVo e1=(EmplyeeVo)o1;
	 EmplyeeVo e2=(EmplyeeVo)o2;
	 int val=0;
	 if(e1.getIncometax()<e2.getIncometax())
		 val=1;
	 else
		 if(e1.getIncometax()>e2.getIncometax())
			 val=-1;
		 else
			 val=0;
		return val;
    }

    
}
public class EmplyeeMain {

    public static void main(String[] args) throws  IOException {
	InputStreamReader ist = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(ist);
	System.out.println("Enter number of employees ");
	int n = Integer.parseInt(br.readLine());
	EmplyeeVo e[]=new EmplyeeVo[n];
	
	EmplyeeBo b=new EmplyeeBo();
	for(int i=0;i<n;i++)
	{
	System.out.println("Enter details of employee no. ");

	System.out.println("Enter id :");
	
	int empidd=Integer.parseInt(br.readLine());
	System.out.println("Enter name :");
	String ename=br.readLine();
	System.out.println("Enter annual income :");
	double annual=Double.parseDouble(br.readLine());
	e[i]=new EmplyeeVo(empidd, ename, annual, 0);
	b.calincomeTax(e[i]);
	}
	 System.out.print("Id    "  );
	    System.out.print("Name  ");
	    System.out.print("Annual Income  ");
	    System.out.println("Income Tax");
	    
	for(int j=0;j<n;j++)
	{
	   
	    System.out.println(e[j]);
	    
	}
	    
	

    }

}
