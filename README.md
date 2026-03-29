[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
Hospital Appointment Management System with Priority-Based Scheduling

---

## Problem Statement (max 150 words)
Traditional hospital appointment systems are often manual or poorly managed, leading to long waiting times, inefficient scheduling, and lack of prioritization for emergency cases. This project aims to develop a console-based Hospital Appointment Management System that automates patient scheduling, ensures efficient slot allocation, and handles conflicts intelligently. A key feature of the system is priority-based scheduling, where emergency or high-priority patients can be accommodated even if slots are occupied. The system also maintains persistent data using file handling, ensuring that records are not lost between sessions. Overall, the project demonstrates how Object-Oriented Programming principles can be used to design a modular, scalable, and efficient real-world system.

---

## Target User
- Hospital Reception Staff  
- Patients (indirectly through staff interaction)  
- Small clinics or basic healthcare setups  

---

## Core Features

- Add and manage patient and doctor records  
- Book and cancel appointments  
- Priority-based scheduling (emergency handling) ⭐  
- Automatic slot conflict detection  
- Suggest next available slot if occupied  
- File-based data persistence (save/load system data)  

---

## OOP Concepts Used

- Abstraction:  
  HospitalManager class hides complex booking and scheduling logic from the main program.

- Inheritance:  
  Can be extended for future enhancements (e.g., different types of users or staff roles).

- Polymorphism:
  Method flexibility in handling different operations (e.g., booking, cancelling).

- Exception Handling:
  Handles invalid inputs, duplicate entries, and booking conflicts gracefully.

- Collections / Threads:  
  Java Collections (ArrayList) used to store patients, doctors, and appointments dynamically.

---

## Proposed Architecture Description
The project follows a modular layered architecture:

- model package: Contains core entities (Patient, Doctor, Appointment)  
- service package: Contains business logic (HospitalManager)  
- util package: Handles file operations (FileHandler)  
- Main class: Acts as entry point and user interface  

Flow:
User → Main → HospitalManager → Model + FileHandler


This separation improves maintainability, readability, and scalability.

---

## How to Run

1. Clone the repository  
2. Open in any Java IDE (IntelliJ / Eclipse)  
3. Navigate to `Main.java`  
4. Run the program  
5. Use console menu to:
   - Add patients/doctors  
   - Book appointments  
   - Handle conflicts  

---

## Git Discipline Notes
Minimum 10 meaningful commits completed showing incremental development:
- Model classes added step-by-step  
- Service logic implemented progressively  
- File handling integrated later  
- Final integration and testing commits  

Each commit reflects a specific feature or improvement.
