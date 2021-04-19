# Gramotagen v0.90
##### by Dmitry 'flatura' Morozov 2020-2021

Gramotagen is a web-service application for generating PDF-diploma files by pupil's request with validating its legit through the DB.   
Current home-endpoint leads to form with birthday validation excluded 'cause of customer told so.

#### Stack
Spring Boot 2.3.1, PostgreSQL 13, Thymeleaf 2.3.1, Bootstrap 4.3.1

### Reference Documentation

Simple backend created using Spring Boot 2.3.1 with iTextPDF 5.5.7 framework
Frontend is provided by Thymeleaf through these endpoints:

GET http://localhost:8080/ - form to check personal data (name, middle name, surname)

GET http://localhost:8080/demo - PDF-generator demonstration
 
GET+POST http://localhost:8080/add - add a new diploma one by one. Validating by hardcoded password 
 
