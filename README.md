# QA Issue Tracker Automation

An entry-level QA automation testing project built to validate and test my Spring Boot Issue Tracker REST API.

This project demonstrates hands-on experience with:

- API testing
- Automated regression tests
- Rest Assured + JUnit 5 frameworks
- Backend validation using a working REST service

---

## 🚀 Project Purpose

The goal of this project is to create a real-world QA automation suite that tests the endpoints of my **Issue Tracker API**, similar to what QA Engineers and System Verification Testers build in industry environments.

This project focuses on:

✅ Writing automated test cases  
✅ Validating REST API responses  
✅ Supporting regression testing  
✅ Building a scalable test structure

---

## 🔧 Technologies Used

- Java 21
- Maven
- JUnit 5
- Rest Assured
- Spring Boot REST API (tested system)

---

## ✅ Current Test Coverage (In Progress)

So far, the automation suite includes:

- Creating a new issue (`POST /api/issues`)
- Fetching all issues (`GET /api/issues`)
- Validating HTTP status codes and JSON fields

More endpoints and deeper assertions will be added next.

---

## 📂 Project Structure

```bash
src/test/java/com/ambrogio/qa/
│
├── config/
│   └── TestConfig.java        # Base configuration and API setup
│
├── issues/
│   └── IssuesApiTests.java    # Automated tests for Issue endpoints
│
└── util/                      # Utility helpers (future expansion)
▶️ How To Run Tests
Make sure the Issue Tracker API is running locally:

http://localhost:8080
Then run:

mvn clean test
✅ Example Test Output
Tests run: 2, Failures: 0, Errors: 0
BUILD SUCCESS
🧠 Planned Next Steps
This project is actively being expanded with:

Negative test cases (400/404 validation)

Assignment endpoint testing (PUT /assign)

Authentication testing

CI automation (GitHub Actions)

👤 Author
Ambrogio Bailey
Self-taught backend + QA-focused developer building real-world automation skills.

GitHub: https://github.com/AmbrogioBailey
LinkedIn: https://www.linkedin.com/in/ambrogio-bailey-b67529373/


