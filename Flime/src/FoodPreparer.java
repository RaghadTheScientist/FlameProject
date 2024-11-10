


public class FoodPreparer {
      private int FoodPId;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private double salary;
    
  public FoodPreparer(int FoodPId, String phoneNumber, String firstName, String lastName, double salary) {
        this.FoodPId = FoodPId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Getters and setters
    public int getPreparerId() {
        return FoodPId;
    }

    public void setPreparerId(int FoodPId) {
        this.FoodPId = FoodPId;
    }

    public int getFoodPId() {
        return FoodPId;
    }

    public void setFoodPId(int FoodPId) {
        this.FoodPId = FoodPId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
