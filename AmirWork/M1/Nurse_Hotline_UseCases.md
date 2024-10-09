| **Field**                                   | **Description**                                                                                                                  |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 1. View_Respond_Patient_Call<br>                                                                                                 |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                      |
| **Description**                             | Nurses can use Mr. ED to view and respond to patients awaiting a call.                                                           |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient                                                                         |
| **Assumptions**                             | The patient remains on the hotline until the Nurse responds to them.                                                             |
| **Steps**                                   | 1. Nurse selects "Hotline Waitlist" in Mr. ED app.<br> 2. Nurse selects a patient.<br> 3. Nurse responds to the patient.         |
| **Variations (Optional)**                   | NA.                                                                                                                              |
| **Non-Functional (Optional)**               | Nurses must be able to view patients waiting in a UI that is easily navigable and has a simple to read layout.                   |
| **Issues**                                  | How will Mr. ED regulate the length of calls to ensure that all the patients are servered effectively?                           | 

| **Field**                                   | **Description**                                                                                                                  |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 2. View_Summary_Patient_Call<br>                                                                                                 |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                      |
| **Description**                             | Nurses can use Mr. ED to view summary of patient condition awaiting call.                                                        |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient                                                                         |
| **Assumptions**                             | The patient provided a description of their condition to Mr. ED prior to getting on the hotline.                                 |
| **Steps**                                   | 1. Nurse selects "Hotline Waitlist" in Mr. ED app.<br> 2. Nurse selects a patient.<br> 3. Nurse selects the patient's sumamry.   |
| **Variations (Optional)**                   | NA.                                                                                                                              |
| **Non-Functional (Optional)**               | Summary must be provided to nurse in a concise format that allows the nurse to quickly understand the patient's condition.       |
| **Issues**                                  | Will the summary of the patient's condition provide enough information for the nurse responding to the call?                     | 


| **Field**                                   | **Description**                                                                                                                  |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 3. Auto_Log_Patient_Call<br>                                                                                                     |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                      |
| **Description**                             | Nurses can use Mr. ED’s auto-log feature to generate a summary transcript of the patients call.                                  |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient                                                                         |
| **Assumptions**                             | The auto-log feature can accurately transcribe most patient voices accross varying clarities, speeds and accents of voices.      |
| **Steps**                                   | 1. Nurse responds to the patient.<br> 2. Nurse toggles "Auto-Log" to "On".<br> 3. Nurse continues the call with the patient.     |
| **Variations (Optional)**                   | #2. Nurse may toggle "Auto-Log" to "Off" if the patient does not want thier call transcribed.                                    |
| **Non-Functional (Optional)**               | The transcriber's speech to text latency must be minimal and in the worst case the latency must be no more than 5 seconds.       |
| **Issues**                                  | What will happen in cases where the auto-log feature can not effectively transcribe the conversation?                            | 

| **Field**                                   | **Description**                                                                                                                  |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 4. Send_Patient's_Call_Transcript<br>                                                                                            |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                      |
| **Description**                             | Nurses can ask Mr. ED to send transcript of the patient’s call to the desired hospital and department.                           |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient<br> - Hospital                                                          |
| **Assumptions**                             | A transcript of the patient's call actually exists and sending the transcript does not violate the patient's privacy.            |
| **Steps**                                   | 1. Call ends.<br> 2. Nurse selects "Send Transcript to Hospital" and sends the transcript to the desired hospital and department.|
| **Variations (Optional)**                   | #2. Nurse will not select "Send Transcript to Hospital" if there is no transcript or if the patient does not consent.            |
| **Non-Functional (Optional)**               | Sending the transcript of the patient's call must be secure.                                                                     |
| **Issues**                                  | Will the nurse have to further revise the transcript if it has too much irrelevant info before sending it to the hospital?       |

| **Field**                                   | **Description**                                                                                                                  |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 5. Direct_Patient_After_Call<br>                                                                                                 |
| **Modification History**                    | **history** created 9/19/24 Amir Abdullahi.                                                                                      |
| **Description**                             | Nurses can ask Mr. ED to direct patient to a General Practitioner(GP) or ED if the call did not resolve the patient's condition. |
| **Actors**                                  | - Nurse (Primary)<br> - System (Mister Ed)<br> - Patient                                                          |
| **Assumptions**                             | The patient will follow the directions of the nurse to go to either a GP or ED after the call.                                   |
| **Steps**                                   | 1. Call ends.<br> 2. Nurse selects "Direct Patient"<br> 3. Nurse selects GP or ED based on the patient's need.                   |
| **Variations (Optional)**                   | NA.                                                                                                                              |
| **Non-Functional (Optional)**               | NA.                                                                                                                              |
| **Issues**                                  | Could the patient have avoided being directed to a GP or ED if they had been better paired with a different nurse on the hotline?| 
