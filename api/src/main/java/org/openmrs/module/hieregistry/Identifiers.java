package org.openmrs.module.hieregistry;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Entity;
import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "hie_Identifiers")
public class Identifiers  {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String idetifier;
	
	@ManyToOne
	@JoinColumn(name = "hie_patient_id" ,nullable = false)
	private HiePatient hiepatient;
	
	public String getIdetifier() {
		return idetifier;
	}
	
	public void setIdetifier(String idetifier) {
		this.idetifier = idetifier;
	}
	
	public HiePatient getHiepatient() {
		return hiepatient;
	}
	
	public void setHiepatient(HiePatient hiepatient) {
		this.hiepatient = hiepatient;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
