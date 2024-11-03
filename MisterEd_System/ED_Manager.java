import java.io.Console;

public class ED_Manager {
    public String name;               // Public Name attribute
    private int employeeNumber;        // Private employee number
    private String emailAddress;       // Private email address
    private String phoneNumber;        // Private phone number

    

    public ED_Manager() {
        this.name = "";
        this.employeeNumber = 0;
        this.emailAddress = "";
        this.phoneNumber = "";
    }

    public ED_Manager(String name, int employeeNumber, String emailAddress, String phoneNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters for private fields
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String toString() {
        return String.format(
            "ED Manager Info> Name: %s, Employee Number: %s, Email: %s, Phone Number: %s\n",
            name, getEmployeeNumber(), getEmailAddress(), getPhoneNumber()
        );
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Methods from the diagram
    public void adjustEDWaitlist() {
        // Implementation for adjusting ED waitlist
        System.out.println("Adjusting ED waitlist...");
    }

    public void viewEDStatistics() {
        // Implementation for viewing ED statistics
        System.out.println("Viewing ED statistics...");
    }

    public void autoScheduleStaffShifts() {
        // Implementation for auto-scheduling staff shifts
        System.out.println("Auto-scheduling staff shifts...");
    }

    public void reorganizeAppointments() {
        // Implementation for reorganizing appointments
        System.out.println("Reorganizing appointments...");
    }

    public void toggleWaitRoomCapacity() {
        // Implementation for toggling wait room capacity
        System.out.println("Toggling wait room capacity...");
    }

    // Main method for testing
    public static void main(String[] args) {
        ED_Manager edManager = new ED_Manager("John Paetkau", 12345, "email@example.com", "123-456-7890");

        // Print initial information
        System.out.print(edManager);

        // Use methods
        
        edManager.adjustEDWaitlist();
        edManager.viewEDStatistics();
        edManager.autoScheduleStaffShifts();
        edManager.reorganizeAppointments();
        edManager.toggleWaitRoomCapacity();
        
        
    }

    public void getPromptInput(){
        System.out.println("You are a Emergency Department Manager");
        Console prompter = System.console();

        String nameInput = prompter.readLine("Enter your name: ");
        setName(nameInput);

        String phoneNumberInput = prompter.readLine("Enter your phone number: ");
        setPhoneNumber(phoneNumberInput);
        
        String emailInput = prompter.readLine("Enter your email: ");
        setEmailAddress(emailInput);

        int employeeNumberInput = Integer.parseInt(prompter.readLine("Enter your employee number in the format XXXX: "));
        setEmployeeNumber(employeeNumberInput);
    }
}
