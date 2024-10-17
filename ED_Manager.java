import java.time.LocalDate;
class ED_Manager {
    public static void main(String[] args) {
        ED_Manager ED_Manager = new ED_Manager("John Paetkau", "123-456-7890", "email@example.com",);

        // Print initial
        System.out.println("ED_Manager Information:");
        System.out.println("Name: " + ED_Manager.name);
        System.out.println("Phone Number: " + ED_Manager.getPhoneNumber());
        System.out.println("Email Address: " + ED_Manager.getEmailAddress());

        // Update class
        ED_Manager.setPhoneNumber("098-765-4321");
        ED_Manager.setEmailAddress("email2@example.com");

        // Print updated class
        System.out.println("ED_Manager Information:");
        System.out.println("Name: " + ED_Manager.name);
        System.out.println("Phone Number: " + ED_Manager.getPhoneNumber());
        System.out.println("Email Address: " + ED_Manager.getEmailAddress());


    static class ED_Manager {
        public String name;
        private String phoneNumber;
        private String emailAddress;

        public ED_Manager(String name, String phoneNumber, String emailAddress) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
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
    

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    
        public String getEmailAddress() {
            return emailAddress;
        }
    }
}
