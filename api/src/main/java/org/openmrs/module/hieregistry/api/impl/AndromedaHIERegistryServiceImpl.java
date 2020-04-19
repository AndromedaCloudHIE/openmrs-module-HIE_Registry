/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.hieregistry.api.impl;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.hieregistry.HiePatient;
import org.openmrs.module.hieregistry.Item;
import org.openmrs.module.hieregistry.api.AndromedaHIERegistryService;
import org.openmrs.module.hieregistry.api.dao.AndromedaHIERegistryDao;
import org.springframework.beans.factory.annotation.Autowired;

public class AndromedaHIERegistryServiceImpl extends BaseOpenmrsService implements AndromedaHIERegistryService {
	
	@Autowired
	AndromedaHIERegistryDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	
	public void setDao(AndromedaHIERegistryDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Item getItemByUuid(String uuid) throws APIException {
		return dao.getItemByUuid(uuid);
	}
	
	@Override
	public Item saveItem(Item item) throws APIException {
		if (item.getOwner() == null) {
			item.setOwner(userService.getUser(1));
		}
		
		return dao.saveItem(item);
	}
	
	//...............................................
	
	@Override
	public HiePatient recordHiePatient(HiePatient hiePatient) throws APIException {
		
		return dao.recordHiePatient(hiePatient);
	}
	
	@Override
	public HiePatient getHiePatientByUuid(String uuid) throws APIException {
		
		return dao.getHiePatientByUuid(uuid);
	}
	
	@Override
	public HiePatient getHiePatientById(Integer id) throws APIException {
		
		return dao.getHiePatientById(id);
	}
	
	@Override
	public HiePatient getHiePatientByIdentifier(String identifier) throws APIException {
		
		return dao.getHiePatientByIdentifier(identifier);
	}
	
	@Override
	public HiePatient getHiePatientByNin(String nin) throws APIException {
		
		return dao.getHiePatientByNin(nin);
	}
	
	@Override
	public List<HiePatient> searchHiePatient(String query) throws APIException {
		
		return dao.searchHiePatient(query);
	}
	
	@Override
	public List<HiePatient> getAllHiePatients() throws APIException {
		return dao.getAllHiePatients();
	}
	
	//.......................... To DO
	
	@Override
	public HiePatient getHiePatientByNames(String names) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<HiePatient> getHiePatientsByDataFormat(String dataformat) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HiePatient getHiePatient(String id, String nin, String names) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
