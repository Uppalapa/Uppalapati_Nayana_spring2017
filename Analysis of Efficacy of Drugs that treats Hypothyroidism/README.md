# Analysis of Efficacy of Drugs that treat Hypothyroidism
## Introduction
World Health Organization (WHO) is a specialized agency of the United Nations that is concerned with international public health. WHO wants to find the best Drug to treat Hypothyroidism by conducting a health study throughout the world. This project concentrates in finding the drug that showed best results on the patients who participated during this health study. 
## Problem Statement
* According to “American Thyroid Association” 1 in every 10 people of the overall population is suffering with hypothyroidism. 
* There is a need to find an effective drug with appropriate chemical composition that can treat this disease at its best and help in speedy recovery of the patient.
## Approach
* In this project we are considering world as our ecosystem 
* World Ecosystem contains array of country Networks
* Every network contains Enterprise Directory
## Use Cases
* Appointment scheduling between patient and scheduler
* Lab test request between scheduler and lab assistant
* Order drug request between doctor and distributor
* Order drug request between distributor and sales person
## Roles
* System Admin Role
* Patient Role
* Doctor Role
* Lab Assistant Role
* Scheduler Role
* Sales Person Role
* Distributor Role
* Hospital Admin Role
* Manufacturer Admin Role
* Distributor Admin Role
#### System Admin Role
* System Admin can login to the main system
* Can manage all the networks and can add new networks
* Can add and manage the enterprises
* Can add and manage the enterprise admins
#### Hospital Admin Role
* *Manage Employee User Accounts*-Can assigning user name and password 
* *Manage Patients*-Can view and add new patients
* *Manage Organization*-Can add organizations to the networks
* *Manage Employee*-Can add employees to a particular organization
#### Manufacture Admin Role
* *Manage Employee User Accounts*-Can assigning user name and password 
* *Manage Organization*- Can add organizations to the networks
* *Manage Employee*- Can add employees to a particular organization
* *Manage Drugs*- Add and view the drug details like dosages, components and their percentages
#### Distributor Admin Role
* *Manage Organization*- Can add organizations to the networks
* *Manage Distributor User Account*- Can assigning user name and password 
* *Manage Employees*- Can add employees to a particular organization
* *Manage Drugs*- Add and view the details and dosages of the drugs list ordered to manufacture
#### Patient Role
* Patient requests scheduler for appointment 
* View the appointment details like appointment date, doctor and lab assistant names
* View his/her health reports which include test result status and date
* View his personal details like first name, last name, address, age
#### Doctor Role
* View the test results of patients
* View next appointment patient details
* Prescribe medicine for patients based on their reports
#### Lab Assistant Role
* Process the test requests from the scheduler
* Submit the test result details which include T3, T4, TSH 
#### Scheduler Role
* View the patient appointments by date
* Add patients to todays appointment list
* View and process the patients appointment requests 
* Requests doctor for appointment
#### Distributor Role
* View the list of medicines ordered by doctor and process the work requests 
#### Sales Person Role
* View and list of medicines ordered by distributor and process the work requests 
## Object Model
![obj model](https://user-images.githubusercontent.com/25045759/27311413-bc3e6448-552e-11e7-8b44-d77e5fd7455c.jpg)
## Screens
![1w](https://user-images.githubusercontent.com/25045759/27311414-bc3ee238-552e-11e7-846c-fc280dfde5e9.png)
![2w](https://user-images.githubusercontent.com/25045759/27311412-bc3de64e-552e-11e7-8983-c0b6d6675668.png)
![3w](https://user-images.githubusercontent.com/25045759/27311411-bc3d315e-552e-11e7-80fd-a188a7945729.png)
![4w](https://user-images.githubusercontent.com/25045759/27311415-bc4551fe-552e-11e7-9a05-5ec17097a4a0.png)
## Conclusion
Analysis is done successfully and reports are generated
