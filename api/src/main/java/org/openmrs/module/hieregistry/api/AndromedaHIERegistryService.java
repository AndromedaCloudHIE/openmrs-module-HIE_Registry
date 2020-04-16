/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.hieregistry.api;

import java.util.List;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.hieregistry.AndromedaHIERegistryConfig;
import org.openmrs.module.hieregistry.HiePatient;
import org.openmrs.module.hieregistry.Item;
import org.springframework.transaction.annotation.Transactional;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface AndromedaHIERegistryService extends OpenmrsService {
	
	/**
	 * Returns an item by uuid. It can be called by any authenticated user. It is fetched in read
	 * only transaction.
	 * 
	 * @param uuid
	 * @return
	 * @throws APIException
	 */
	@Authorized()
	@Transactional(readOnly = true)
	Item getItemByUuid(String uuid) throws APIException;
	
	/**
	 * Saves an item. Sets the owner to superuser, if it is not set. It can be called by users with
	 * this module's privilege. It is executed in a transaction.
	 * 
	 * @param item
	 * @return
	 * @throws APIException
	 */
	@Authorized(AndromedaHIERegistryConfig.MODULE_PRIVILEGE)
	@Transactional
	Item saveItem(Item item) throws APIException;
	
	
	@Transactional
	HiePatient recordHiePatient(HiePatient hiePatient) throws APIException;
	
	@Transactional
	HiePatient getHiePatientByUuid(String uuid) throws APIException;
	
	@Transactional
	HiePatient getHiePatientById(Integer id) throws APIException ;
	
	@Transactional
	HiePatient getHiePatientByNames(String names) throws APIException;
	
	@Transactional
	HiePatient getHiePatientByIdentifier(String id) throws APIException;
	
	@Transactional
	HiePatient getHiePatientByNin(String nin) throws APIException;
	
	@Transactional
	List<HiePatient> getHiePatientsByDataFormat(String dataformat) throws APIException;
	
	@Transactional
	HiePatient getHiePatient(String id , String nin,String names) throws APIException;
	
	@Transactional
	List <HiePatient> searchHiePatient(String query) throws APIException;
	
	@Transactional
	List <HiePatient> getAllHiePatients() throws APIException;
		
}
