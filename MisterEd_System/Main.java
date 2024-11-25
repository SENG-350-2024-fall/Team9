import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Console;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heartbeat heartbeat = Heartbeat.getSingletonInstance(40000);
        (new Thread(heartbeat)).start();

        SanityCheck sanityCheck = SanityCheck.getSingletonInstance("https://ipinfo.io/json", 40000);
        (new Thread(sanityCheck)).start();

        Backup backup = Backup.getSingletonInstance("call_summaries.txt", "call_summaries_backup.txt");
        (new Thread(backup)).start();
        
        List<Patient> triageQueueED = new ArrayList<>();
        
        triageQueueED.add(new Patient("John Paetkau", "123-456-3456", "jonnny@example.com", LocalDate.of(1990, 1, 1), 1111, 8));
        triageQueueED.add(new Patient("Anna Mulcaster", "123-456-2234", "annnie@example.com", LocalDate.of(1990, 1, 1), 2212, 7));
        triageQueueED.add(new Patient("Nathan Streetwood", "123-456-3322", "nate@example.com", LocalDate.of(1990, 1, 1), 2231, 6));
        triageQueueED.add(new Patient("Rosa Drives", "123-456-6758", "rosie@example.com", LocalDate.of(1913, 1, 1), 8876, 6));

        List<Patient> triageQueueGP = new ArrayList<>();
        
        triageQueueGP.add(new Patient("Jeff Paetkau", "123-456-7890", "jeffrey@example.com", LocalDate.of(1990, 3, 1), 4523, 5));
        triageQueueGP.add(new Patient("Abby Mulcaster", "123-456-7590", "abigail@example.com", LocalDate.of(1990, 1, 3), 8976, 4));
        triageQueueGP.add(new Patient("Nolan Streetwood", "123-456-8878", "nolan@example.com", LocalDate.of(1993, 1, 1), 2331, 3));
        triageQueueGP.add(new Patient("Ruby Drives", "123-456-0098", "ruby@example.com", LocalDate.of(1933, 1, 1), 8876, 3));

        MrEDNotifier mrEDNotifier = new MrEDNotifier();
        mrEDNotifier.attachAll(triageQueueED);
        mrEDNotifier.attachAll(triageQueueGP);
        mrEDNotifier.setState("A new Mr. ED app update is available.");

        Patient familyPrototype = new Patient("Prototype", "250-656-1120", "family@example.com", null, 0000, 7);
        Patient familyDaughter = (Patient)familyPrototype.clone();
        familyDaughter.setName("Ally Mulcaster");
        familyDaughter.setBirthDate(LocalDate.of(2008, 11, 1));
        familyDaughter.setPersonalHealthNumber(8805);

        Patient familySon = (Patient)familyPrototype.clone();
        familySon.setName("Adam Mulcaster");
        familySon.setBirthDate(LocalDate.of(2015, 1, 14));
        familySon.setPersonalHealthNumber(8806);

        Patient familyDad = (Patient)familyPrototype.clone();
        familyDad.setName("Andy Mulcaster");
        familyDad.setBirthDate(LocalDate.of(1975, 4, 1));
        familyDad.setPersonalHealthNumber(870);
        System.out.println("Family Prototyping:\n" + familyDad + familyDaughter + familySon);

        Console prompter = System.console();
        System.out.println("Please enter your user class number (1=Patient, 2=HN, 3 = GP, 4 = EDM): ");
        int userClassNumber = Integer.parseInt(prompter.readLine());

        if (userClassNumber == 1) {
            // Creates a patient object
            Patient patient = new Patient();

            patient.viewNearbyHospitals();

            // Prompt for patient to add their info  
            patient.getPromptInput();

            ResponsibilityChain.TriageHandler hnHandler = new ResponsibilityChain.HotlineNurseHandler();
            ResponsibilityChain.TriageHandler gpHandler = new ResponsibilityChain.GPHandler(triageQueueGP);
            ResponsibilityChain.TriageHandler edHandler = new ResponsibilityChain.EDHandler(triageQueueED);

            hnHandler.setNextHandler(gpHandler);
            gpHandler.setNextHandler(edHandler);
            hnHandler.handleRequest(patient);

        } else if (userClassNumber == 2){
            //Create a nurse object
            HotlineNurse hotlineNurse = new HotlineNurse();

            hotlineNurse.getPromptInput();
            String acceptCall = "yes";

            while(acceptCall.toLowerCase().equals("yes")){ 

                acceptCall = prompter.readLine("Would you like to accept a call? Enter Yes or No: ");
                
                if(acceptCall.toLowerCase().contains("yes")) { //If the nurse wants to accept a call then they are able to
                    System.out.println("\nPick the patient that you would like to call by entering their personal health number");
                    hotlineNurse.printHotlineQueue();
                    String patientNumber = prompter.readLine("Enter the personal health number to enter the call:\n");
                    boolean autoLogSetOn = hotlineNurse.acceptCall(Integer.parseInt(patientNumber));
                    hotlineNurse.directPatient();
                    hotlineNurse.sendPatientCallTranscript(autoLogSetOn);
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
            String adjustQueue = prompter.readLine("Would you like to move anyone to the front of the queue? Enter Yes or No: ");
            if (adjustQueue.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                for (Patient p : triageQueueGP) {
                    System.out.println(p);
                }
                
                // Ask the user for the personal health number of the patient to move
                String patientToMove = prompter.readLine("Enter the personal health number of the patient to move to the front: ");
                
                // Find the patient in the queue
                Patient patient = null;
                try {
                    int phNumberToMove = Integer.parseInt(patientToMove); // Convert input to int
                    for (Patient p : triageQueueGP) {
                        if (p.getPersonalHealthNumber() == phNumberToMove) {
                            patient = p;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid personal health number entered. Please enter a valid number.");
                }
                
                if (patient != null) {
                    // Remove the patient from their current position
                    triageQueueGP.remove(patient);
                    // Add the patient to the front of the queue
                    triageQueueGP.add(0, patient);
                    System.out.println("Patient with health number " + patient.getPersonalHealthNumber() + " has been moved to the front of the queue.");
                } else {
                    System.out.println("Patient not found in the queue.");
                }
            } else {
                System.out.println("No changes made to the queue.");
            }

        } else if (userClassNumber == 4){ 
            ED_Manager edManager = new ED_Manager();

            edManager.getPromptInput();
            
            String viewQueue = prompter.readLine("Would you like to view patients in queue? Enter Yes or No: ");
            if(viewQueue.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                for (Patient p : triageQueueED) {
                    System.out.println(p);
                }
            }

            /*
            edManager.adjustEDWaitlist();
            edManager.viewEDStatistics();
            edManager.reorganizeAppointments();
            edManager.toggleWaitRoomCapacity();
            */
        } else {
            System.out.println("Invalid user class number, please retry.");
        }

        System.out.println("Please wait. Closing application.");

        backup.stopBackup();
        heartbeat.stopHeartbeat();
        sanityCheck.stopSanityCheck();
    }
}