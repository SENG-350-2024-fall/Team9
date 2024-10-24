import java.time.LocalDate;
class HotlineNurses {
    public static void main(String[] args) {
        HotlineNurse hotlineNurse = new HotlineNurse("Amir Abdullahi", "123-456-7890", 7777);

        // Print initial
        System.out.println("Hotline Nurse Information:");
        System.out.println("Name: " + hotlineNurse.name);
        System.out.println("Phone Number: " + hotlineNurse.getPhoneNumber());
        System.out.println("Personal Health Number: " + hotlineNurse.getEmployeeNumber());

        // Update class
        hotlineNurse.setPhoneNumber("098-765-4321");
        hotlineNurse.setEmployeeNumber(6481);

        // Print updated class
        System.out.println("\nHotline Nurse Information:");
        System.out.println("Name: " + hotlineNurse.name);
        System.out.println("Phone Number: " + hotlineNurse.getPhoneNumber());
        System.out.println("Employee Number: " + hotlineNurse.getEmployeeNumber());
    }

    static class HotlineNurse {
        public String name;
        private String phoneNumber;
        protected int employeeNumber;

        public HotlineNurse(String name, String phoneNumber, int employeeNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.employeeNumber = employeeNumber;
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

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    
        public int getEmployeeNumber() {
            return employeeNumber;
        }
    }
}
