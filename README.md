# ONLINE JOB SEARCH PORTAL

### Existing System
The existing system for job recruitment includes traditional methods like Employment agencies, advertising through newspapers, televisions and radios, college fairs etc., which are too slow and stressful. With the advancement of internet, jobseekers rely on the online job portals, which makes the job search efficient.
Main problems in the existing system
*	Time Consuming
*	Stressful
*	Challenging

### Proposed System
Job Search Portal is a Java-based web application that provides functionalities of e-recruitment. This application will be developed using spring-hibernates using STS (Spring Tool Suite IDE)
Main advantages of proposed system
*	Cost and Time efficient
*	Portable

### Objectives
*	The main objective of this web application is to provide flexibility to the jobseekers by providing the functionalities of both job search and job application in a single application.
*	This application provides an effective means for the employers to post job vacancies and view the job applications by the interested applicants in a single application.
* Employers can also view the reviews provided by the jobseekers.

### Use cases
<img width="700" height="550" alt="usecase 2" src="https://user-images.githubusercontent.com/25045759/27299344-19b283aa-54fa-11e7-809b-52d01ee4ff3c.png">

### Actors:
These are Actors of the system
*	Admin
*	Unregistered Employer
*	Register Employer
*	Unregistered Jobseeker
*	Registered Jobseeker.

### Use cases:
* *Register Account*- This use case denotes a set of actions required for Employer and Job seeker to register with the application.
* *Login*- This use case denotes a set of actions required for Employer and Job seeker to login into the application.
* *Activate/De-activate Account*- This use case denotes a set of actions required for admin to activate or de-activate the Employers. Soon after activation or deactivation an Email will be send to particular Employee
* *View Employers*- This use case denotes a set of actions required for admin to view the Employers that are registered with the application.
* *Activate/De-activate Job Post*- This use case denotes a set of actions required for Employer to change the status of the Job Post.
* *View Applicants for a Job Post*- This use case denotes a set of actions required for Employer to view the list of applicants for a job post.
* *View Reviews*- This use case denotes a set of actions required for Employer to view Reviews provided by the applicants.
* *View Job Posts*- This use case denotes a set of actions required for Employer to view all the jobs posted by the Employer.
* *Search Job Posts*- This use case denotes a set of actions required for Job Seeker to search available and active jobs.
* *Apply for Job*- This use case denotes a set of actions required for Job Seeker to apply for an available job vacancy.
#### Add Reviews- 
This use case denotes a set of actions required for Job Seeker to add Reviews for an organization that can be viewed by the Employer.
### Classes Details
#### Controller classes: 
It includes five controller classes
*	AdminController
*	JobSeekerController
*	EmployerController
*	LoginController
*	RegistrationController
These classes are responsible for handling HTTP requests and returns HTTP response.
#### Service classes: 
It includes five Service classes
*	AdminService
*	JobSeekerService
*	EmployerService
*	EmailService
*	RegistrationService
*	UserDetailsServiceImpl
The Controller classes pulls data from the request and passes it to the appropriate service class. The Service classes are responsible for called or more DAO class.
#### DAO classes: 
It includes four DAO classes
*	UserDAO
*	ReviewDAO
*	JobDAO
*	AppliedjobDAO
The DAO classes contains the query code and directly interacts with the model classes. The DAO classes send back model classes to the Controller class in order to be sent to the view layer.
### Database Details
*	jobs table: holds details of jobs posted by the Employer
*	jobsapplication table holds details of jobs applied by the job seeker like the status and user id, jobid
*	reviews table: holds the reviews for interview like salary rating, work life, comments, review date etc provided by the jobseeker
*	users table: holds the personal information of the users like address, emailid, username, password etc
### Screens
* As soon as we run the application this is the first page that. Used Velocity concepts to design this screen. We can see Created index.vm used div element to get the grid format
* Login refers to ${contextPath}/home and login controller will check the login credentials with different roles if they do not match controller will direct to the error page
* Register refers to ${contextPath}/register and Register controller will validate the form and on click of submit button
![1](https://user-images.githubusercontent.com/25045759/27300095-8b7c9ffa-54fc-11e7-8600-7b5feb93bfb2.png)

<img width="338" alt="2 2" src="https://user-images.githubusercontent.com/25045759/27300709-97caf084-54fe-11e7-8275-afacf72fac59.png">

<img width="338" alt="2" src="https://user-images.githubusercontent.com/25045759/27300708-97c8cc6e-54fe-11e7-8c94-844455ce8341.png">

![4](https://user-images.githubusercontent.com/25045759/27300098-8b829e00-54fc-11e7-8677-5f9ed5a7f117.png)

![5](https://user-images.githubusercontent.com/25045759/27300097-8b823ef6-54fc-11e7-9985-b881852c36b6.jpg)

![6](https://user-images.githubusercontent.com/25045759/27300096-8b80e812-54fc-11e7-95bf-d2f65d4a1f6f.png)
![7](https://user-images.githubusercontent.com/25045759/27300101-8b86ab6c-54fc-11e7-9cf2-7cde22842a70.png)
![8](https://user-images.githubusercontent.com/25045759/27300099-8b84c25c-54fc-11e7-9e49-e53bad198879.png)
![9](https://user-images.githubusercontent.com/25045759/27300100-8b85aba4-54fc-11e7-9a1b-76a8b1dd66e7.png)
![10](https://user-images.githubusercontent.com/25045759/27300104-8b8ffdc0-54fc-11e7-9759-5ea452889cca.png)
![11](https://user-images.githubusercontent.com/25045759/27300105-8b9091fe-54fc-11e7-9fdc-50c043b14e06.png)
![12](https://user-images.githubusercontent.com/25045759/27300102-8b8ed710-54fc-11e7-83ad-f5c1763d200a.png)
![13](https://user-images.githubusercontent.com/25045759/27300106-8b913352-54fc-11e7-9801-06b0baaf4bce.png)
![14](https://user-images.githubusercontent.com/25045759/27300103-8b8f2436-54fc-11e7-91b0-a854f0b2f324.png)
![15](https://user-images.githubusercontent.com/25045759/27300107-8b93bfd2-54fc-11e7-8c6c-9159eaa566aa.png)
![16](https://user-images.githubusercontent.com/25045759/27300109-8b9bfb98-54fc-11e7-9a73-4eceec042919.png)
![17](https://user-images.githubusercontent.com/25045759/27300108-8b9b6c1e-54fc-11e7-8a2a-f49606166a3e.png)
![18](https://user-images.githubusercontent.com/25045759/27300110-8b9e9d26-54fc-11e7-92d7-0946afc3ddcf.png)

