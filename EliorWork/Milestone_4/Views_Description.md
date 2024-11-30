## **1.3.1.1 Primary Graphical Presentation**
- Patients interact with Mr.Ed's system by inputting their symptoms and personal details.
- The system evaluates the severity of the patient's condition and forwards them to the appropriate medical professional (e.g., doctor, emergency care, or nurse) using the **Responsibility Chain Triage Handler**.
- The graphical interface ensures that patients can see estimated wait times, the nearest hospital, and their current triage status.

---

## **1.3.1.2 Primary Graphical Presentation Element Catalog**

| **Element Name**               | **Textual Description Including Explanation of Element and its Properties**                                                                                   |
|--------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| **Patient**                    | Represents the individual seeking medical assistance. Attributes include Address, PHN, DOB, and Symptoms.                                       |
| **Hotline Nurse**              | Assists patients with non-emergency issues or escalates cases to a doctor or emergency care. Includes attributes like Availability and Contact.|
| **ED Manager**                 | Manages emergency department resources, oversees patient queues, and updates hospital capacity information in real time.                            |
| **General Practitioner**       | Handles detailed diagnoses and follow-up care for patients referred from the triage process.                                   |
| **Mr. ED Main**                | Central system responsible for managing patient records, tracking hospital wait times, and providing interface elements like maps and waitlists. |
| **HospitalLocalizer**          | Identifies the hospital closest to the patient’s location using geolocation and distance calculation algorithms.             |
| **ResponsibilityChain.TriageHandler** | Allocates patients to queues based on injury severity. Configurable logic for prioritizing cases dynamically based on evolving circumstances.   |

---

## **1.3.1.3 Variability Guide**

| **Aspect**                   | **Description**                                                                                                                                 |
|-----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| **Role Extensions**         | New roles (e.g., mental health specialist or telemedicine consultant) can be added|
| **Symptom Attributes**      | Additional fields (e.g., symptom onset, pain scale, or pre-existing conditions) can be incorporated to improve triage accuracy.                               |
| **Triage Workflow**         | The triage logic supports custom rules for prioritization, such as age-based adjustments or comorbidity considerations.                                            |
| **Deployment Flexibility**  | Mr.Ed can be deployed on multiple platforms, including cloud-based, hybrid, or local on-premises environments.                                                |
| **Notification Configuration** | Notification settings for medical staff can be tailored by adding options for urgency level, preferred channels (e.g., mobile app, SMS, email), and response deadlines. |
| **Localization Support**    | The system can be adapted for different languages and regional requirements, including healthcare regulations and metric/imperial units.                        |
| **Interface Customization** | The graphical interface can be customized to match organizational branding or enhanced with accessibility features (e.g., screen reader compatibility).          |


#### 1.3.1.4 Other Information 
### **Important Design Decisions**

- **Inheritance-Based User Roles**  
  Simplifies code reuse and extension for future roles by utilizing inheritance hierarchies to define user-specific behaviors and attributes.

- **Centralized Triage Management**  
  Ensures consistency in handling patient cases and storing medical data by consolidating triage logic and patient information in a central system.

- **Flexible Symptom Handling**  
  Enables editing and updating symptoms dynamically to capture evolving patient conditions and ensure accurate diagnosis and triage.

---

### **Rejected Alternatives**

- **Single User Entity**  
  Combining all user roles into a single entity was rejected due to scalability limitations and challenges in handling role-specific behaviors effectively.

- **Manual Workflow**  
  Automating triage workflows using the Triage Application was preferred to enhance efficiency, reduce processing time, and minimize human error.

#### 1.3.1.5 Parent View
Not applicable.
