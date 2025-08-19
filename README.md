**REST Assured Test Automation Framework

Welcome to the REST Assured Test Automation Framework** – a comprehensive, data-driven, hybrid API testing solution built with modern Java tooling and best practices. This framework is designed for efficient, maintainable, and scalable REST API testing with advanced reporting and CI/CD readiness.

🚀 **Tech Stack**

* Java (JDK > 22)
* 
* REST Assured — API test automation
* 
* Apache POI — Excel data handling
* 
* TestNG — Test orchestration
* 
* Maven — Build automation & dependency management
* 
* AssertJ — Advanced & fluent assertions
* 
* Jackson API & GSON — Flexible JSON parsing/serialization
* 
* Log4j — Logging framework
* 
* Allure Report — Clean, interactive test reports
* 
* Jenkinsfile — CI/CD pipeline automation


📁 **Folder Structure**

project-root/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/companyname/projectname/
│   │             ├── configs/
│   │             ├── base/
│   │             ├── utils/
│   │             ├── clients/
│   │             ├── data/
│   │             └── pojos/
│   └── test/
│       └── java/
│             └── com/companyname/projectname/
│                   ├── tests/
│                   ├── testdata/
│                   └── listeners/
│
├── testdata/         // Excel or JSON data files
├── reports/          // Allure/Log files
├── logs/
├── Jenkinsfile
├── pom.xml
├── .gitignore
└── README.md
* configs/: Project configuration (properties, environment files)
* 
* base/: Base and utility classes for test setup/teardown
* 
* utils/: Utility classes (Excel, JSON parsing, etc.)
* 
* clients/: REST Assured client/request builder classes
* 
* data/: Data layer/access utilities
* 
* pojos/: Data models (POJOs for request/response bodies)
* 
* tests/: Test cases grouped by module or endpoint
* 
* testdata/: Data-driven test support files


⚙️ **Getting Started**

1. Prerequisites:

* Java JDK 22+
* 
* Maven 3.8+
* 
* (Optional) Jenkins for CI

2. Clone the repository:

git clone https://github.com/companyname/projectname.git
cd projectname


3. Install dependencies:

mvn clean install

4. Run tests:

mvn test

* Allure report:

mvn clean test allure:serve


🛠️ **Key Features**
* Hybrid (data-driven & modular) design supports both reusability and extensibility
* 
* Advanced assertions using AssertJ for expressive, chainable checks
* 
* Data-driven API tests using POJOs and Excel data (Apache POI)
* 
* Logging and reporting integration for robust CI/CD
* 
* Pluggable CI/CD support with Jenkins


📝 **Build & Execute on Jenkins**
* The included Jenkinsfile provides a ready-to-use Jenkins pipeline script for automated build and test.

📄 **Reporting**
* Rich, interactive Allure reports are generated after each test execution under the reports/ directory.

🤝 **Contributing**
* PRs are welcome! Open an issue to discuss what you want to change.

👨💻 **Contact**
**Maintainer**: Kavya Sree Vuragayala
**Email**: vuragayalakavyasree18@gmail.com