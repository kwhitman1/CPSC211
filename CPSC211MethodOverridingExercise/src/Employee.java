
public abstract class Employee {
    
	private String name;
    private int hoursWorked;
    
    public Employee(String name) {
    	this.name = name;
    	this.hoursWorked = 0;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void addHours(double hours) {
        this.hoursWorked += hours;
    }

    public int getHours() {
        return hoursWorked;
    }
    
    public void resetHours() {
    	this.hoursWorked= 0;   
    }

    public double calculatePay() {
    	return 0;
    }
}
