# Taskin-Project

Suppose that you are working in a company as a software developer. Your company decided to develop
a forum application like https://stackoverflow.com. A web application and a mobile application will be
developed. You are included in the team that is responsible for developing server-side services. Your
back-end application will provide services to these applications.
You should develop all required Restful services which are required for web/mobile applications. In the
next page, you can find some screenshots from Stackoverflow. Parts enclosed in red box, are requested
functionalities for both web and mobile applications.
Backend Functional Requirements:
1. You should create a Spring Boot web application. You should use JPA and Spring Data JPA. You are
not allowed to use pure JDBC. But you can use native SQL queries in the Data JPA Repositories.
2. Develop all necessary Restful services to satisfy all the UI service requirements listed below.
3. Draw a class diagram for your model classes.
4. Generate an API documentation for your Restful services using OpenAPI (Swagger)
5. You are not allowed to return Entity Objects from Restful services. You must return custom DTOs.
You should use the mapstruct library (https://mapstruct.org/) for such conversions.
6. Database selection is free of choice.
7. You should initialize your database automatically with at least one question (with title, text, tags,
user) and two users. You are free to select any method you like for initialization.
UI Service Requirements (Frontend Functional Requirements)

1. Getting all the questions. User Interface (UI) only needs to display the question title, first 100
characters of question description, question tags, asked date, asked by, answer count, vote count.
Optionally, the web application can send tags during the service call. If there are some tags in the
request object, you should return all questions which have those tags. (Ex: getting all springboot
related questions.)
2. Getting all information about a specific question for displaying question details on the screen.
3. Adding a new question. UI should send question title, question text, tags, and question owner to the
backend. UI should get newly added question’s id.
4. Adding a new answer for a question. In addition to the Question ID, UI should also send the following
fields to the back-end application: answer text and user. UI needs newly added answer’s id and
related question’s id.
5. Adding a new comment for a question. In addition to the Question ID, UI should also send the
following fields to the back-end application: comment text and user. UI needs newly added
comment’s id and related question’s id.
6. Adding a new comment for an answer. In addition to the Answer ID, UI should also send the
following fields to the back-end application: comment text and user. UI needs newly added
comment’s id and related answer’s id.
7. Voting a question, an answer, or a comment. UI needs to display updated vote count on the screen.
8. Deleting a specific comment(any types of comments)
9. Updating an answer
10. Updating a comment
