package MisterEd_System;
import java.time.LocalDate;
class Patients {
    public static void main(String[] args) {
        Patient patient = new Patient("John Susan", "123-456-7890", "email@example.com", LocalDate.of(1990, 1, 1), 6924);

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

        public Patient(String name, String phoneNumber, String emailAddress, LocalDate  birthDate, int personalHealthNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.birthDate = birthDate;
            this.personalHealthNumber = personalHealthNumber;
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
