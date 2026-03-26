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
}
