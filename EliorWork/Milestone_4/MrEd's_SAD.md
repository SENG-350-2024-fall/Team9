# Mr.Ed's Software Architecture Documentation
# SENG-350-2024-fall
# Software Architecture Document (SAD)
# Team 9


# Sections <br>
## 1. Documentation Roadmap and Overview <br>
### Purpose and Scope of the SAD

The Software Architecture Document (SAD) for the Mr. ED system describes the design and structure of the system, which aims to streamline healthcare management by enabling virtual triage, patient scheduling, and communication between healthcare professionals and patients. This document serves as:

- A reference for developers to implement and maintain the system.
- A guide for stakeholders to understand key architectural decisions.
- A blueprint for ensuring system scalability, reliability, and usability.

The architecture covers core features of the Mr. ED system, including:

- Severity-based triage to prioritize patient needs.
- Interactions among patients, hotline nurses, general practitioners (GPs), and emergency department managers (EDMs).
- System reliability through tactics like data redundancy and monitoring.
- Exclusion of features like patient accounts or historical medical data to enhance security and simplicity.
- The SAD excludes non-architectural details, such as the internal implementation specifics of individual components.

### How the SAD is Organized

1. Purpose and Scope of the SAD:
Explains the purpose and scope of the document, including its intended audience and the criteria for architectural documentation.

2. Documentation Roadmap and Overview:
Offers a guide to the document structure, ensuring readers can navigate efficiently.

3. Architecture Background:
Discusses the constraints, influences, and rationale that shaped the architecture. Includes an overview of critical design decisions, such as the focus on severity-based triage and the removal of patient accounts.

4. Views and Mapping Between Views:
Details multiple perspectives of the system's architecture:
- Module View: Breaks down the system into functional components (e.g., Virtual Triage, Notification System).
- Runtime View: Explains the dynamic interactions between components during operations.
- Data View: Shows the flow of data between actors and system components.

5. Referenced Materials:
Lists documents, standards, and references used in creating the architecture, such as healthcare best practices or design pattern documentation.

6. Glossary and Acronyms:
Provides definitions for terms like "triage queue" and "severity" and acronyms such as GP (General Practitioner) or EDM (Emergency Department Manager).

### How a View Is Documented

1. Primary Presentation:
- Graphical Representation: Illustrates the components, their relationships, and interactions. For example:
  - A runtime diagram showing the flow from patient symptom submission to virtual triage processing.
  - A module diagram displaying core components like Virtual Triage, Emergency Waitlist, and GP Scheduler.
- Key Notations: Includes a legend or key to explain symbols and external entities.
- Context Diagrams: Highlights boundaries between the system and external actors, such as hospitals or patients.

2. Element Catalog:
- Describes system elements and their properties, including:
  - Actors: Patients, hotline nurses, GPs, and EDMs.
  - Components: Triage engine, waitlist manager, and notification system.
- Includes interface descriptions for system interactions and observable behaviours of each element.

3. Variability Guide:
- Highlights configurable parts of the system, such as:
  - Customizable thresholds for triage severity.
  - Notification settings for different stakeholders.
- Describes how to parameterize these aspects to adapt the system for varying needs.

4. Other Information:
- Provides additional insights, such as:
  - Rationale behind design choices (e.g., why accounts were excluded).
  - Results of prototypes or experiments that informed the architecture.
  - Contextual details linking the view to overarching system goals or parent views.

## 2. Architecture Background <br>

### 1.2.1 Problem Background
The Mr.Ed system architecture is designed to address challenges in healthcare efficiency and accessibility. Security concerns pushed us to avoid storing any sensitive data such as patient accounts or medical history, reducing the risk of breaches and attacks. Availability was prioritized through redundancy and monitoring mechanisms to ensure consistent reliability. Simplicity was a key focus, enabling an intuitive user experience for patients, healthcare professionals, and administrators while maintaining operational efficiency.

### 1.2.2 System Overview
The Mr.Ed's system is a digital healthcare management platform aimed at streamlining triage appointment scheduling, and communication between patients and healthcare providers. By integrating severity-based assessments, dynamic appointment and waitlist management, and real-time notifications, the system reduces emergency department congestion, ensures timely medical care, and enhances patient satisfaction. The architecture supports the seamless integration of multiple user roles, including hotline nurses, general practitioners, and emergency department managers.

### 1.2.3 Context
Goals:
- Enhance emergency response efficiency and reduce patient waiting times.
- Enable digital triage and scheduling for improved accessibility to care.
  
Lifecycle Role:
- Facilitates modular, iterative development for easier maintenance and scalability.
- Provides clear inputs (e.g., patient symptoms) and outputs (e.g., triage results) to streamline operations.
  
Adaptability:
- Modular components ensure the system can evolve with changing healthcare requirements.
- Secure communication channels support seamless data exchange between stakeholders.

### 1.2.4 Driving Requirements
#### Functional Requirements:
- Enable symptom submission, triage results delivery, and appointment scheduling.
- Allow hotline nurses to manage call summaries and guide patients.

#### Quality Attributes:
- High Availability: Redundancy and monitoring ensure continuous system operation.
- Security: Avoid persistent sensitive data to minimize vulnerabilities.
- Scalability: Modular design supports concurrent interactions without performance degradation.

#### Design Constraints:
- Use simple, lightweight storage solutions (e.g., text files) instead of complex databases.
- Maintain a user-friendly interface to ensure accessibility for all roles.

### 1.2.5 Solution Background
The architecture aligns with the system's goals of reliability, simplicity, and security by utilizing severity-based triage, which prioritizes critical cases and reduces emergency department waiting time. Security concerns led to the exclusion of patient accounts and centralized medical history, simplifying data handling while minimizing risks. The modular design ensures scalability and flexibility, allowing for incremental updates and accommodating future needs.

### 1.2.6 Architectural Approaches
The architecture employs key design patterns to enhance functionality and maintainability. Severity-based triage, implemented through the "Chain of Responsibility", escalates cases from hotline nurses to general practitioners and emergency department managers based on severity. The "Observer" pattern facilitates real-time notifications to patients, while the "Decorator" pattern dynamically assigns nurse specializations for targeted care. Alternatives like persistent patient accounts or centralized medical histories were rejected due to their complexity and potential security vulnerabilities.

### 1.2.7 Analysis Results
Testing and analysis confirm that the Mr. ED system meets its intended goals and performs reliably under various conditions. Stress testing demonstrated that the triage and waitlist systems can handle concurrent patient submissions without performance degradation. Failure scenario testing validated the effectiveness of backup mechanisms, ensuring data persistence during unexpected system crashes. Heartbeat monitoring successfully detected anomalies, enhancing the system's availability. Usability testing showed that patients and healthcare professionals could navigate workflows like triage and scheduling with minimal guidance, validating the architecture's focus on simplicity and user-centric design.

### 1.2.8 Mapping Requirements to Architecture
- Virtual Triage: Processes symptoms and prioritizes cases based on severity.
- Triage Engine and Waitlist Manager: Schedule appointments and update waitlists dynamically.
- Nurse Hotline Module: Provides call summaries to hotline nurses for effective patient guidance.
- High Availability: Achieved via redundancy, backups, and heartbeat monitoring.
- Security: Focuses on current symptoms rather than persistent sensitive data.






## 3. Views <br>
## 4. Mapping Between Views <br>
## 5. Referenced Materials <br>
## 6. Glossary and Acronyms <br>
