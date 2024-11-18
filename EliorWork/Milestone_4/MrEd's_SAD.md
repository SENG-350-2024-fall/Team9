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
- Includes interface descriptions for system interactions and observable behaviors of each element.

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
## 3. Views <br>
## 4. Mapping Between Views <br>
## 5. Referenced Materials <br>
## 6. Glossary and Acronyms <br>
