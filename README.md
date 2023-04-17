# OOP-FYP-Management-Project

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h3 align="center">Final Year Project (FYP) Management System</h3>

  <p align="center">
    A real-world application of Object-Oriented Programming for Management System
    <br />
    <a href="https://github.com/Ignitedgene/OOP-FYP-Management-Project"><strong>Explore the docs »</strong></a>
    <br />
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project 📖

This FYP Management System was built for our SC2002 - Object Oriented Programming Group Project.

We incorporated Entity-Controller-Boundary (ECB) code structure, SOLID principles, and other OO concepts such as Encapsulation, Abstraction, Inheritance and Polymorphism. This enables our application to achieve **high cohesion and loose coupling** which facilitates future improvement works to the application.

**Here's why!**
* To provide better code maintainability, readability and extensibility. 
* Facilitates future modifications to the application and minimizes impact of change on the program.
* Separation of concerns, avoiding over-dependencies between respective components.   

<br> 

<!-- Object Oriented Programming Concepts -->
## Object-Oriented Programming Concepts 🖌️

### Entity-Controller-Boundary Structure
* `Entities` are objects representing the system data, ensuring that data manipulations are consistent throughout the application and adheres to a strict set of rules.
* `Boundaries` are objects that interface with the systems. They lie on the periphery of the system (but still within it), and often interact with the users, such as displaying the user menu and getting user inputs.
* `Controllers` are objects that act as the mediator between Boundaries and Entities, allowing us to modify the logic control.

### SOLID Principles 
* `Single Responsibility Principle [S]` 
  - Each class is assigned to **only one single responsibility**, and only one reason to change it.
  - Enables lower coupling as there will be fewer dependencies across different classes.
  
* `Open-Closed Principle [O]`
  - **Closed for modification but is open for extension** with other entities, allowing for future extension of new classes. 
  - Reduces the need more modification in the baseclass which would impact functionalities.
  
* `Liskov Substitution Principle (L)`
  - Each derived subclass should be **substitutable with its base class**.
  - Interchangeable usages without having adverse effects on the overall program behaviour.
  
* `Interface Segregation Principle (I)`
  - Interfaces are suited for each individual functionality, classes can implement whenever necessary.
  - Promotes **reusability** of existing code.  

* `Dependency Inversion Principle (D)`
  - Ensure that higher level modules do not depend on lower level modules.
  - Depend on abstractions and not concrete methods.

<p align="right"></p>

<br> 

## Built With 🔨
> ![Java][Java]

> ![Github][Github]

## Our Learning Journey 📖
During the project, our team faced many hurdles along the way which hindered our team’s progress. Some of the difficulties and how we worked around them are as listed below. Moving ahead, we will take into consideration what we have learnt through this project and improve our skills.

### Principles:
`1. Adapt away from the usual procedural programming to object-oriented programming.` 
  - Before diving right into the programming, we drafted out our UML diagram to better visualise our design and alter it accordingly to the object-oriented programming principles.
  - 
`2. Applying SOLID principles and the Entity-Control-Boundary structure.`
  -  For this, our team watched multiple videos and did secondary research to better understand and apply these principles to our design. Open discussions also helped greatly. 
  -  
`3. UML diagram design and visual aspects.` 
  - Our team had many different drafts of the UML diagram design and due to its complexity, we found it hard to make it readable and visually neat.

### Programming:
`1. Ensure that all possible different scenarios and errors are accounted for.` 
  - While in the process of programming, we faced many challenges when handling the different test cases and scenarios. We had to repeatedly check back to the project requirements and change our code accordingly. Listing down assumptions we made beforehand was useful as well.
  
`2. Tracking the source of problems when debugging.`
  - Our team found it difficult to find the root cause of problems due to the abstraction across multiple folders andsubfolders.

`3. Collaboration and combination of the different parts.` 
  - Since we were working on the code separately, we had an issue of combining our codes into one overall main code. This issue was rectified with the use of Github and clear communication. Our team learn alot about Github eco-system and how to collaborate across teams using Branches, Commits, Pull Requests. 

Thank you for taking your time to read this documentation! I truly appreciate it :D

[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Github]: https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white
