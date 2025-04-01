## 📚**Job Portal Application**

### 📄**Description**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The Job Portal Application is a web-based platform built using Spring Boot and Thymeleaf to allow users to view job postings and add new job opportunities. It simulates a basic CRUD (Create, Read, Update, Delete) operation where job posts can be added dynamically and displayed to users.

___

### ⚡️**Features**
&nbsp;&nbsp;&nbsp;&nbsp;**.** Add new job posts with relevant details.
 
&nbsp;&nbsp;&nbsp;&nbsp;**.** View all available job posts.


&nbsp;&nbsp;&nbsp;&nbsp;**.** Dynamic rendering of job information using Thymeleaf.

&nbsp;&nbsp;&nbsp;&nbsp;**.** Backend integration with Spring Boot services.

***

### 🛠️**Tech Stack**
#### Backend:
☕ Java

🌱 Spring Boot (Spring MVC, Dependency Injection)

📚 Spring Boot Starter Web

🎨 Thymeleaf
#### Frontend:
📝 HTML, CSS

***

### 🚀 How to Run the Project
#### 1. Clone the Repository
            `git clone https://github.com/your-username/job-portal-app.gitcd job-portal-app`
#### 2. Open in IDE
&nbsp;&nbsp;&nbsp;&nbsp;**.** Open the project in IntelliJ IDEA, Eclipse, or any Java IDE.

&nbsp;&nbsp;&nbsp;&nbsp;**.** Make sure Maven or Gradle is configured.

#### 3. Run the Application
            `mvn spring-boot:run`
#### 4. Access Application
            `http://localhost:8080/home`
___

### 🎨 Thymeleaf HTML Templates
#### home.html
&nbsp;&nbsp;&nbsp;&nbsp;**.** Home page with options to add a job or view all jobs.

&nbsp;&nbsp;&nbsp;&nbsp;**.** Button links to addjob.html and viewalljobs.html.
#### addjob.html
**.** Form to add a new job post with required fields:

&nbsp;&nbsp;&nbsp;&nbsp;**-** Job ID

&nbsp;&nbsp;&nbsp;&nbsp;**-** Job Profile

&nbsp;&nbsp;&nbsp;&nbsp;**-** Description

&nbsp;&nbsp;&nbsp;&nbsp;**-** Required Experience

&nbsp;&nbsp;&nbsp;&nbsp;**-** Tech Stack

**.** Submits data to /addjob using POST.
#### viewalljobs.html
**.** Displays a list of all job posts dynamically using Thymeleaf.
#### success.html
**.** Shows success message after adding a job.

---

### 🔥 API Endpoints

| Method | Endpoint      | Description            |
|--------|-------------|------------------------|
| GET    | /home       | Displays home page     |
| GET    | /viewalljobs | View all job posts     |
| POST   | /addjob     | Add a new job post     |

___

### ⚙️ Dependencies
#### Add the following dependencies in pom.xml:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

---

### 📄Controller (JobController.java)
```
@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model model) {
        List<JobPost> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "viewalljobs";
    }

    @GetMapping("/addjob")
    public String addJobForm(Model model) {
        model.addAttribute("job", new JobPost());
        return "addjob";
    }

    @PostMapping("/addjob")
    public String addJob(@ModelAttribute JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }
}
```

---
### 🎯 Future Enhancements
**.** 📝 Add Edit/Update functionality.

**.** 🗑️ Implement Delete operation.

**.** 🗃️ Integrate a Database (MySQL/PostgreSQL).

**.** 📧 Add Email Notifications for job postings.
___

### 👩‍💻 Author
**.** Gopika Kotakala Saranya

**.** 📧kotakalagopika@gmail.com

**.** 🌐linkedin.com/in/kotakala-gopikasaranya-480364289
___
### 📝 License
This project is licensed under the MIT License - see the LICENSE.md file for details.
___
