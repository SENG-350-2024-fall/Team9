public class GeneralPractitioners
 {
    public static void main(String[] args) {
        GeneralPractitioner generalPractitioner = new GeneralPractitioner("Susan", "123-456-7890", "email@example.com", 9391);

        // Print initial
        System.out.println("General Practitioner Information:");
        System.out.println("Name: " + generalPractitioner.name);
        System.out.println("Phone Number: " + generalPractitioner.getPhoneNumber());
        System.out.println("Employee Number: " + generalPractitioner.getEmployeeNumber());

        // Update class
        generalPractitioner.setPhoneNumber("098-765-4321");
        generalPractitioner.setEmailAddress("email2@example.com");
        generalPractitioner.setEmployeeNumber(6481);

        // Print updated class
        System.out.println("\nUpdated General Practitioner Information:");
        System.out.println("Name: " + generalPractitioner.name);
        System.out.println("Phone Number: " + generalPractitioner.getPhoneNumber());
        System.out.println("Email Address: " + generalPractitioner.getEmailAddress());
        System.out.println("Employee Number: " + generalPractitioner.getEmployeeNumber());
    }

    static class GeneralPractitioner {
        public String name;
        private String phoneNumber;
        private String emailAddress;
        private int employeeNumber;

        public GeneralPractitioner(String name, String phoneNumber, String emailAddress, int employeeNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.employeeNumber = employeeNumber;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public void setEmployeeNumber(int employeeNumber) {
            this.employeeNumber = employeeNumber;
        }
    

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    
        public String getEmailAddress() {
            return emailAddress;
        }
    
        public int getEmployeeNumber() {
            return employeeNumber;
        }
    }
}

