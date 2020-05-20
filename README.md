# Software-Quality
## Demonstrating Software Quality

### 1. Scrum Sprint Backlog and Task Estimation
| Activity ID  | User Stories  |      To-Do     |  In Progess | Done | Priority | Estimation |
|----------:|---------------|----------------|-------------|------|-----------|------:|
|  1  |  User creates a Survey | To-Do      |      In Progress     |  :heavy_check_mark:  |    1  |   4 hours  |
|  2  |  User adds questions to Survey  | To-Do      |  In Progress            |  :heavy_check_mark:  |     1      |  3 hours  |
|  3  | User can view all Survery Questions |   To-Do   |      In Progress  |  :heavy_check_mark:  |     2      | 3 hours  |
|  4  | User can search for a Survey |    To-Do    |     In Progress   | :heavy_check_mark:      |      1     |  3 hours  |
|  5  | User can submit answers to the Survey |   To-Do  |    In Progress    |  :heavy_check_mark:     |      2     | 2 hours  |
|  6  | Calculate the average score for a Survey |  To-Do    |    In Progress       |  :heavy_check_mark:   |      3     | 3 hours |  
|  7  | Calculate the standard deviation for a Survey|  To-Do  |   In Progress |  :heavy_check_mark:    |      3    | 2 hours  |
|  8  | Calculate the Min and Max scroes for a Survey|   To-Do    |   In Progress   |  :heavy_check_mark:     |      3      | 2 hours  |

### 1.1 Description of Task Estimation
When estimating the time needed to complete these task I gave a longer time frame for completeing the first of the calcuations that I would tackle as I think that once I become comfortable with designing the first calcuation function the average score for a survey, the following ones would be less time consuming as I wil have a better understanding of how to go about implementing such a function.
With regards to the first User story creating a survey I estimated that I would need the greatest amount of time to complete this task as it involves the greatest amount of work and also all of the other activities stem from this as in, the user needs to able able to create a survey initially in order to perform the other User stoires.
The remaining tasks I gave a similar estimation to each of these as I think they all should take roughly the same amount of time to complete.

### 1.2 Velocity metric
The scrum velocity metic is the measure of work completed by a development team within each Sprint. The devolopment team estimates the time and effort needed to develop and test each user story. Velocity is calculated at the end of the Sprint by totaling the Points for all fully completed User Stories.
The formula for the velocity metric is straightforward. It is calculated by dividing the total story points completed by the number of Sprints in which they were completed, example if a total of 60 story points are completed in a totalof 2 Sprints (60 story points/2 Sprints) the teams veleocity would be 30 points per Sprint.
When considering this calculation the team must discuss wheather they are willing to include partially completes stories or only fully completed stories, also the team might work on other tasks such as bug problems or support tasks during the Sprint and these take away time and effort from the Sprints user stories. Sprints should be kept at a consistant lenght as this will effect the velocity, making it inaccurate. The Velocity metric allows developers to understand how much they can get done, and plan their workload for future sprints.

### 2 Test-Driven development
Test-driven development is the process that relies on the repetition of a very short development cycle. Very specific test cases are created and the code is improved so that the tests pass. 

| Test Case | Test Scenario | Expected Result|Actual Result| Pass/Fail | 
|----------:|---------------|----------------|-------------|------:|
|1|Start Survey|User is able to begin the survey|As Expected| Pass|


```
 public void user_can_start_Survey(){
        onView(withId(R.id.btnStart)).perform(ViewActions.click());
    }
 ```
 | Test Case | Test Scenario | Expected Result|Actual Result| Pass/Fail | 
|----------:|---------------|----------------|-------------|------:|
|2|Questions Stored|survey Questions are stored |As Expected| Pass|
```
 public void testCreateDB(){
        QuizDbHelper quizDbHelper = new QuizDbHelper();
        SQLiteDatabase db = quizDbHelper.getWritableDatabase();
        assertTrue(db.isOpen());
        db.close();

    }
  ````
  
### 3 Test coverage metric
  
### 4 Team version-control
Version control is a way of making sure you know which is the current iteration of a project.
Version control is important because then you know everyone is working from the same version of a porject.
The Gitflow Workflow defines a strict branching model designed around the project release. This provides a robust framework for managing larger projects. Instead of a single master branch, this workflow uses branches to record the history of the project.
When we look at version-control and the creation and merging of branches I to followed these guidlines;
* The use of descriptive commit messages so when examining the change I would be able to understand clearly the purpose of the change. This is also useful when looking for specific commits as you can search through the commit messages.
* Making each commit have a single purpose, this makes it easier to locate features when fixing bugs
#### The WorkFlow
* git pull request
* Any Updates/Additions
* Make necessary changes to code
* git commit
* git push
  
### 5 Code-review checklist
A Code review is a software quality assurance activity in which one or several people check a program mainly by viewing and reading parts of its source code. At least one of the persons must not be the code's author. A code review is used to determine the quality of the code, find defects in the code, they also are madatory in some cases such as air traffic software. The following is a check list a review should use when performing a code review. The review should ask themselves.
#### General
* Can I understand the code easily?
* Does the code use meaningful Naming conventions.
* Does the code conform to agreed indentations and formatting.
* Is the code duplicated more than once.
* Is the code commented effectivly.
* Does the code validate inputs.
#### Testing
* Can any of the code be replaced with libraries or built-in functions
* Do the unit tests actually test functionality
* Are any functions too big, try to not give class or fuctions too many responsibilities.
* Does the code meet the functional and None-functional requirments





