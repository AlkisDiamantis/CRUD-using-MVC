
package com.mypkg.trainersAssignment.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "trainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t")
    , @NamedQuery(name = "Trainer.findByIdTrainer", query = "SELECT t FROM Trainer t WHERE t.idTrainer = :idTrainer")
    , @NamedQuery(name = "Trainer.findByName", query = "SELECT t FROM Trainer t WHERE t.name = :name")
    , @NamedQuery(name = "Trainer.findBySurname", query = "SELECT t FROM Trainer t WHERE t.surname = :surname")
    , @NamedQuery(name = "Trainer.findBySubject", query = "SELECT t FROM Trainer t WHERE t.subject = :subject")
    , @NamedQuery(name = "Trainer.findByEmail", query = "SELECT t FROM Trainer t WHERE t.email = :email")
    , @NamedQuery(name = "Trainer.findByPhoneNumber", query = "SELECT t FROM Trainer t WHERE t.phoneNumber = :phoneNumber")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trainer")
    private Integer idTrainer;
    @Basic(optional = false)
    @NotNull(message = "This Field cannot be empty")
    @Pattern(regexp="^([ A-Za-z]+\\s)*[ A-Za-z]+$",  message = "Name should contain only letters" )
    @Size(min = 3, max = 45, message = "Name must be between 3-45 letters")
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull (message = "This Field cannot be empty")
    @Pattern(regexp="^([ A-Za-z]+\\s)*[ A-Za-z]+$",  message = "Surname should contain only letters" )
    @Size(min = 3, max = 45, message = "Surname must be between 3-45 letters")
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull (message = "This Field cannot be empty")
    @Size(min = 1, max = 100)
    @Column(name = "subject")
    private String subject;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid Email ")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "This Field cannot be empty")
    @Size(min = 1, max = 45)
    //@Email(message = "Not email")
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull(message = "This Field cannot be empty")
    @Pattern(regexp = "\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})", message = "Not Valid Phone Number Enter a 10 digit number!")
    @Size(min = 1, max = 15)
    @Column(name = "phone_number")

    private String phoneNumber;

    public Trainer() {
    }

    public Trainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public Trainer(Integer idTrainer, String name, String surname, String subject, String email, String phoneNumber) {
        this.idTrainer = idTrainer;
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrainer != null ? idTrainer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.idTrainer == null && other.idTrainer != null) || (this.idTrainer != null && !this.idTrainer.equals(other.idTrainer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mypkg.trainersAssignment.model.Trainer[ idTrainer=" + idTrainer + " ]";
    }

}
