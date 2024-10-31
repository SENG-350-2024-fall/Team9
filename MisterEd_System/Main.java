import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Console;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Mister ED!");
        Console prompter = System.console();
        System.out.println("Please enter your user class number (1=Patient, 2=HN, 3 = GP, 4 = EDM): ");
        int userClassNumber = Integer.parseInt(prompter.readLine());
        
        List<Patient> triageQueue = new ArrayList<>();

        triageQueue.add(new Patient("John Paetkau", "123-456-7890", "jonnny@example.com", LocalDate.of(1990, 1, 1), 1111, 8));
        triageQueue.add(new Patient("Anna Mulcaster", "123-456-7890", "annnie@example.com", LocalDate.of(1990, 1, 1), 2212, 7));
        triageQueue.add(new Patient("Nathan Streetwood", "123-456-7890", "nate@example.com", LocalDate.of(1990, 1, 1), 2231, 6));
        triageQueue.add(new Patient("Rosa Drives", "123-456-7890", "rosie@example.com", LocalDate.of(1913, 1, 1), 8876, 6));

        if (userClassNumber == 1) {
            // Creates a patient object
            Patient patient = new Patient();

            String viewWaitTimes = prompter.readLine("Would you like to view local hospitals? Enter Yes or No: ");
            if(viewWaitTimes.toLowerCase().contains("yes")) {
                patient.viewNearbyHospitals();
            }

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
                triageQueue.add(patient);
                triageQueue.sort(Comparator.comparingInt(Patient::getSeverity).reversed());
                int position = triageQueue.indexOf(patient) + 1;
                System.out.println("Your postion in the queue is: #" + position);
                System.out.printf("You have %d patient(s) ahead of you.", position-1);
            } 
        }
       
        /*
        Oliver - ConnecttoHotlinenurse
        Justin - GeneralPractitioner
        Elior - ED
        */
    }
}
