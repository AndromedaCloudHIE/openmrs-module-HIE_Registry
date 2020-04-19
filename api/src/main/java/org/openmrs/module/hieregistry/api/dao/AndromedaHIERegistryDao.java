/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.hieregistry.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.APIException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.hieregistry.HiePatient;
import org.openmrs.module.hieregistry.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hieregistry.AndromedaHIERegistryDao")
public class AndromedaHIERegistryDao {
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Item getItemByUuid(String uuid) {
		return (Item) getSession().createCriteria(Item.class).add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}
	
	public Item saveItem(Item item) {
		getSession().saveOrUpdate(item);
		return item;
	}
	
	//.........................................
	
	public HiePatient recordHiePatient(HiePatient hiePatient) throws APIException {
		getSession().saveOrUpdate(hiePatient);
		return hiePatient;
	}
	
	public HiePatient getHiePatientByUuid(String uuid) throws APIException {
		return (HiePatient) getSession().createCriteria(HiePatient.class).add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}
	
	public HiePatient getHiePatientById(Integer id) throws APIException {
		
		return (HiePatient) sessionFactory.getCurrentSession().get(HiePatient.class, id);
	}
	
	//TO DO . Implement hibernate Full text search rather than DB seach to optimise  Search functionality
	@SuppressWarnings("unchecked")
	public List<HiePatient> searchHiePatient(String search) throws APIException {
		
		String hql = "SELECT * FROM HiePatient hp WHERE hp.firstName LIKE :query "
		        + "OR hp.lastName LIKE :query OR hp.familyname LIKE :query";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		String hqlregx = search + "%";
		query.setString("query", hqlregx);
		return query.list();
		
	}
	
	public List<HiePatient> getAllHiePatients() throws APIException {
		
		return sessionFactory.getCurrentSession().createQuery("From HiePatient").list();
	}
	
	public HiePatient getHiePatientByNin(String nin) throws APIException {
		
		return (HiePatient) getSession().createCriteria(HiePatient.class).add(Restrictions.eq("NIN", nin)).uniqueResult();
	}
	
	public HiePatient getHiePatientByIdentifier(String identifier) throws APIException {
		
		String hql = "SELECT * FROM HiePatient hp WHERE Identifiers.idetifier =:id AND hp.id  = Identifiers.hie_patient_id";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("query", identifier);
		return (HiePatient) query.uniqueResult();
	}
	
	//.......................................................... TO DO
	public HiePatient getHiePatientByNames(String names) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<HiePatient> getHiePatientsByDataFormat(String dataformat) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public HiePatient getHiePatient(String id, String nin, String names) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
