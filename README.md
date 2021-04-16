# Gramotagen v0.90
#####by Dmitry 'flatura' Morozov 2020-2021

###Getting started
Gramotagen is an web application made to generate PDF-diploma files for pupil's request by validating its legit through the DB.   

### Reference Documentation
Simple backend created using Spring Boot 2.3.1 with iTextPDF 5.5.7 framework
Frontend is provided by Thymeleaf through these endpoints:

GET http://localhost:8080/ - form to check personal data (name, middle name, surname)

GET http://localhost:8080/demo - PDF-generator demonstration
 
GET+POST http://localhost:8080/add - add a new diploma one by one. Validating by hardcoded password 
 
