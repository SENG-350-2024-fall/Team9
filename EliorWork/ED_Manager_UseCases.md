| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 1. Manage waitlist                                                           |
| **Modification History**                    |  created 09/26/2024 - by Elior Desage        |
| **Description**                             | Emergency Department Manager can manage the waitlist in the Mister Ed's system, adjusting patient priorities based on critical needs or schedule.                  |
| **Actors**                                  | - **Emergency Department Manager(Primary)**: Medical Information System facilitating registration and queue management.<br>  - **Patients**: People seeking medical attention on the waitlist.                                                                |
| **Assumptions**                             | - Emergency Department Manager has access to the waitlist and the authority to adjust it.<br> - Emergency Department has up-to-date information on capacity and wait times.                                  |
| **Steps**                                   | 1. ED Manager selects "Manage Waitlist" in the system.<br> 2. ED Manager adjusts patient priorities or removes patients.                                  |
| **Variations (Optional)**                  | NA.                                                               |
| **Non-Functional (Optional)**              | Changes should be reflected in real-time and notify staff of updates to patient orders.                                          |
| **Issues**                                 | - Handling last-minute changes in Emergency Department capacity (e.g., sudden influx of emergency cases).<br> - Ensuring accurate and timely updates for Emergency Department wait times and treatment time.     |

---

| **Field**                                   | **Description**                                                                                                                    |
|---------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 2. Track_ED_Statistics                                                                                                             |
| **Modification History**                    | created 09/26/2024 - by Elior Desage .                                                                                        |
| **Description**                             | ED Manager can use the system to track statistics such as average wait time, patient inflow/outflow, and staff workload.           |
| **Actors**                                  | - ED Manager (Primary)<br> - System (Mister Ed)                                                                                    |
| **Assumptions**                             | ED Manager requires up-to-date statistics to improve ED performance.                                                              |
| **Steps**                                   | 1. ED Manager selects "ED Statistics" from the menu.<br> 2. The system displays various statistics related to ED operations.<br>    |
| **Variations (Optional)**                   | ED Manager can filter statistics by time period or patient type.                                                                   |
| **Non-Functional (Optional)**               | The data should be presented in easy-to-read charts and tables for quick decision-making.                                           |
| **Issues**                                  | How often should data be updated, and what sources are used to gather this data?            |

---


| **Field**                                   | **Description**                                                                                                                    |
|---------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 3. Auto_Schedule_Staff_Shifts                                                                                                      |
| **Modification History**                    | created 09/26/2024 - by Elior Desage .                                                                                        |
| **Description**                             | ED Manager uses an automated system feature to schedule staff shifts based on patient load and staff availability.                  |
| **Actors**                                  | - ED Manager (Primary)<br> - System (Mister Ed)                                                                                    |
| **Assumptions**                             | The system has access to staff schedules and patient load projections.                                                             |
| **Steps**                                   | 1. ED Manager selects "Auto-Schedule Shifts" in the system.<br> 2. The system generates shift schedules based on criteria.<br>      |
| **Variations (Optional)**                   | Manager can manually adjust shift suggestions provided by the system.                                                              |
| **Non-Functional (Optional)**               | The scheduling algorithm must consider staff preferences and regulations for shift lengths.                                         |
| **Issues**                                  | How will the system handle conflicts between patient needs and staff availability?                                                 |

---

| **Field**                                   | **Description**                                                                                                                    |
|---------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 4. Reorganize_Patient_Appointments                                                                                                 |
| **Modification History**                    | created 09/26/2024 - by Elior Desage .                                                                                        |
| **Description**                             | ED Manager can reorganize the waitlist when a patient is late to an appointment to ensure smooth flow of patients in the ED.        |
| **Actors**                                  | - ED Manager (Primary)<br> - System (Mister Ed)<br> - Patient                                                                      |
| **Assumptions**                             | Patients might be late for their scheduled appointments, and the manager has the authority to adjust the schedule.                 |
| **Steps**                                   | 1. ED Manager is alerted of a late patient.<br> 2. ED Manager selects "Reorganize Appointments".<br> 3. System adjusts waitlist.<br>|
| **Variations (Optional)**                   | The system could provide suggestions on patient flow adjustments.                                                                  |
| **Non-Functional (Optional)**               | Updates must occur quickly to avoid patient backlog in the ED.                                                                     |
| **Issues**                                  | How will the system prioritize reorganization when multiple patients are late?                                                     |
---

| **Field**                                   | **Description**                                                                                                                    |
|---------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 5. Toggle_Wait_Room_Capacity                                                                                                       |
| **Modification History**                    | created 09/26/2024 - by Elior Desage .                                                                                        |
| **Description**                             | ED Manager can adjust the capacity of the ED waiting room based on the average length of patient appointments.                     |
| **Actors**                                  | - ED Manager (Primary)<br> - System (Mister Ed)                                                                                    |
| **Assumptions**                             | ED Manager needs flexibility in adjusting room capacity to manage patient flow effectively.                                        |
| **Steps**                                   | 1. ED Manager selects "Toggle Wait Room Capacity".<br> 2. The system adjusts capacity based on manager input.<br>                   |
| **Variations (Optional)**                   | NA.                                                                                                                                |
| **Non-Functional (Optional)**               | Adjustments should take into account current and projected patient inflow.                                                          |
| **Issues**                                  | What factors should the system consider when adjusting the wait room capacity (e.g., emergency cases)?                             |
