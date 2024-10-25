import java.time.LocalDate;

class HotlineNurse {
    public String name;
    private String phoneNumber;
    protected int employeeNumber;

    public HotlineNurse() {
        this.name = "";
        this.phoneNumber = "";
        this.employeeNumber = 0;
    }

    public HotlineNurse(String name, String phoneNumber, int employeeNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.employeeNumber = employeeNumber;
    }

    public void setName(String name) {
        this.name = name; // Update name
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String toString() {
        return String.format(
            "Nurse Info> Name: %s, Phone Number: %s, Employee Number: %d",
            getName(), getPhoneNumber(), getEmployeeNumber()
        );
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public static void main(String[] args) {
        HotlineNurse hotlineNurse = new HotlineNurse("Amir Abdullahi", "123-456-7890", 7777);

        // Print initial
        System.out.println("Hotline Nurse Information:");
        System.out.println(hotlineNurse.toString());

        // Update class
        hotlineNurse.setPhoneNumber("098-765-4321");
        hotlineNurse.setEmployeeNumber(6481);

        // Print updated class
        System.out.println("\nUpdated Hotline Nurse Information:");
        System.out.println(hotlineNurse.toString());
    }
}