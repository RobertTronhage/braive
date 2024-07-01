package se.tronhage.braive.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import se.tronhage.braive.enums.Organisation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Psychologist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int idNo;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Organisation org;
    @OneToMany(mappedBy = "psychologist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Patient> patients = new ArrayList<>();

    public Psychologist() {
    }

    public Psychologist(String firstName, String lastName, int idNo, LocalDate dateOfBirth, Organisation org, List<Patient> patients) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNo = idNo;
        this.dateOfBirth = dateOfBirth;
        this.org = org;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Organisation getOrg() {
        return org;
    }

    public void setOrg(Organisation org) {
        this.org = org;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Psychologist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNo=" + idNo +
                ", dateOfBirth=" + dateOfBirth +
                ", org=" + org +
                ", patients=" + patients +
                '}';
    }
}
