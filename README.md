## Dog Services - Automated Testing Project

### Overview
The Dog Services Automated Testing Project is designed to ensure the quality and reliability of the Dog Services online platform.
Conducted UI testing, API testing and mobile device testing to check the functionality and performance of the platform.

### Project Description
**Purpose**: The primary goal of this testing project is to guarantee a seamless experience for dog owners, animal lovers, and individuals seeking canine-related services.
The platform offers features such as finding dog sitters, locating veterinary clinics, exploring animal shelters, and identifying kennels based on different dog breeds.

### Environment
- **Operating System**: Windows 11
- **Browser**: Chrome Version 119.0.6045.160
- **Mobile Device**: Xiaomi Redmi 8T
    - **Android Version**: 11RKQ1.201004.002

### Testing Scope

#### API Testing
- **Tools Used:**
    - IntelliJ IDEA
    - Value Object Model (VOM)
    - Gradle (API tests)
    - Postman
    - Newman (Postman CLI)
    - Jenkins

- **Endpoints Tested:**
    - List of API endpoints:
         `GET /api/dog-sitters`
         `GET /api/dog-sitters/search`
         `POST /api/login`
         `POST /api/logout`
         `GET /api/kennels/{kennel-id}`
         `PUT /api/kennels/{kennel-id}`
         `DELETE /api/kennels/{kennel-id}`
         `GET /api/kennels`
         `POST /api/kennels`
         `GET /api/kennels/byCities`
         `GET /api/clinics/{clinic-id}`
         `PUT /api/clinics/{clinic-id}`
         `DELETE /api/clinics/{clinic-id}`
         `GET /api/clinics`
         `POST /api/clinics`
         `GET /api/clinics/byCities`
         `POST /api/registerSetter`
         `GET /api/users/allUsers`
         `GET /api/users/my/profile`
         `POST /api/registerUser/{dogLover-id}/dogSitters`
         `GET /api/registerUser/{dogLover-id}/dogSitters`
         `POST /api/registerUser`
         `GET /api/registerUser/dogLov-id/{loveId}/dogSid/{sitId}`

- **Testing Scenarios:**
    - Positive and negative scenarios for each API endpoint
#### Load Testing with Postman

Additionally, load testing has been performed using Postman to assess the performance and scalability of the API under different levels of simulated traffic.

#### Mobile Testing
- **Tools Used:**
    - IntelliJ IDEA
    - Value Object Model (VOM)
    - Gradle (Mob tests)
    - Appium Server GUI
    - Chrome Developer Tools
    - Android Driver
    - Xiaomi Redmi 8T (Android version: 11RKQ1.201004.002)
  
- **Testing Scenarios:**
    - Basic functionality testing of the cross-browser website.

#### UI Testing
- **Tools Used:**
    - IntelliJ IDEA
    - Page Object Model (POM)
    - Maven (UI tests)

- **Testing Scenarios:**
    - Positive and negative scenarios
 
      ### Reports:
  Reports and Bug Reports
  · TestPlan you can look here: [TestPlan](https://drive.google.com/drive/folders/1X6AEBCjapAhLtlJOGG1TZvwBwpjebj8E?usp=sharing)
  . Specification of the project look here: [specification](https://docs.google.com/document/d/1MhEywOaZgZV2H8nt1kC2nSFHZLJkqHev/edit?usp=sharing&ouid=107159386401864051408&rtpof=true&sd=true)
  · Test items were made using MindMup: [testItems1](https://drive.google.com/file/d/1E0OYOPirQnJzSiN_agZFYP8w1WacsrL-/view?usp=sharing)
  [testItems2](https://drive.google.com/file/d/1aPwI9o_U9QyNsUAfkyr-vGz5bzivq6Yu/view?usp=sharing)
  [stateTransitionDiagram](https://drive.google.com/file/d/1ip7VUccSgNJDwygLA7H8heAsPU8lotOk/view?usp=sharing)
  Test reports are done using IntelliJ IDEA: [test_logs_IntelliJi](https://drive.google.com/drive/folders/1AQQv6BX0-AqeGcMOXk7-ZeWm_4EcvxIA?usp=sharing)
  · Bug tracking are done using JIRA: [bugTracking](https://drive.google.com/drive/folders/1qgkIflAhdE7ZyG7723SdD5qsr4QEzcM_?usp=sharing)
  · Test reports are done using TestLink:  [testLinkReports](https://drive.google.com/drive/folders/11D6jQNUY_bcpcGEJQPQveZ359b7EuuIr?usp=sharing)

Integration with Jenkins
Automated tests are integrated with Jenkins for regular code checks: [jenkinsReport](https://docs.google.com/document/d/17IDpZEbvjyG9-zVMBauEvj7SUA7nEM7AjU2eRHmd750/edit?usp=sharing)

### Conclusion
The Dog Services Automated Testing Project aims to enhance the overall user experience
and reliability of the platform by ensuring that all features and functionalities operate as expected across different environments.
