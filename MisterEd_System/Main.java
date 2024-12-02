import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Console;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Heartbeat heartbeat = Heartbeat.getSingletonInstance(40000);
        (new Thread(heartbeat)).start();

        SanityCheck sanityCheck = SanityCheck.getSingletonInstance("https://ipinfo.io/json", 40000);
        (new Thread(sanityCheck)).start();

        Backup backup = Backup.getSingletonInstance("call_summaries.txt", "call_summaries_backup.txt");
        (new Thread(backup)).start();
        
        File csvED = new File("triageQueueED.csv");
        List<Patient> triageQueueED = new ArrayList<>();

        
        triageQueueED.add(new Patient("John Paetkau", "123-456-3456", "jonnny@example.com", LocalDate.of(1990, 1, 1), 1111, 8));
        triageQueueED.add(new Patient("Anna Mulcaster", "123-456-2234", "annnie@example.com", LocalDate.of(1990, 1, 1), 2212, 7));
        triageQueueED.add(new Patient("Nathan Streetwood", "123-456-3322", "nate@example.com", LocalDate.of(1990, 1, 1), 2231, 6));
        triageQueueED.add(new Patient("Rosa Drives", "123-456-6758", "rosie@example.com", LocalDate.of(1913, 1, 1), 8876, 6));
        
        List<Patient> triageQueueGP = new ArrayList<>();
        File csvGP = new File("triageQueueGP.csv");
        
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
            ResponsibilityChain.TriageHandler gpHandler = new ResponsibilityChain.GPHandler(csvGP);
            ResponsibilityChain.TriageHandler edHandler = new ResponsibilityChain.EDHandler(csvED);

            hnHandler.setNextHandler(gpHandler);
            gpHandler.setNextHandler(edHandler);
            edHandler.handleRequest(patient);

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
            
            String viewQueueGP = prompter.readLine("Would you like to view patients in queue? Enter Yes or No: ");
            if(viewQueueGP.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                TriageQueue.printTriageQueue(csvGP);
            }
            String adjustQueueGP = prompter.readLine("Would you like to move anyone to the front of the queue? Enter Yes or No: ");
            if (adjustQueueGP.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                TriageQueue.printTriageQueue(csvGP);
                
                String patientToMoveGP = prompter.readLine("Enter the personal health number of the patient to move to the front: ");
                int patientRow = -1;
                try {
                    
                    Scanner scanner = new Scanner(csvGP);
                    scanner.nextLine();
                    int rowIndex = 1;
                    
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] data = line.split(",");
                        
                            String phNumber = data[4];
                            
                            if (phNumber.equals(patientToMoveGP)) {
                                patientRow = rowIndex;
                                break;
                            }
                        rowIndex++;
                    }
                    scanner.close();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid personal health number entered. Please enter a valid number.");
                }
                if (patientRow != -1) {
                    TriageQueue.swapRows(csvGP, 1, patientRow);
                    System.out.println("Patient with health number " + patientToMoveGP + " has been moved to the front of the queue.");
                } else {
                    System.out.println("Patient not found in the queue.");
                }
            }
            String removePatientGP = prompter.readLine("Would you like to remove anyone from the queue? Enter Yes or No:");
            if(removePatientGP.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                TriageQueue.printTriageQueue(csvGP);
                String patientToRemoveGP = prompter.readLine("Enter the personal health number of the patient you would like to reomve: ");
                int patientRow = -1;
                try {
                    
                    Scanner scanner = new Scanner(csvGP);
                    scanner.nextLine();
                    int rowIndex = 1;
                    
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] data = line.split(",");
                        
                            String phNumber = data[4];
                            
                            if (phNumber.equals(patientToRemoveGP)) {
                                patientRow = rowIndex;
                                break;
                            }
                        rowIndex++;
                    }
                    scanner.close();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid personal health number entered. Please enter a valid number.");
                }
                if (patientRow != -1) {
                    TriageQueue.remove(csvGP, patientRow + 1);
                    System.out.println("Patient with health number " + patientToRemoveGP + " has been removed from the queue.");
                } else {
                    System.out.println("Patient not found in the queue.");
                }
            }
        } else if (userClassNumber == 4){ 
            ED_Manager edManager = new ED_Manager();

            edManager.getPromptInput();
            
            String viewQueueED = prompter.readLine("Would you like to view patients in queue? Enter Yes or No: ");
            if(viewQueueED.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                TriageQueue.printTriageQueue(csvED);
            }

            String adjustQueueED = prompter.readLine("Would you like to move anyone to the front of the queue? Enter Yes or No: ");
            if (adjustQueueED.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                TriageQueue.printTriageQueue(csvED);
                
                String patientToMoveED = prompter.readLine("Enter the personal health number of the patient to move to the front: ");
                int patientRow = -1;
                try {
                    
                    Scanner scanner = new Scanner(csvED);
                    scanner.nextLine();
                    int rowIndex = 1;
                    
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] data = line.split(",");
                        
                            String phNumber = data[4];
                            
                            if (phNumber.equals(patientToMoveED)) {
                                patientRow = rowIndex;
                                break;
                            }
                        rowIndex++;
                    }
                    scanner.close();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid personal health number entered. Please enter a valid number.");
                }
                if (patientRow != -1) {
                    TriageQueue.swapRows(csvED, 1, patientRow);
                    System.out.println("Patient with health number " + patientToMoveED + " has been moved to the front of the queue.");
                } else {
                    System.out.println("Patient not found in the queue.");
                }
            }
            String removePatientED = prompter.readLine("Would you like to remove anyone from the queue? Enter Yes or No:");
            if(removePatientED.toLowerCase().contains("yes")) {
                System.out.println("Current Queue:");
                TriageQueue.printTriageQueue(csvED);
                String patientToRemoveED = prompter.readLine("Enter the personal health number of the patient you would like to remove: ");
                int patientRow = -1;
                try {
                    
                    Scanner scanner = new Scanner(csvED);
                    scanner.nextLine();
                    int rowIndex = 1;
                    
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] data = line.split(",");
                        String phNumber = data[4];
                        
                        if (phNumber.equals(patientToRemoveED)) {
                            patientRow = rowIndex;
                            break;
                        }
                        rowIndex++;
                    }
                    scanner.close();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid personal health number entered. Please enter a valid number.");
                }
                if (patientRow != -1) {
                    TriageQueue.remove(csvED, patientRow + 1);
                    System.out.println("Patient with health number " + patientToRemoveED + " has been removed from the queue.");
                } else {
                    System.out.println("Patient not found in the queue.");
                }
            }
        } else {
            System.out.println("Invalid user class number, please retry.");
        }

        System.out.println("Please wait. Closing application.");

        backup.stopBackup();
        heartbeat.stopHeartbeat();
        sanityCheck.stopSanityCheck();
    }
}