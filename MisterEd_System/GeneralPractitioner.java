import java.io.Console;

class GeneralPractitioner {
    public String name;
    private String phoneNumber;
    private String emailAddress;
    private int employeeNumber;


    public GeneralPractitioner() {
        this.name = "";
        this.phoneNumber = "";
        this.emailAddress = "emailAddress";
        this.employeeNumber = 0;
    }

    public GeneralPractitioner(String name, String phoneNumber, String emailAddress, int employeeNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.employeeNumber = employeeNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void getPromptInput(){
        System.out.println("You are a General Practitioner");
        Console prompter = System.console();

        String nameInput = prompter.readLine("Enter your name: ");
        setName(nameInput);

        String phoneNumberInput = prompter.readLine("Enter your phone number: ");
        setPhoneNumber(phoneNumberInput);
        
        String emailInput = prompter.readLine("Enter your email: ");
        setEmailAddress(emailInput);

        int employeeNumberInput = Integer.parseInt(prompter.readLine("Enter your personal health number in the format XXXX: "));
        setEmployeeNumber(employeeNumberInput);
    }
}

