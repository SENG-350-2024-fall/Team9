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

        @SuppressWarnings("unused")
        private File csvHN;
        private TriageHandler nextHandler;

        public HotlineNurseHandler(File csvHN, TriageHandler nextHandler) {
            this.csvHN = null;
            this.nextHandler = nextHandler;
        }

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
 
        private File csvGP;
        private TriageHandler nextHandler;

        public GPHandler(File csvGP, TriageHandler nextHandler) {
            this.csvGP = csvGP;
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(Patient patient) {
            if (patient.getSeverity() < 7 && patient.getSeverity() > 2) {
                System.out.println("You will need a General practitioner, please proceed.");
                int position = TriageQueue.add(patient, csvGP);
                System.out.println("Your position in the queue is: #" + position);
                System.out.printf("You have %d patient(s) ahead of you.\n", position - 1);
                System.out.printf("Your estimated remaining wait time is: %d mins\n", (position - 1) * 15);

                System.out.print("Do you want to leave the queue? Enter Yes or No: ");
                if (System.console().readLine().toLowerCase().contains("yes")) {
                    System.out.println(position);
                    TriageQueue.remove(csvGP, position);
                    System.out.println("You have been removed from the queue.");
                }
            } else if (nextHandler != null) {
                nextHandler.handleRequest(patient);
            }
        }
    }

    // Third Handler: Emergency Department
    public static class EDHandler extends TriageHandler {

        private File csvED;
        private TriageHandler nextHandler;

        public EDHandler(File csvED, TriageHandler nextHandler) {
            this.csvED = csvED;
            this.nextHandler = nextHandler;
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
                    TriageQueue.remove(csvED, position);
                    System.out.println("You have been removed from the queue.");
                }
            } else if (nextHandler != null) {
                nextHandler.handleRequest(patient);
            }
        }
    }

    // Client Code
    public static void main(String[] args) {
        // Sample triage queues
        File csvED = new File("triageQueueED.csv");
        File csvGP = new File("triageQueueGP.csv");
        // Set up handlers
        TriageHandler edHandler = new EDHandler(csvED, null);
        TriageHandler gpHandler = new GPHandler(csvGP, edHandler);
        TriageHandler hotlineNurse = new HotlineNurseHandler(null, gpHandler);

        // Example patient
        Patient patient = new Patient("John Paetkau", "123-456-7890", "jonnny@example.com", LocalDate.of(1990, 1, 1), 1111, 4);
        hotlineNurse.handleRequest(patient);
    }
}
