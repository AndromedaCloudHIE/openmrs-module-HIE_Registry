/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.hieregistry;

import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.hieregistry.api.AndromedaHIERegistryService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

/**
 * This is a unit test, which verifies logic in AndromedaHIERegistryService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
//@ContextConfiguration(classes = HIESpringConfiguration.class, inheritLocations = false)
public class AndromedaHIERegistryServiceTest extends BaseModuleContextSensitiveTest {
	

	
	@Test
	public void should_return_HiePatient() throws Exception {
		AndromedaHIERegistryService hieService = Context.getService(AndromedaHIERegistryService.class);
		//initializeInMemoryDatabase();
		executeDataSet("HieDataset.xml");
		//authenticate();
		
		
		HiePatient pat = hieService.getHiePatientById(1);
		System.out.println(pat.getFamilyname());
	}
}
