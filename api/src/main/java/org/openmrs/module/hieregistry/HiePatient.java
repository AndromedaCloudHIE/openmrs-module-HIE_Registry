package org.openmrs.module.hieregistry;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "hie_Patient")
public class HiePatient extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String firstName;
	
	@Basic
	@Column(length = 255)
	private String lastName;
	
	@Basic
	@Column(length = 255)
	private String familyname;
	
	@Basic
	@Column
	private Date dob;
	
	@Basic
	@Column(length = 255, unique = true)
	private String NIN;
	
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
	
	public String getFamilyname() {
		return familyname;
	}
	
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getNIN() {
		return NIN;
	}
	
	public void setNIN(String nIN) {
		NIN = nIN;
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
}
