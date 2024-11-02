import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Console;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heartbeat heartbeat = new Heartbeat(20000);
        (new Thread(heartbeat)).start();

        SanityCheck sanityCheck = new SanityCheck("https://ipinfo.io/json", 30000);
        (new Thread(sanityCheck)).start();

        Backup backup = new Backup("call_summaries.txt", "call_summaries_backup.txt");
        (new Thread(backup)).start();

        Console prompter = System.console();
        System.out.println("Please enter your user class number (1=Patient, 2=HN, 3 = GP, 4 = EDM): ");
        int userClassNumber = Integer.parseInt(prompter.readLine());
        
        List<Patient> triageQueueED = new ArrayList<>();
        
        triageQueueED.add(new Patient("John Paetkau", "123-456-7890", "jonnny@example.com", LocalDate.of(1990, 1, 1), 1111, 8));
        triageQueueED.add(new Patient("Anna Mulcaster", "123-456-7890", "annnie@example.com", LocalDate.of(1990, 1, 1), 2212, 7));
        triageQueueED.add(new Patient("Nathan Streetwood", "123-456-7890", "nate@example.com", LocalDate.of(1990, 1, 1), 2231, 6));
        triageQueueED.add(new Patient("Rosa Drives", "123-456-7890", "rosie@example.com", LocalDate.of(1913, 1, 1), 8876, 6));

        List<Patient> triageQueueGP = new ArrayList<>();
        
        triageQueueGP.add(new Patient("John Paetkau", "123-456-7890", "jonnny@example.com", LocalDate.of(1990, 1, 1), 1111, 5));
        triageQueueGP.add(new Patient("Anna Mulcaster", "123-456-7890", "annnie@example.com", LocalDate.of(1990, 1, 1), 2212, 4));
        triageQueueGP.add(new Patient("Nathan Streetwood", "123-456-7890", "nate@example.com", LocalDate.of(1990, 1, 1), 2231, 3));
        triageQueueGP.add(new Patient("Rosa Drives", "123-456-7890", "rosie@example.com", LocalDate.of(1913, 1, 1), 8876, 3));

        if (userClassNumber == 1) {
            // Creates a patient object
            Patient patient = new Patient();

            patient.viewNearbyHospitals();


            // Prompt for patient to add their info  
            patient.getPromptInput();

            ResponsibilityChain.TriageHandler hotlineNurse = new ResponsibilityChain.HotlineNurseHandler();
            ResponsibilityChain.TriageHandler gpHandler = new ResponsibilityChain.GPHandler(triageQueueGP);
            ResponsibilityChain.TriageHandler edHandler = new ResponsibilityChain.EDHandler(triageQueueED);

            hotlineNurse.setNextHandler(gpHandler);
            gpHandler.setNextHandler(edHandler);
            hotlineNurse.handleRequest(patient);

        } else if (userClassNumber == 2){
            //Create a nurse object
            HotlineNurse nurse = new HotlineNurse();

            nurse.getPromptInput();
            String acceptCall = "yes";

            while(acceptCall.toLowerCase().equals("yes")){ 

                acceptCall = prompter.readLine("Would you like to accept a call? Enter Yes or No:");
                
                if(acceptCall.toLowerCase().contains("yes")) { //If the nurse wants to accept a call then they are able to
                    System.out.println("Pick the patient that you would like to call by entering their number");
                    nurse.printHotlineQueue();
                    String patientNumber = prompter.readLine("Pick number:\n");

                    nurse.acceptCall(Integer.parseInt(patientNumber));
                    nurse.directPatient();
                }
            }

        } else if (userClassNumber == 3){
            //Create a General Practitioner Object
            GeneralPractitioner generalPractitioner = new GeneralPractitioner();

            generalPractitioner.getPromptInput();
            
            String viewQueue = prompter.readLine("Would you like to view patients in queue? Enter Yes or No: ");
            if(viewQueue.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                for (Patient p : triageQueueGP) {
                    System.out.println(p);
                }
            }
        }

        backup.stopBackup();
        heartbeat.stopHeartbeat();
        sanityCheck.stopSanityCheck();
        
        /*
        Oliver - ConnecttoHotlinenurse
        Justin - GeneralPractitioner
        Elior - ED
        */
    }
}
