package util;

import model.Appointment;
import model.Doctor;
import model.Patient;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String DATA_FOLDER = "data";
    private static final String PATIENT_FILE = DATA_FOLDER + "/patients.txt";
    private static final String DOCTOR_FILE = DATA_FOLDER + "/doctors.txt";
    private static final String APPOINTMENT_FILE = DATA_FOLDER + "/appointments.txt";

    public static void ensureDataFolderExists() {
        File folder = new File(DATA_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static void savePatients(ArrayList<Patient> patients) {
        ensureDataFolderExists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENT_FILE))) {
            for (Patient patient : patients) {
                writer.write(patient.getPatientId() + "|" +
                        patient.getName() + "|" +
                        patient.getAge() + "|" +
                        patient.getProblem() + "|" +
                        patient.getPriorityType());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving patients: " + e.getMessage());
        }
    }

    public static ArrayList<Patient> loadPatients() {
        ArrayList<Patient> patients = new ArrayList<>();
        File file = new File(PATIENT_FILE);

        if (!file.exists()) {
            return patients;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String problem = parts[3];
                    String priority = parts[4];

                    patients.add(new Patient(id, name, age, problem, priority));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading patients: " + e.getMessage());
        }

        return patients;
    }

    public static void saveDoctors(ArrayList<Doctor> doctors) {
        ensureDataFolderExists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTOR_FILE))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.getDoctorId() + "|" +
                        doctor.getName() + "|" +
                        doctor.getSpecialization());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving doctors: " + e.getMessage());
        }
    }

    public static ArrayList<Doctor> loadDoctors() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        File file = new File(DOCTOR_FILE);

        if (!file.exists()) {
            return doctors;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTOR_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String specialization = parts[2];

                    doctors.add(new Doctor(id, name, specialization));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading doctors: " + e.getMessage());
        }

        return doctors;
    }

    public static void saveAppointments(ArrayList<Appointment> appointments) {
        ensureDataFolderExists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(APPOINTMENT_FILE))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.getAppointmentId() + "|" +
                        appointment.getPatientId() + "|" +
                        appointment.getPatientName() + "|" +
                        appointment.getDoctorId() + "|" +
                        appointment.getDoctorName() + "|" +
                        appointment.getSlot() + "|" +
                        appointment.getPriorityType() + "|" +
                        appointment.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving appointments: " + e.getMessage());
        }
    }

    public static ArrayList<Appointment> loadAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        File file = new File(APPOINTMENT_FILE);

        if (!file.exists()) {
            return appointments;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 8) {
                    int appointmentId = Integer.parseInt(parts[0]);
                    int patientId = Integer.parseInt(parts[1]);
                    String patientName = parts[2];
                    int doctorId = Integer.parseInt(parts[3]);
                    String doctorName = parts[4];
                    String slot = parts[5];
                    String priority = parts[6];
                    String status = parts[7];

                    appointments.add(new Appointment(
                            appointmentId,
                            patientId,
                            patientName,
                            doctorId,
                            doctorName,
                            slot,
                            priority,
                            status
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading appointments: " + e.getMessage());
        }

        return appointments;
    }
}
