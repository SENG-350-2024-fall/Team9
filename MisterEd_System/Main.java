import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Mister ED!");
        Console prompter = System.console();
        System.out.println("Please enter your user class number (1=Patient, 2=HN, 3 = GP, 4 = EDM): ");
        int userClassNumber = Integer.parseInt(prompter.readLine());

        if (userClassNumber == 1) {
            // Creates a patient object
            Patient patient = new Patient();
            // Prompt for patient to add their info  
            patient.getPromptInput();
            // the system directs the patient based on their info
            if (patient.getSeverity() < 3) { // initial direction returns HN 
                System.out.println("You will need a hotline nurse, please proceed"); // The system notifies the patient
                patient.callNurseHotline();
            } 

            else if (patient.getSeverity() < 6) { // initial direction returns GP
                System.out.println("You will need a General practitioner, please proceed"); // The system notifies the patient
            } 
            
            else {  // initial direction returns ED
                System.out.println("You will need a visit to an emergency department, please proceed"); // The system notifies the patient
            } 
        } else if (userClassNumber == 2){
            //Create a nurse object
            HotlineNurse nurse = new HotlineNurse();

            nurse.getPromptInput();
        }
       
        /*
        Oliver - ConnecttoHotlinenurse
        Justin - GeneralPractitioner
        Elior - ED
        */
    }
}
