package week6.java.cogip.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private short id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name ="country")
    private String country;
	
	@Column(name = "vat")
    private String tva;
	
	@Column(name= "type")
    private String type;
	
	@CreationTimestamp
	@Column(name = "timeStamp", nullable = false, updatable = false, insertable = false)
    private String timestamp;
	
	@OneToMany(
			   mappedBy = "invoice",
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "invoice_company_id")
	private List<Invoice> invoices = new ArrayList<>();


    public Company(short id, String name, String country, String tva, String type, String timestamp) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.tva = tva;
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
