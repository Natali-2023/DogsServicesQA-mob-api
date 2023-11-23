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

- **Reports:**
    - [Postman Collection Report](https://drive.google.com/drive/folders/1dqi6MLJIpFadG1taMdij2mLhXbm3HCdl?usp=sharing)
    - [Jenkins Test Report API](https://drive.google.com/drive/folders/1xU8mQksEdFiBaQChuh5CC1qkNjY3nseH?usp=sharing)
    - [Postman Load Testing Report](https://drive.google.com/drive/folders/1h53O1gUSj2cbSYqi5oZLKSUH01gVKIvZ?usp=sharing)

#### Mobile Testing
- **Tools Used:**
    - IntelliJ IDEA
    - Value Object Model (VOM)
    - Gradle (Mob tests)
    - Appium Server GUI
    - Chrome Developer Tools
    - Android Driver
    - Xiaomi Redmi 8T (Android version: 11RKQ1.201004.002)
  
- **Reports:**
    - [Appium Collection Report](https://drive.google.com/drive/folders/1elK1WbXRLjJH_yYSXYVIRyK6_V3jcKy_?usp=sharing)
    - [Jenkins Test Report Mob](https://drive.google.com/drive/folders/1UcLpHtNuSc6dUMf_AExB2jQalP3TEno0?usp=sharing)
- **Testing Scenarios:**
    - Basic functionality testing of the cross-browser website.

#### UI Testing
- **Tools Used:**
    - IntelliJ IDEA
    - Page Object Model (POM)
    - Maven (UI tests)

- **Testing Scenarios:**
    - Positive and negative scenarios

- **Reports:**
    - [Jenkins Test Report UI](https://drive.google.com/drive/folders/1gNH0KdGPR2ygKUES9SH4fK9nW7B4kuGB?usp=sharing)

### Team
- **Team Lead:** Leonid Usatii
- **Team Members:**
    - Nataliia Bodnariuk
    - Nataliia Pohrebniak

### Additional Resources

- [Test Plan](https://docs.google.com/document/d/1ds1I_9-xMYJ_Q1O-pYhDYksF3QJidNJn/edit?usp=sharing&ouid=103253238846111626832&rtpof=true&sd=true)
- [Mind Map](https://drive.google.com/file/d/1E0OYOPirQnJzSiN_agZFYP8w1WacsrL-/view?usp=sharing)
- [State Transition](https://drive.google.com/file/d/1X3UwlAXMFgURSSG5a26IMT85hq1Foo-4/view?usp=sharing)
- [TestLink](https://testlink.ait-tr.de/index.php)
- [Jira Bugs](https://drive.google.com/drive/folders/1mSJ4UPvwUZ3R7e_LYrvFoSJBiANVbUNo?usp=sharing)


### Conclusion
The Dog Services Automated Testing Project aims to enhance the overall user experience
and reliability of the platform by ensuring that all features and functionalities operate as expected across different environments.
