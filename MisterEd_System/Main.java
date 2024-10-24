import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Mister ED!");
        Scanner prompter = new Scanner(System.in);
        System.out.println("Please enter your user class number (1=Patient, 2=HN, 3 = GP, 4 = EDM): ");
        int userClassNumber = prompter.nextInt();

        if (userClassNumber == 1) {
            // Creates a patient object
            Patient patient = new Patient();
            // Prompt for patient to add their info  
            patient.getPromptInput();
        }

        /*
        Amir - 
        - the patient info gets passed off to triage
        - the triage returns hotline, Er or generalpractitioner
        - The Healthcare professional and patient are both notified
        
        Oliver - ConnecttoHotlinenurse
        Justin - GeneralPractitioner
        Elior - ER
        */
        
        prompter.close();
    }
}
