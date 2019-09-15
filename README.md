# Pediatrics system application

The aim of this application is to allow CRUD operations on next domain objects: Doctor, Patient, Examination, Refer and Doctor Type. Each examination is association class of a doctor and a patient, each doctor has one and only one doctor type and each refer is a weak object of examination and refers to one and only one doctor type.
## Prerequisites

You will need [Leiningen][1] 2.0.0 or above and MySQL installed.

[2]: https://github.com/ring-clojure/ring 
## Setup
To run application, the steps are:
1. Login to MySQL server and create database call pediatrics which is assigned to the project as a file.
  
2. To start a web server for the application, run
    lein ring server

## Libraries 
  Clojure project was generated using:
  
  [Leiningen][1] - dependency management library for building and configure Clojure project
  
  [Ring][2] - library for building web application in the Clojure programming language
  
  [Compojure][3] - routing library for Ring
  
  
    
## About project

The project consists of the following frontend pages:
1. Index page which leads to the homepage
2. Home page - has a menu from which user can choose specific object and execute specific operation on it:
Insert, Update, Edit or Delete (To be able to insert examination, user has to enter specific patient id and doctor id, accordingly to be able to enter refer, user has to enter specific examination id. It is not mandatory but it is suggestible to enter doctor type for doctor as well as for refer.)
3. getAllDoctors - shows all available doctors
4. getAllDoctorTypes - shows all available doctor types
5. getAllPatients - shows all available patients
6. getAllExaminations - shows all available examinations
7. getAllRefers - shows all available refers
8. insertDoctor - allows adding new doctor
9. insertDoctorType - allows adding new doctor type
10. insertPatient - allows adding new patient
11. insertExamination - allows adding new doctor
12. insertRefer - allows adding new refer
13. updateDoctor - allows updating the doctor
14. updateDoctorType - allows updating the doctor type
15. updatePatient - allows updating the patient
16. updateExamination - allows updating the examination
17. updateRefer - allows updating the refer

## References
Clojure for the brave and true

###### Course Software Engineering Tools and Methodology, Faculty of Organization Sciences, University of Belgrade, Serbia.

