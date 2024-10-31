import java.io.Console;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; //Import the scanner class to read the text files

import java.util.ArrayList;
import java.util.List;

class HotlineNurse {
    public String name;
    private String phoneNumber;
    protected int employeeNumber;
    protected List<Patient> callQ;

    public HotlineNurse() {
        this.name = "";
        this.phoneNumber = "";
        this.employeeNumber = 0;
        this.callQ = new ArrayList<>();
    }

    public HotlineNurse(String name, String phoneNumber, int employeeNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.employeeNumber = employeeNumber;
        this.callQ = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name; // Update name
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String toString() {
        return String.format(
            "Nurse Info> Name: %s, Phone Number: %s, Employee Number: %d",
            getName(), getPhoneNumber(), getEmployeeNumber()
        );
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void directPatient() {
        Console prompter = System.console();
        String nextStep = prompter.readLine("What is the next step for the patient: ");  // Read a line of text from the user
        System.out.println("Sending next steps to the patient.");
    }

    private String getPatientPHN(String data){
        
        int i = 0;
        while( data.charAt(i) != ':'){
            i ++;
        }

        return data.substring(0, i);
    }

    private String getPatientCallSummary(String data){
        int i = 0;
        while(data.charAt(i) != ':'){
            i ++;
        }

        return data.substring(i + 1);
    }

    public void printHotlineQueue(){
        try{
            File callQueue = new File("call_summaries.txt");

            Scanner reader = new Scanner(callQueue);
            String data = reader.nextLine(); //Get the first line of the text file with the columns
            System.out.println(data);

            if(!reader.hasNextLine()){
                System.out.println("There are no patients waiting to call the nurse");
            }

            int i = 1;

            while(reader.hasNextLine()){
                data = reader.nextLine();
                System.out.println("Patient " + i+ " " + data);

                i ++;
            }
            reader.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found error");
            e.printStackTrace();
        }
        
    }

    public String getHotlineQueue(int patient){
        try{
            File callQueue = new File("call_summaries.txt");

            Scanner reader = new Scanner(callQueue);
            String data = reader.nextLine(); //Get the first line of the text file with the columns

            if(!reader.hasNextLine()){
                System.out.println("There are no patients waiting to call the nurse");
            }

            int i = 1;
            while(reader.hasNextLine()){ //Loop over all the patients in the call queue
                data = reader.nextLine();

                String phn = this.getPatientPHN(data);
                String callSummary = this.getPatientCallSummary(data);

                if(i == patient){
                    reader.close();
                    return data;
                }
                
                System.out.println("Patient " + i + " " + phn + ": " + callSummary);

                i ++;
            }


            reader.close();
            
        } catch (FileNotFoundException e){
            System.out.println("File not found error");
            e.printStackTrace();
            
        }

        return ":(";
    }

    public void acceptCall(int patientNumber){
        
        String patient = this.getHotlineQueue(patientNumber);

        System.out.println("You are on call with a patient " + patient);
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e){
            System.out.println("The call was interrupted");
            e.printStackTrace();
        }
        
        System.out.println("Call complete");

    }

    public void getPromptInput(){
        System.out.println("You are a Nurse");
        Console prompter = System.console();

        String nameInput = prompter.readLine("Enter your name: ");  // Read a line of text from the user
        setName(nameInput);

        String phoneNumberInput = prompter.readLine("Enter your phone number: ");  // Read a phone number input from the user
        setPhoneNumber(phoneNumberInput);
    }

    public static void main(String[] args) {
        HotlineNurse hotlineNurse = new HotlineNurse("Amir Abdullahi", "123-456-7890", 7777);

        // Print initial
        System.out.println("Hotline Nurse Information:");
        System.out.println(hotlineNurse.toString());

        // Update class
        hotlineNurse.setPhoneNumber("098-765-4321");
        hotlineNurse.setEmployeeNumber(6481);

        // Print updated class
        System.out.println("\nUpdated Hotline Nurse Information:");
        System.out.println(hotlineNurse.toString());
    }
}