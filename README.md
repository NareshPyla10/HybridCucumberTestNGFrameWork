# HybridCucumberJunitFrameWork

This hybrid UI automation Maven project automates the E-commerce Store application.
This project is built using  Selenium, JUnit for test cycle management, and Cucumber BDD for writing test scenarios. 
The primary programming language used is Java. The framework is designed to provide a robust and scalable solution for automating various end-to-end test cases, ensuring high-quality software delivery.

### Table of Contents
* [Pre-Requisites](#pre-requisites)
* [Installation](#installation)
* [Running Tests](#running-tests)


### Pre-Requisites

* Java 22 or later
* Maven 3.6 or later
* IntelliJ IDEA

### Installation

#### 1. Clone the repository:

git clone 
cd  HybridCucumberJunitFrameWork


#### 2. Install dependencies:

mvn clean install


### Running Tests

* Update the browser property in the Sample.properties file with the required test browser (i.e., chrome, edge, firefox).
* Update the test data in TestData.json in the resources folder if needed.
* In the  testNGRunner package, right-click on required runner file and select the "Run" option from the context menu.
* Cucumber extent reports are generated and stored in target folder