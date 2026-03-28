import model.Doctor;
import model.Patient;
import service.HospitalManager;
import util.FileHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalManager manager = new HospitalManager();

        manager.setPatients(FileHandler.loadPatients());
        manager.setDoctors(FileHandler.loadDoctors());
        manager.setAppointments(FileHandler.loadAppointments());

        int choice;

        do {
            System.out.println("\n===== HOSPITAL APPOINTMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. View Appointments");
            System.out.println("8. Save Data");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Problem: ");
                    String problem = sc.nextLine();

                    System.out.print("Enter Priority Type (Emergency / Senior Citizen / Normal): ");
                    String priority = sc.nextLine();

                    Patient patient = new Patient(patientId, patientName, age, problem, priority);

                    if (manager.addPatient(patient)) {
                        System.out.println("Patient added successfully.");
                    } else {
                        System.out.println("Patient ID already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();

                    Doctor doctor = new Doctor(doctorId, doctorName, specialization);

                    if (manager.addDoctor(doctor)) {
                        System.out.println("Doctor added successfully.");
                    } else {
                        System.out.println("Doctor ID already exists.");
                    }
                    break;

                case 3:
                    manager.viewPatients();
                    break;

                case 4:
                    manager.viewDoctors();
                    break;

                case 5:
                    System.out.print("Enter Appointment ID: ");
                    int appointmentId = sc.nextInt();

                    System.out.print("Enter Patient ID: ");
                    int bookPatientId = sc.nextInt();

                    System.out.print("Enter Doctor ID: ");
                    int bookDoctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Preferred Slot (10:00 AM / 11:00 AM / 12:00 PM / 02:00 PM / 03:00 PM / 04:00 PM): ");
                    String slot = sc.nextLine();

                    String result = manager.bookAppointment(appointmentId, bookPatientId, bookDoctorId, slot);
                    System.out.println(result);
                    break;

                case 6:
                    System.out.print("Enter Appointment ID to cancel: ");
                    int cancelId = sc.nextInt();

                    if (manager.cancelAppointment(cancelId)) {
                        System.out.println("Appointment cancelled successfully.");
                    } else {
                        System.out.println("Appointment not found or already cancelled.");
                    }
                    break;

                case 7:
                    manager.viewAppointments();
                    break;

                case 8:
                    FileHandler.savePatients(manager.getPatients());
                    FileHandler.saveDoctors(manager.getDoctors());
                    FileHandler.saveAppointments(manager.getAppointments());
                    System.out.println("Data saved successfully.");
                    break;

                case 9:
                    FileHandler.savePatients(manager.getPatients());
                    FileHandler.saveDoctors(manager.getDoctors());
                    FileHandler.saveAppointments(manager.getAppointments());
                    System.out.println("Data saved. Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}
