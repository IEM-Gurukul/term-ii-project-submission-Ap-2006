package service;

import model.Appointment;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;

public class HospitalManager {
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public HospitalManager() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public boolean addPatient(Patient patient) {
        for (Patient p : patients) {
            if (p.getPatientId() == patient.getPatientId()) {
                return false;
            }
        }
        patients.add(patient);
        return true;
    }

    public boolean addDoctor(Doctor doctor) {
        for (Doctor d : doctors) {
            if (d.getDoctorId() == doctor.getDoctorId()) {
                return false;
            }
        }
        doctors.add(doctor);
        return true;
    }

    public Patient findPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public Doctor findDoctorById(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public String bookAppointment(int appointmentId, int patientId, int doctorId, String slot) {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient == null) {
            return "Patient not found.";
        }

        if (doctor == null) {
            return "Doctor not found.";
        }

        for (Appointment ap : appointments) {
            if (ap.getAppointmentId() == appointmentId) {
                return "Appointment ID already exists.";
            }
        }

        Appointment appointment = new Appointment(
                appointmentId,
                patient.getPatientId(),
                patient.getName(),
                doctor.getDoctorId(),
                doctor.getName(),
                slot,
                patient.getPriorityType(),
                "Booked"
        );

        appointments.add(appointment);
        return "Appointment booked successfully.";
    }

    public boolean cancelAppointment(int appointmentId) {
        for (Appointment ap : appointments) {
            if (ap.getAppointmentId() == appointmentId &&
                    ap.getStatus().equalsIgnoreCase("Booked")) {
                ap.setStatus("Cancelled");
                return true;
            }
        }
        return false;
    }
}
