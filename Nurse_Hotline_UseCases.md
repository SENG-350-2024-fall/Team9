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
| **Assumptions**                             | A transcript of the patient's call actually exists and sending the transcript does not violate the patient's privacy.           |
| **Steps**                                   | 1. Call ends.<br> 2. Nurse selects "Send Transcript to Hospital" and sends the transcript to the desired hospital.              |
| **Variations (Optional)**                   | #2. Nurse will not select "Send Transcript to Hospital" if there is no transcript or if the patient does not consent.           |
| **Non-Functional (Optional)**               |                                                                                                                                 |
| **Issues**                                  |                                                                                                                                 |

| **Field**                                   | **Description**                                                                                                                 |
|---------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 5. Direct_Patient_After_Call<br>                                                                                                |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                     |
| **Description**                             | Nurses can ask Mr. ED to direct patient to a GP or emergency services based on the call                                         |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient<br> - Hospital                                                         |
| **Assumptions**                             | The nurse was not able to resolve their condition in the call and the patient must see a GP or emergency services.              |
| **Steps**                                   | 1. Call ends.<br> 2. Nurse selects "Direct Patient"<br>. 3. Nurse selects GP or emergency services based on the patient's need. |
| **Variations (Optional)**                   | NA.                                                                                                                             |
| **Non-Functional (Optional)**               |                                                                                                                                 |
| **Issues**                                  |                                                                                                                                 | 
