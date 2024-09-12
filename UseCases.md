| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**|  #1 Register for Ideal Spot on Virtual Waitlist                                                 |
| **Modification History**                   |  created 09/12/2024 - created for registration feature based on ED capacity and search radius.                |
| **Description**                            | This use case allows patients to register for a spot on the virtual waitlist at a nearby ED based on current capacity and desired search radius. The system returns available EDs and lets the patient choose the ideal one. This helps optimize patient flow and reduce overcrowding in EDs.                                  |
| **Actors**                                  | - **Patient**: Person seeking medical attention.<br> - **System (Mister Ed)**: Medical Information System facilitating registration and queue management.                                                                |
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister Ed.<br> - EDs have up-to-date information on capacity and wait times.                                  |
| **Steps**                                   | 1. The patient opens Mister Ed and selects the "Find ED" option.<br> 2. The patient specifies a desired search radius (e.g., 5km, 10km).<br> 3. The system returns a list of nearby EDs within the radius, displaying their current capacity and estimated wait times.<br> 4. The patient reviews the options and selects the ED they prefer based on wait times, proximity, or other preferences.<br> 5. The patient registers for the waitlist at the selected ED.<br> 6. The system confirms the registration and provides the patient with an estimated time for their appointment or further instructions.                                  |
| **Variations (Optional)**                  | - If no EDs are available within the search radius, the system suggests increasing the radius or shows alternative care options.<br> - If wait times increase, the patient may be allowed to change their ED selection.                                                               |
| **Non-Functional (Optional)**              | - The system must provide real-time ED capacity and wait time updates.<br> - The system must be accessible on mobile and web platforms with a user-friendly interface.                                           |
| **Issues**                                 | - Handling last-minute changes in ED capacity (e.g., sudden influx of emergency cases).<br> - Ensuring accurate and timely updates for ED wait times.

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 2. Understand_Response_Time_Given_Waitlist <br>                                                          |
| **Modification History**                    | **history** created 9/12/24 Amir Abdullahi.                                                              |
| **Description**                             | Patient can understand the current waitlist and have a general idea of when they will get a response.    |
| **Actors**                                  | Patient, Emergency Department                                                                  |
| **Assumptions**                             | Conditions that must be true for the use case to terminate successfully.                                  |
| **Steps**                                   | Interactions between actors and the system necessary to achieve the goal.                                  |
| **Variations (Optional)**                  | Any variations in the steps of the use case.                                                               |
| **Non-Functional (Optional)**              | List of non-functional requirements that the use case must meet.                                           |
| **Issues**                                 | List of issues that remain to be resolved.  

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 3. Notifications of next steps                                                 |
| **Modification History**                   | Created 12/09/24 by Oliver Goodrum                    |
| **Description**                            | The user should receive a notification from the system telling what the best course of action is for their symptoms. They should receive a few options giving them positives and negatives for each one.|
| **Actors**                                  | The User (Primary)                                                                  |
| **Assumptions**                             | For the use case to terminate successfully the user must receive a notification with a list of oprions for next steps.|
| **Steps**                                   | 1. The user should enter their symptoms. 2. The system gives the user multiple ranked options for what they can do next. 3. When the user clicks on one of the options it tells them the positives and negatives of that action.|
| **Variations (Optional)**                  | Any variations in the steps of the use case.                                                               |
| **Non-Functional (Optional)**              | 1. The security of the user medical information and symptoms. 2. The notifications must be quick as the user may be severly hurt and need attention soon.|
| **Issues**                                 | List of issues that remain to be resolved.  

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| #4                                                 |
| **Modification History**                   | Sept 12, 11:25AM - First draft of use case                   |
| **Description**                            | Triage effectively according to the needs of the patients, assigning priority appropriately.                                  |
| **Actors**                                  | Mister Ed System, healthcare services (patient load)                                                                 |
| **Assumptions**                             | User must register to be put on the waitlist. Mister Ed System must have a way to etermine hospital load                                   |
| **Steps**                                   | Mister Ed System communicates with healthcare services to understand the load in the area. Mister Ed System assigns priority to the different users based on the waitlist position and the urgency of health issue.                                   |
| **Variations (Optional)**                  | Any variations in the steps of the use case.                                                               |
| **Non-Functional (Optional)**              | List of non-functional requirements that the use case must meet.                                           |
| **Issues**                                 | The type of communication the Mister Ed System has with healthcare services. How manual the triage process is for Mister Ed.  |
