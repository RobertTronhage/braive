package se.tronhage.braive.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psychologist_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Psychologist psychologist;

    public Psychologist() {
    }

    public Psychologist(String firstName, String lastName, int idNo, LocalDate dateOfBirth, Organisation org, Psychologist psychologist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNo = idNo;
        this.dateOfBirth = dateOfBirth;
        this.org = org;
        this.psychologist = psychologist;
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

    public Psychologist getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Psychologist psychologist) {
        this.psychologist = psychologist;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNo=" + idNo +
                ", dateOfBirth=" + dateOfBirth +
                ", org=" + org +
                ", psychologist=" + psychologist +
                '}';
    }
}
