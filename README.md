# OOP-FYP-Management-Project

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h3 align="center">Final Year Project (FYP) Management System</h3>

  <p align="center">
    A real-world application of Object-Oriented Programming for Management System
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

This FYP Management System was built for our SC2002 - Object Oriented Programming Group Project.

We incorporated Entity-Controller-Boundary (ECB) code structure, SOLID principles, and other OO concepts such as Encapsulation, Abstraction, Inheritance and Polymorphism. This enables our application to achieve **high cohesion and loose coupling** which facilitates future improvement works to the application.

**Here's why!**
* To provide better code maintainability, readability and extensibility. 
* Facilitates future modifications to the application and minimizes impact of change on the program.
* Separation of concerns, avoiding over-dependencies between respective components.   


<!-- Object Oriented Programming Concepts -->
## Object-Oriented Programming Concepts 

Entity-Controller-Boundary Structure
* `Entities` are objects representing the system data, ensuring that data manipulations are consistent throughout the application and adheres to a strict set of rules.
* `Boundaries` are objects that interface with the systems. They lie on the periphery of the system (but still within it), and often interact with the users, such as displaying the user menu and getting user inputs.
* `Controllers` are objects that act as the mediator between Boundaries and Entities, allowing us to modify the logic control.

SOLID Principles 
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

<p align="right">(<a href="#readme-top">back to top</a>)</p>


