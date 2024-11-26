import java.io.*; 
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.util.Scanner; //Import the scanner class to read the text files
import java.util.ArrayList;
import java.util.List;

interface Nurse {
    void performDuties();
}

class HotlineNurse implements Nurse {
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

    @Override
    public void performDuties() {
        System.out.println("Performing basic hotline nurse duties.");
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
        System.console().readLine("What is the next step for the patient: ");  // Read a line of text from the user
        System.out.println("Sending next steps to the patient.");
    }

    public boolean autoLogPatientCall() {
        String autoLogCall = System.console().readLine("Do you and the patient agree to autolog this call? Enter Yes or No: "); // Read a line of text from the user
        if(autoLogCall.toLowerCase().contains("yes")) {
            System.out.println("Auto log is on.");
            return true;
        }
        System.out.println("Auto log is off.");
        return false;
    }

    public void sendPatientCallTranscript(boolean autoLogSetOn) {
        if(autoLogSetOn) {
            System.out.println("\nPatient call transcript destination options:");
            System.out.println("1: Royal Jubilee Hospital ED");
            System.out.println("2: Saanich Peninsula Hospital ED");
            System.out.println("3: Cowichan District Hospital ED");
            System.out.println("4: Victoria General Hospital ED");
            int option = -1;
            while (option < 1 || option > 4) {
                String input = System.console().readLine("Enter the number of the hospital to send the autologged patient call transcript to: ");
                try {
                    option = Integer.parseInt(input);
                    if (option < 1 || option > 4) {
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            } 
            System.out.println("Sending autologged patient call transcript to desired hospital and deptartment.");
        }
    }

    public void printHotlineQueue(){
        try{
            File callQueue = new File("call_summaries.txt");

            Scanner reader = new Scanner(callQueue);
            String data = reader.nextLine(); //Get the first line of the text file with the columns
            System.out.println(data);

            if(!reader.hasNextLine()){
                System.out.println("There are no patients waiting to call the nurse. Please try again later.");
                System.exit(0);
            }

            int i = 1;

            while(reader.hasNextLine()){
                data = reader.nextLine();
                System.out.println("Patient "+ i + " " + data);

                i ++;
            }
            reader.close();
        } catch(FileNotFoundException e){
            System.out.println("Sorry, patient file not found error. Please try again later.");
            e.printStackTrace();
            System.exit(0);
        }
        
    }

    public String getHotlineQueue(int patient){
        String callQueueFilePath = "call_summaries.txt";  // Path to the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(callQueueFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) { //Loop over all the patients in the call queue
                if (line.contains(Integer.toString(patient))) {
                    reader.close();
                    return line;
                }
            }
        } catch (IOException e){
            System.out.println("Sorry, patient file not found error. Please try again later.");
            e.printStackTrace();
            System.exit(0);
        }

        return ":(";
    }

    public boolean acceptCall(int patientNumber){
        
        String patient = this.getHotlineQueue(patientNumber);
        boolean autoLogSetOn = autoLogPatientCall();
        System.out.println("You are on call with Patient " + patient);
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e){
            System.out.println("The call was interrupted");
            e.printStackTrace();
        }
        
        System.out.println("Call complete");
        RewriteFileSkippingLine(patientNumber);
        return autoLogSetOn;
    }

    public void RewriteFileSkippingLine(int skipLine) {
        String inputFilePath = "call_summaries.txt";  // Path to the input file
        String outputFilePath = "call_summaries_rewrite.txt"; // Path to the output file

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the line if it contains skipLine
                if (line.contains(Integer.toString(skipLine))) {
                    continue;
                }
                // Write the line to the output file
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Sorry, patient file not found error. Please try again later.");
            e.printStackTrace();
            System.exit(0);
        }

        // Optional: Replace the original file with the updated file
        File originalFile = new File(inputFilePath);
        File newFile = new File(outputFilePath);
        if (originalFile.delete()) {
            newFile.renameTo(originalFile);
        }
    }

    public void getPromptInput(){
        System.out.println("You are a Nurse");
        Console prompter = System.console();

        String nameInput = prompter.readLine("Enter your name: ");  // Read a line of text from the user
        setName(nameInput);

        String phoneNumberInput = prompter.readLine("Enter your phone number: ");  // Read a phone number input from the user
        setPhoneNumber(phoneNumberInput);
        
        int employeeNumberInput = Integer.parseInt(prompter.readLine("Enter your employee number in the format XXXX: "));
        setEmployeeNumber(employeeNumberInput);
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