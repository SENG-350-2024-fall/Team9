package MisterEd_System;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        //declare
        Patients patient1 = new Patients("John Doe", 30);

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();


        /*
        Amir - Prompt for patient - adds patient info and creates a patient class
        - the patient info gets passed off to triage
        - the triage returns hotline, Er or generalpractitioner
        - The Healthcare professional and patient are both notified
        
        Oliver - ConnecttoHotlinenurse
        Justin - GeneralPractitioner
        Elior - ER
        */
        
    }
}