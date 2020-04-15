package org.openmrs.module.hieregistry;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "hie_Identifiers")
public class Identifiers extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String idetifier;
	
	@ManyToOne
	@JoinColumn(name = "hie_patient_id")
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
