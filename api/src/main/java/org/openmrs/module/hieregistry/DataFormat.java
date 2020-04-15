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
@Table(name = "hie_DataFormat")
public class DataFormat extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String dataFormat;
	
	@ManyToOne
	@JoinColumn(name = "hie_patient_id")
	private HiePatient hiepatient;
	
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
	
	public String getDataFormat() {
		return dataFormat;
	}
	
	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}
	
	public HiePatient getHiepatient() {
		return hiepatient;
	}
	
	public void setHiepatient(HiePatient hiepatient) {
		this.hiepatient = hiepatient;
	}
	
}
