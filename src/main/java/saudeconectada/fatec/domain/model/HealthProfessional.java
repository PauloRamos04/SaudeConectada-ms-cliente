package saudeconectada.fatec.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import saudeconectada.fatec.domain.enums.Deficiency;
import saudeconectada.fatec.domain.enums.Gender;
import saudeconectada.fatec.domain.enums.ProfessionalType;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "health_professional")
public class HealthProfessional implements Verifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String password;
    private String cpf;
    private String email;
    private String phone;
    private String address;

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public UUID getVerificationToken() {
        return verificationToken;
    }

    @Override
    public boolean isVerified() {
        return verified;
    }

    private Gender gender;
    private Date birthDate;
    private UUID verificationToken;
    private boolean verified = false;
    private String healthUnitNumber;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Deficiency getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(Deficiency deficiency) {
        this.deficiency = deficiency;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ProfessionalType getProfessionalType() {
        return professionalType;
    }

    public void setProfessionalType(ProfessionalType professionalType) {
        this.professionalType = professionalType;
    }

    public String getHealthUnitNumber() {
        return healthUnitNumber;
    }

    public void setHealthUnitNumber(String healthUnitNumber) {
        this.healthUnitNumber = healthUnitNumber;
    }

    private Deficiency deficiency;
    private String photo;
    private ProfessionalType professionalType;

    public void setVerificationToken(UUID verificationToken) {
        this.verificationToken = verificationToken;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }


}
