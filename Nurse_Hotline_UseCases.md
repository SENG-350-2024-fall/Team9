| **Field**                                   | **Description**                                                                                                                 |
|---------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 1. View_Respond_Patient_Call<br>                                                                                                |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                     |
| **Description**                             | Nurses can use Mr. ED to view and respond to patients awaiting a call                                                           |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient                                                                        |
| **Assumptions**                             | The patient remains on the hotline until the Nurse responds to them.                                                            |
| **Steps**                                   | 1. Nurse selects "Hotline Waitlist" in Mr. ED app.<br> 2. Nurse selects a patient.<br> 3. Nurse responds to the patient.        |
| **Variations (Optional)**                   | NA.                                                                                                                             |
| **Non-Functional (Optional)**               |                                                                                                                                 |
| **Issues**                                  |                                                                                                                                 | 

| **Field**                                   | **Description**                                                                                                                 |
|---------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 2. View_Summary_Patient_Call<br>                                                                                                |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                     |
| **Description**                             | Nurses can use Mr. ED to view summary of patient condition awaiting call                                                        |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient                                                                        |
| **Assumptions**                             | The patient provided a description of their condition to Mr. ED prior to getting on the hotline.                                |
| **Steps**                                   | 1. Nurse selects "Hotline Waitlist" in Mr. ED app.<br> 2. Nurse selects a patient.<br> 3. Nurse selects the patient's sumamry.  |
| **Variations (Optional)**                   | NA.                                                                                                                             |
| **Non-Functional (Optional)**               |                                                                                                                                 |
| **Issues**                                  |                                                                                                                                 | 


| **Field**                                   | **Description**                                                                                                                 |
|---------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 3. Auto_Log_Patient_Call<br>                                                                                                    |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                     |
| **Description**                             | Nurses can use Mr. ED’s auto-log feature to generate a transcript of the patients call                                          |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient                                                                        |
| **Assumptions**                             | The auto-log feature can accurately transcribe most patient voices accross varying clarities, speeds and accents of voices.     |
| **Steps**                                   | 1. Nurse responds to the patient.<br> 2. Nurse toggles "Auto-Log" to "On".<br> 3. Nurse continues the call with the patient.    |
| **Variations (Optional)**                   | #2. Nurse may toggle "Auto-Log" to "Off" if the patient does not want thier call transcribed.                                   |
| **Non-Functional (Optional)**               |                                                                                                                                 |
| **Issues**                                  |                                                                                                                                 | 

| **Field**                                   | **Description**                                                                                                                 |
|---------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 4. Send_Patient_Call_Transcript<br>                                                                                             |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                     |
| **Description**                             | Nurses can ask Mr. ED to send transcript of the patient’s call to the desired hospital                                          |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient<br> - Hospital                                                         |
| **Assumptions**                             | Sending the transcript does not violate privacy regulations and the patient gives Mr. ED consent to send thier transcript.      |
| **Steps**                                   | 1. Nurse ends call.<br> 2. Nurse selects "Send Transcript to Hospital".<br> 3. Nurse sends the transcript to desired hospital.  |
| **Variations (Optional)**                   | NA.                                                                                                                             |
| **Non-Functional (Optional)**               |                                                                                                                                 |
| **Issues**                                  |                                                                                                                                 |

| **Field**                                   | **Description**                                                                                                                 |
|---------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 5. Direct_Patient_After_Call<br>                                                                                                |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                     |
| **Description**                             | Nurses can ask Mr. ED to direct patient to a GP or emergency services based on the call                                         |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient<br> - Hospital                                                         |
| **Assumptions**                             | The patient is satisfied even if the call did not resolve their condition, and they must see a GP or emergency services.        |
| **Steps**                                   |                                                                                                                                 |
| **Variations (Optional)**                   | NA.                                                                                                                             |
| **Non-Functional (Optional)**               |                                                                                                                                 |
| **Issues**                                  |                                                                                                                                 | 
