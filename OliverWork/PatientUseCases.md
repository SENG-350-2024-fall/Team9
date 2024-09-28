| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 1. Log In                                                          |
| **Modification History**                    |  created 2024/09/26 by Oliver Goodrum          |
| **Description**                             | This use case allows the user to log in to their account where all of their medical information and medical history is stored.|
| **Actors**                                  | - **Patient**: Person seeking medical attention. |
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister ED and a wifi connection.<br> - The patient already has a Mister ED account.|
| **Steps**                                   | 1. The user clicks on the log in button on the Mister ED System.<br> 2. The user is presented with two text boxes and two buttons. One text box says username and the other says password, and one button says log in and the other says create an account.<br> 3. The user enters their username into the username text box and their password into the password text box.<br> 4. The user presses the log in button and is taken to the homepage. |
| **Variations (Optional)**                  | - If the user enters an invalid password or username into the text boxes when they press on the login button, then text will show up on screen saying "Invalid username and/or password". Additionally the text boxes will be cleared and the user will be able to re-enter their username and password as normal. |
| **Non-Functional (Optional)**              | - The system must be secure and not allow someone to access other peoples accounts.<br> - The system should be availible to users who have entered the right username and password.<br> - The system should be user friendly with a nice appearance and colours.|
| **Issues**                                 | - Storing the usernames and passwords on a secure database.

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 2. Log Out                                                          |
| **Modification History**                    |  created 2024/09/26 by Oliver Goodrum          |
| **Description**                             | This use case allows the user to log out of their account where all of their medical information and medical history is stored.|
| **Actors**                                  | - **Patient**: Person seeking medical attention. |
| **Assumptions**                             | - The patient is currently logged in to the Mister ED system.|
| **Steps**                                   | 1. The user clicks on their account profile in the top right of the screen.<br> 2. They are presented with the log out button.<br> 3. They click on the log out button and they are now logged out of their account. |
| **Variations (Optional)**                  |  |
| **Non-Functional (Optional)**              | - This should be intuitive for the user to ensure that the user does not log out accidently |
| **Issues**                                 | 

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 3. Call Nurse Hotline                                                          |
| **Modification History**                    |  created 2024/09/26 by Oliver Goodrum          |
| **Description**                             | This use case allows the patient to call the nurse hotline to get medical advice from a rgistered nurse.|
| **Actors**                                  | - **Patient**: Person seeking medical attention.<br> - **Nurse**: A registered nurse employed to answer the nurse hotline|
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister ED.<br> - The patient starts on the Mister ED homepage. |
| **Steps**                                   | 1. The patient clicks on the nurse hotline tab from the homepage.<br> 2. On the nurse hotline tab there is a button that says "Call Nurse Hotline" that the patient will click on.<br> 3. The patient is put into the nurse hotline waitlist and waits until a nurse is availible.<br> 4. Now that a nurse is availible the patients call is answered.<br> 5. The patient talks with the nurse about his symptoms and the nurse helps them with what they should do next.<br> 6. Once the patient and nurse are done talking then either the patient or nurse can end the call.|
| **Variations (Optional)**                  | - If the patient does not want to use a wifi connection to call the nurse hotline then they can call using their cell service.|
| **Non-Functional (Optional)**              | - The call must be secure not allowing anyone other than the nurse and patient to hear the call.|
| **Issues**                                 | - The patient could try to make the call to the nurse hotline with a poor wifi or cell connection.

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 4. Create New Account                                                          |
| **Modification History**                    | created 2024/09/26 by Oliver Goodrum          |
| **Description**                             | This use case allows the patient to create their account where all of their medical information and medical history is stored.|
| **Actors**                                  | - **Patient**: Person seeking medical attention. |
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister ED and a wifi connection.<br>|
| **Steps**                                   | 1. The patient is on the Mister Ed homescreen and clicks on create new account.<br> 2. The patient enters the username and password that they would like for their account.<br> 3. The patient enters all of their medical information and medical history to add to their account.<br> 4. Now that all of the patients information is entered they can click on the button that says "Create Account" and their account will be created, they will logged in, and they will be on the hompage.|
| **Variations (Optional)**                  | - If the username that the patient enters is already taken then the Mister Ed system will prompt them to change their username.|
| **Non-Functional (Optional)**              | - The system must be secure and force users to make good passwords.
| **Issues**                                 | - Storing the usernames and passwords on a secure database.

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 5. View Nearby Hospital                                                          |
| **Modification History**                    | created 2024/09/28 by Oliver Goodrum          |
| **Description**                             | This use case allows the patient to view all the hospitals nearest to their location.|
| **Actors**                                  | - **Patient**: Person seeking medical attention. |
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister ED and a wifi connection.<br> - The patient has their GPS location turned on.|
| **Steps**                                   | 1. The patient is on the Mister Ed homescreen and clicks on view nearby hospitals.<br> 2. They are taken to a map showing their location as well as all of the hospitals near their location.<br> 3. The user can then click on one of the hospitals to view the waitime as well as an estimation of how long it will take the patient to get to the hospital.|
| **Variations (Optional)**                  | |
| **Non-Functional (Optional)**              | - The system should be accurate showing the correct travel times.
| **Issues**                                 | - Choosing a map to use for our system

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 6. Register for Virtual Triage                                                          |
| **Modification History**                    | created 2024/09/28 by Oliver Goodrum          |
| **Description**                             | This use case allows the patient to register for the virtual triage.|
| **Actors**                                  | - **Patient**: Person seeking medical attention. |
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister ED and a wifi connection.<br>|
| **Steps**                                   | 1. The patient is on the Mister Ed homescreen and clicks on virtual triage.<br> 2. The patient is prompted to enter their symptoms.<br> 3. Once the patient has entered their symptoms they then wait for the system to respond with what they should do next.
| **Variations (Optional)**                  |  |
| **Non-Functional (Optional)**              | - The system should be quick as patients may need urgent attention.
| **Issues**                                 | - Getting correct information about a patient symptoms.

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 7. View Virtual Triage Response                                                          |
| **Modification History**                    | created 2024/09/28 by Oliver Goodrum          |
| **Description**                             | This use case allows the patient to view the response from the system once they have registered for the virtual triage.|
| **Actors**                                  | - **Patient**: Person seeking medical attention. |
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister ED and a wifi connection.<br> - The patient has already entered their symptoms and completed the virtual traige registration.|
| **Steps**                                   | 1. The patient is in the Mister Ed system and receives a noitification at the top of their screen that they can click on.<br> 2. The patient clicks on the notification.<br> 3. The patient is then taken to a page with options for what they should do next. Each option lists positives and negatives. Additionally, the options are ranked by what the system thinks is best based on the pateints symptoms and medical history.
| **Variations (Optional)**                  | - If the system reccomends that the patient should go to the hospital then they are able to register for the hospital waitlist. |
| **Non-Functional (Optional)**              | - The system should be quick as patients may need urgent attention.
| **Issues**                                 | - How to rank all the options given to the patient.

| **Field**                                   | **Description**                                                                                          |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Use Case Identifier and Reference Number**| 8. View Waitlist                                                      |
| **Modification History**                    | created 2024/09/28 by Oliver Goodrum          |
| **Description**                             | This use case allows the patient to view the hospital that they are in.|
| **Actors**                                  | - **Patient**: Person seeking medical attention. |
| **Assumptions**                             | - The patient has access to a mobile device or computer with Mister ED and a wifi connection.<br> - The patient is on an ER waitlist for a hospital.|
| **Steps**                                   | 1. The patient is on the Mister Ed homescreen and clicks on waitlist.<br> 2. The patient can see where they are in the waitlist, such as how many people are ahead of them and the estimated time that it will take until they are helped.
| **Variations (Optional)**                  | - When the patient has clicked on the waitlist they can then choose to leave the waitlist if they decide they do not want to be seen by the doctor anymore. |
| **Non-Functional (Optional)**              | - The system should have accurate wait times so that the patients are satisfied and not waiting longer than they expected to wait.
| **Issues**                                 | - Getting correct wait times can be tricky as we do not know the length of time that it will take to treat each patient.
