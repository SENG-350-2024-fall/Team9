import java.time.LocalDate;
class HotlineNurse {
    public static void main(String[] args) {
        HotlineNurse hotlineNurse = new HotlineNurse("Amir Abdullahi", "123-456-7890", "email@example.com", LocalDate.of(1990, 7, 1), 7777);

        // Print initial
        System.out.println("Hotline Nurse Information:");
        System.out.println("Name: " + hotlineNurse.name);
        System.out.println("Phone Number: " + hotlineNurse.getPhoneNumber());
        System.out.println("Email Address: " + hotlineNurse.getEmailAddress());
        System.out.println("Personal Health Number: " + hotlineNurse.getEmployeeNumber());

        // Update class
        patient.setPhoneNumber("098-765-4321");
        patient.setEmailAddress("email2@example.com");
        patient.setEmployeeNumber(6481);

        // Print updated class
        System.out.println("\nHotline Nurse Information:");
        System.out.println("Name: " + hotlineNurse.name);
        System.out.println("Phone Number: " + hotlineNurse.getPhoneNumber());
        System.out.println("Employee Number: " + hotlineNurse.getEmployeeNumber());
    }

    static class HotlineNurse {
        public String name;
        private String phoneNumber;
        protected int employeeNumber;

        public HotlineNurse(String name, String phoneNumber, String emailAddress, int employeeNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.employeeNumber = employeeNumber;
        }

        public void setName(String name) {
            this.name = name; // Update name
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    
        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }
    
        public void setBirthDate(LocalDate  birthDate) {
            this.birthDate = birthDate;
        }
    
        public void setEmployeeNumber(int EmployeeNumber) {
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
