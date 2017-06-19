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

### Actors:
These are Actors of the system
*	Admin
*	Unregistered Employer
*	Register Employer
*	Unregistered Jobseeker
*	Registered Jobseeker.

### Use cases:
#### Register Account-
This use case denotes a set of actions required for Employer and Job seeker to register with the application.
#### Login-
This use case denotes a set of actions required for Employer and Job seeker to login into the application.
#### Activate/De-activate Account-
This use case denotes a set of actions required for admin to activate or de-activate the Employers. Soon after activation or deactivation an Email will be send to particular Employee
#### View Employers-
This use case denotes a set of actions required for admin to view the Employers that are registered with the application.
#### Activate/De-activate Job Post- 
This use case denotes a set of actions required for Employer to change the status of the Job Post.
#### View Applicants for a Job Post-
This use case denotes a set of actions required for Employer to view the list of applicants for a job post.
#### View Reviews- 
This use case denotes a set of actions required for Employer to view Reviews provided by the applicants.
#### View Job Posts-
This use case denotes a set of actions required for Employer to view all the jobs posted by the Employer.
#### Search Job Posts-
This use case denotes a set of actions required for Job Seeker to search available and active jobs.
#### Apply for Job-
This use case denotes a set of actions required for Job Seeker to apply for an available job vacancy.
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
