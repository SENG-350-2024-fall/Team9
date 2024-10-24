import java.time.LocalDate;
import java.util.Scanner;

class Patients {
    public static void main(String[] args) {
        Patient patient = new Patient("John Paetkau", "123-456-7890", "email@example.com", LocalDate.of(1990, 1, 1), 6924);

        // Print initial
        System.out.println("Patient Information:");
        System.out.println("Name: " + patient.name);
        System.out.println("Phone Number: " + patient.getPhoneNumber());
        System.out.println("Email Address: " + patient.getEmailAddress());
        System.out.println("Birth Date: " + patient.getBirthDate());
        System.out.println("Personal Health Number: " + patient.getPersonalHealthNumber());

        // Update class
        patient.setPhoneNumber("098-765-4321");
        patient.setEmailAddress("email2@example.com");
        patient.setBirthDate(LocalDate.of(1999, 2, 3));
        patient.setPersonalHealthNumber(6481);

        // Print updated class
        System.out.println("\nUpdated Patient Information:");
        System.out.println("Name: " + patient.name);
        System.out.println("Phone Number: " + patient.getPhoneNumber());
        System.out.println("Email Address: " + patient.getEmailAddress());
        System.out.println("Birth Date: " + patient.getBirthDate());
        System.out.println("Personal Health Number: " + patient.getPersonalHealthNumber());
    }

    static class Patient {
        public String name;
        private String phoneNumber;
        private String emailAddress;
        private LocalDate  birthDate;
        protected int personalHealthNumber;

        public Patient() {
            this.name = "";
            this.phoneNumber = "";
            this.emailAddress = "";
            this.birthDate = LocalDate.of(1970, 1, 1);  // Default date (e.g., Jan 1, 1970)
            this.personalHealthNumber = 0;  // Default number
        }
     

        public Patient(String name, String phoneNumber, String emailAddress, LocalDate  birthDate, int personalHealthNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.birthDate = birthDate;
            this.personalHealthNumber = personalHealthNumber;
        }

        public void getPromptInput () {
            Scanner prompter = new Scanner(System.in);

            System.out.println("Enter your name: ");
            String name = prompter.nextLine();  // Read a line of text from the user
            setName(name);

            System.out.println("Enter your phone number: ");
            String phoneNumber = prompter.nextLine();  // Read a phone number input from the user
            setPhoneNumber(phoneNumber);

            System.out.println("Enter your email address: ");
            String emailAddress = prompter.nextLine();  // Read a email address input from the user
            setPhoneNumber(emailAddress);

            System.out.println("Enter your birth day year in the format YYYY: ");
            int birthYear = prompter.nextInt();
            System.out.println("Enter your birth day month in the format MM: ");
            int birthMonth = prompter.nextInt();
            System.out.println("Enter your birth day day in the format DD: ");
            int birthDay = prompter.nextInt();
            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
            setBirthDate(birthDate);

            System.out.println("Enter your personal health number in the format XXXX: ");
            int personalHealthNumber = prompter.nextInt();
            setPersonalHealthNumber(personalHealthNumber);
            
            prompter.close();
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
    
        public void setBirthDate(LocalDate  birthDate) {
            this.birthDate = birthDate;
        }
    
        public void setPersonalHealthNumber(int personalHealthNumber) {
            this.personalHealthNumber = personalHealthNumber;
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
    
        public LocalDate getBirthDate() {
            return birthDate;
        }
    
        public int getPersonalHealthNumber() {
            return personalHealthNumber;
        }
    }
}
