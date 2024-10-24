import java.util.ArrayList;
import java.util.List;

public class MrEDSystem{

    protected List<String> waitlist;
    protected List<Integer> waitroom_capacities;
    protected List<Integer> average_wait_lengths;
    protected List<String> hospital_employees;
    protected List<String> hospitals;

    public MrEDSystem(){
        waitlist = new ArrayList<String>();
        waitroom_capacities = new ArrayList<Integer>();
        average_wait_lengths = new ArrayList<Integer>();
        hospital_employees = new ArrayList<String>();
        hospitals = new ArrayList<String>();
    }

    public List<String> getWaitlist(){
        return this.waitlist;
    }

    public List<Integer> getWaitroomCapacities(){
        return this.waitroom_capacities;
    }

    public List<Integer> getAverageWaitLengths(){
        return this.average_wait_lengths;
    }

    public List<String> getHospitalEmployees(){
        return this.hospital_employees;
    }

    public List<String> getHospitals(){
        return this.hospitals;
    }

    public void addPatientToWaitlist(String patient){
        this.waitlist.add(patient);
    }

    public void addToWaitroomCapacities(int capacity){
        this.waitroom_capacities.add(capacity);
    }

    public void addAverageWaitLengths(int waitlength){
        this.average_wait_lengths.add(waitlength);
    }

    public void addHospitalEmployee(String employee){
        this.hospital_employees.add(employee);
    }

    public void addHospital(String hospital){
        this.hospitals.add(hospital);
    }

    public void schedulePractitionerAppointments(){
        System.out.println("Scheduling Practitioner Appointment");
    }

    public void acceptPractitionerOveride(){
        System.out.println("Accepting Practitioner overide");
    }
    public void emailPrescriptionToPharmacy(){
        System.out.println("Emailing prescription to pharmacy");
    }
    public void emailPrescriptionToPatient(){
        System.out.println("Emailing prescription to patient");
    }
    public void trackEDStatistics(){
        System.out.println("Tracking ED statistics");
    }

    public static void main(String[] args){
        MrEDSystem system = new MrEDSystem();

        system.addHospital("UVic Hospital");
        system.addHospitalEmployee("Oliver");
        system.addAverageWaitLengths(2);
        system.addPatientToWaitlist("Noah");
        system.addToWaitroomCapacities(100);
        

        system.schedulePractitionerAppointments();
        system.acceptPractitionerOveride();
        system.emailPrescriptionToPharmacy();
        system.emailPrescriptionToPatient();
        system.trackEDStatistics();

    }
}

