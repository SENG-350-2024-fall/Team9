import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.io.Console;
import java.util.Random;

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
        System.out.println("You are a Patient");
        Console prompter = System.console();

        String nameInput = prompter.readLine("Enter your name: ");  // Read a line of text from the user
        setName(nameInput);

        String phoneNumberInput = prompter.readLine("Enter your phone number: ");  // Read a phone number input from the user
        setPhoneNumber(phoneNumberInput);

        String emailAddressInput = prompter.readLine("Enter your email address: ");  // Read a email address input from the user
        setEmailAddress(emailAddressInput);

        int birthYearInput = Integer.parseInt(prompter.readLine("Enter your birth day year in the format YYYY: "));
        int birthMonthInput = Integer.parseInt(prompter.readLine("Enter your birth day month in the format MM: "));
        int birthDayInput = Integer.parseInt(prompter.readLine("Enter your birth day day in the format DD: "));
        LocalDate birthDateInput = LocalDate.of(birthYearInput, birthMonthInput, birthDayInput);
        setBirthDate(birthDateInput);

        int personalHealthNumberInput = Integer.parseInt(prompter.readLine("Enter your personal health number in the format XXXX: "));
        setPersonalHealthNumber(personalHealthNumberInput);

        int severityInput = Integer.parseInt(prompter.readLine("Enter the severity of your conditon between 0-10: "));
        setSeverity(severityInput);
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

    public void callNurseHotline() {
        provideCallSummary();
        System.out.println("You are now on call with your Hotline Nurse, please try to speak clearly (:"); 
        System.out.println("Your Hotline Nurse call has completed."); 
        Random random = new Random();
        if(random.nextBoolean()) {
            System.out.println("You have been directed to GP");
        } 

        else {
            System.out.println("You have been directed to ED");
        }
        
        System.out.println("Please follow their direction and have a nice day!");
    }

    public void provideCallSummary() {
        Console prompter = System.console();
        String callSummary = prompter.readLine("Briefly summarize the reason for your Nurse Hotline call if desired: ");  // Read a call summary input from the user

        try (FileWriter writer = new FileWriter("call_summaries.txt", true)) { // 'true' to append to the file
            writer.write(personalHealthNumber + ":" + callSummary + System.lineSeparator()); // Write summary and add a new line
            System.out.println("Call summary saved.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the call summary.");
            e.printStackTrace();
        }
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
