public class ED_Managers {
    public String name;               // Public Name attribute
    private int employeeNumber;        // Private employee number
    private String emailAddress;       // Private email address
    private String phoneNumber;        // Private phone number

    // Constructor
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
        System.out.println("ED Manager Information:");
        System.out.println("Name: " + edManager.name);
        System.out.println("Employee Number: " + edManager.getEmployeeNumber());
        System.out.println("Email Address: " + edManager.getEmailAddress());
        System.out.println("Phone Number: " + edManager.getPhoneNumber());

        // Use methods
        edManager.adjustEDWaitlist();
        edManager.viewEDStatistics();
        edManager.autoScheduleStaffShifts();
        edManager.reorganizeAppointments();
        edManager.toggleWaitRoomCapacity();
    }
}
