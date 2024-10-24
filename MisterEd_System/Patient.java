import java.time.LocalDate;
import java.util.Scanner;

class Patient {
    public String name;
    private String phoneNumber;
    private String emailAddress;
    private LocalDate  birthDate;
    protected int personalHealthNumber;   
    private int severity;

    public Patient() {
        this.name = "";
        this.phoneNumber = ""; 
        this.emailAddress = "";
        this.birthDate = null; 
        this.personalHealthNumber = 0;
    }
    
    public Patient(String name, String phoneNumber, String emailAddress, LocalDate  birthDate, int personalHealthNumber, int severity) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
        this.personalHealthNumber = personalHealthNumber;
    }

    public void getPromptInput () {
        Scanner prompter = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String nameInput = prompter.nextLine();  // Read a line of text from the user
        setName(nameInput);

        System.out.println("Enter your phone number: ");
        String phoneNumberInput = prompter.nextLine();  // Read a phone number input from the user
        setPhoneNumber(phoneNumberInput);

        System.out.println("Enter your email address: ");
        String emailAddressInput = prompter.nextLine();  // Read a email address input from the user
        setEmailAddress(emailAddressInput);

        System.out.println("Enter your birth day year in the format YYYY: ");
        int birthYearInput = prompter.nextInt();
        System.out.println("Enter your birth day month in the format MM: ");
        int birthMonthInput = prompter.nextInt();
        System.out.println("Enter your birth day day in the format DD: ");
        int birthDayInput = prompter.nextInt();
        LocalDate birthDateInput = LocalDate.of(birthYearInput, birthMonthInput, birthDayInput);
        setBirthDate(birthDateInput);

        System.out.println("Enter your personal health number in the format XXXX: ");
        int personalHealthNumberInput = prompter.nextInt();
        setPersonalHealthNumber(personalHealthNumberInput);

        System.out.println("Enter the severity of your conditon: ");
        int severityInput = prompter.nextInt();
        setSeverity(severityInput);
        
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

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPersonalHealthNumber(int personalHealthNumber) {
        this.personalHealthNumber = personalHealthNumber;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String toString() {
        return String.format(
            "Patient Info> Name: %s, Phone Number: %s, Email: %s, Birth Date: %s, Personal Health Number: %d, Severity: %d",
            getName(), getPhoneNumber(), getEmailAddress(), getBirthDate(), getPersonalHealthNumber(), getSeverity()
        );
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

    public int getSeverity() {
        return severity;
    }

    public static void main(String[] args) {
        Patient patient = new Patient("John Paetkau", "123-456-7890", "email@example.com", LocalDate.of(1990, 1, 1), 6924, 4);

        // Print initial
        System.out.println("Patient Information:");
        System.out.println(patient.toString());

        // Update class
        patient.setPhoneNumber("098-765-4321");
        patient.setEmailAddress("email2@example.com");
        patient.setBirthDate(LocalDate.of(1999, 2, 3));
        patient.setPersonalHealthNumber(6481);

        // Print updated class
        System.out.println("\nUpdated Patient Information:");
        System.out.println(patient.toString());
    }
}
