package model;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private String patientName;
    private int doctorId;
    private String doctorName;
    private String slot;
    private String priorityType;
    private String status;

    public Appointment(int appointmentId, int patientId, String patientName,
                       int doctorId, String doctorName, String slot,
                       String priorityType, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.slot = slot;
        this.priorityType = priorityType;
        this.status = status;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSlot() {
        return slot;
    }

    public String getPriorityType() {
        return priorityType;
    }

    public String getStatus() {
        return status;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId +
                ", Patient: " + patientName +
                ", Doctor: " + doctorName +
                ", Slot: " + slot +
                ", Priority: " + priorityType +
                ", Status: " + status;
    }
}
