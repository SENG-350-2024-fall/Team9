import java.util.*;
import java.time.LocalDate;
import java.io.*;

// Main class: ResponsibilityChain
public class ResponsibilityChain {
    
    // Abstract Handler
    public abstract static class TriageHandler {
        protected TriageHandler nextHandler;

        public void setNextHandler(TriageHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public abstract void handleRequest(Patient patient);
    }

    // First Handler: Hotline Nurse
    public static class HotlineNurseHandler extends TriageHandler {
        @Override
        public void handleRequest(Patient patient) {
            if (patient.getSeverity() < 3) {
                System.out.println("You will need a hotline nurse, please proceed.");
                patient.callNurseHotline();
            } else if (nextHandler != null) {
                nextHandler.handleRequest(patient);
            }
        }
    }

    // Second Handler: General Practitioner
    public static class GPHandler extends TriageHandler {
        private List<Patient> triageQueueGP;

        public GPHandler(List<Patient> triageQueueGP) {
            this.triageQueueGP = triageQueueGP;
        }

        @Override
        public void handleRequest(Patient patient) {
            if (patient.getSeverity() < 6 && patient.getSeverity() > 2) {
                System.out.println("You will need a General practitioner, please proceed.");
                triageQueueGP.add(patient);
                triageQueueGP.sort(Comparator.comparingInt(Patient::getSeverity).reversed());
                int position = triageQueueGP.indexOf(patient) + 1;
                System.out.println("Your position in the queue is: #" + position);
                System.out.printf("You have %d patient(s) ahead of you.\n", position - 1);

                if (position - 1 == 1) {
                    System.out.println("Your estimated remaining wait time is: 1 day");
                } else if (position - 1 == 0) {
                    System.out.println("You have no patients ahead of you. You will be seen shortly!");
                } else {
                    System.out.printf("Your estimated remaining wait time is: %d days\n", (position - 1));
                }
            } else if (nextHandler != null) {
                nextHandler.handleRequest(patient);
            }
        }
    }

    // Third Handler: Emergency Department
    public static class EDHandler extends TriageHandler {

        private File csvED;

        public EDHandler(File csvED) {
        this.csvED = csvED;
        }

        @Override
        public void handleRequest(Patient patient) {
            if (patient.getSeverity() > 6) {
                System.out.println("You will need a visit to an emergency department, please proceed.");
                int position = TriageQueue.add(patient, csvED);
                System.out.println("Your position in the queue is: #" + position);
                System.out.printf("You have %d patient(s) ahead of you.\n", position - 1);
                System.out.printf("Your estimated remaining wait time is: %d mins\n", (position - 1) * 15);

                System.out.print("Do you want to leave the queue? Enter Yes or No: ");
                if (System.console().readLine().toLowerCase().contains("yes")) {
                    TriageQueue.remove(csvED);
                    System.out.println("You have been removed from the queue.");
                }
            }
        }
    }

    // Client Code
    public static void main(String[] args) {
        // Sample triage queues
        List<Patient> triageQueueED = new ArrayList<>();
        
        triageQueueED.add(new Patient("Jeff Paetkau", "123-456-7891", "jeffy@example.com", LocalDate.of(1990, 2, 1), 1711, 8));
        triageQueueED.add(new Patient("Anna Mulcaster", "123-456-7890", "annnie@example.com", LocalDate.of(1990, 1, 1), 2212, 7));
        triageQueueED.add(new Patient("Nathan Streetwood", "123-456-7890", "nate@example.com", LocalDate.of(1990, 1, 1), 2231, 6));
        triageQueueED.add(new Patient("Rosa Drives", "123-456-7890", "rosie@example.com", LocalDate.of(1913, 1, 1), 8876, 6));

        List<Patient> triageQueueGP = new ArrayList<>();
        
        triageQueueGP.add(new Patient("Jack Paetkau", "123-456-7880", "jacky@example.com", LocalDate.of(1990, 3, 1), 1191, 5));
        triageQueueGP.add(new Patient("Anna Mulcaster", "123-456-7890", "annnie@example.com", LocalDate.of(1990, 1, 1), 2212, 4));
        triageQueueGP.add(new Patient("Nathan Streetwood", "123-456-7890", "nate@example.com", LocalDate.of(1990, 1, 1), 2231, 3));
        triageQueueGP.add(new Patient("Rosa Drives", "123-456-7890", "rosie@example.com", LocalDate.of(1913, 1, 1), 8876, 3));

        File csvED = new File("triageQueueED.csv");
        // Set up handlers
        TriageHandler hotlineNurse = new HotlineNurseHandler();
        TriageHandler gpHandler = new GPHandler(triageQueueGP);
        TriageHandler edHandler = new EDHandler(csvED);

        // Chain the handlers
        hotlineNurse.setNextHandler(gpHandler);
        gpHandler.setNextHandler(edHandler);

        // Example patient
        Patient patient = new Patient("John Paetkau", "123-456-7890", "jonnny@example.com", LocalDate.of(1990, 1, 1), 1111, 4);
        hotlineNurse.handleRequest(patient);
    }
}
