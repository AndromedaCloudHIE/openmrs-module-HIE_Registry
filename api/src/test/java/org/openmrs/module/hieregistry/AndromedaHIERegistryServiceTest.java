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

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.hieregistry.api.AndromedaHIERegistryService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import junit.framework.Assert;

public class AndromedaHIERegistryServiceTest extends BaseModuleContextSensitiveTest {
	
	private AndromedaHIERegistryService hieService;
	
	@Before
	public void init() throws Exception {
		initializeInMemoryDatabase();
		executeDataSet("HieDataset.xml");
		authenticate();
		hieService = Context.getService(AndromedaHIERegistryService.class);
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void should_save_HiePatient() throws Exception {
		
		//save patient
		HiePatient pat = new HiePatient();
		pat.setFirstName("Kamoga");
		pat.setFamilyname("Pianist");
		pat.setNIN("UGPAT");
		
		Date dob = new Date(2000, 11, 21);
		pat.setDob(dob);
		//record patient
		HiePatient pat2 = hieService.recordHiePatient(pat);
		
		Assert.assertNotNull(pat2.getUuid());
		Assert.assertEquals("Kamoga", pat.getFirstName());
		Assert.assertNull(pat2.getLastName());
	}
	
	@Test
	public void should_return_HiePatient() throws Exception {
		
		//get patient by id
		HiePatient pat = hieService.getHiePatientById(1);
		Assert.assertEquals("kavuma", pat.getFamilyname());	
	}
	
	@Test
	public void should_return_HiePatient_by_uuid() throws Exception {
		
		//get patient by uuid
		HiePatient pat = hieService.getHiePatientByUuid("UUID2");
		Assert.assertEquals("kavuma2", pat.getFamilyname());
	}
	
	@Test
	public void should_return_HiePatient_by_Nin() throws Exception {
		
		//get patient by NIN
		HiePatient pat = hieService.getHiePatientByNin("nin2");
		Assert.assertEquals("kavuma2", pat.getFamilyname());
	}
	
	@Test
	public void should_return_All_HiePatient() throws Exception {
		//get all patients 
		List<HiePatient> pats = hieService.getAllHiePatients();
		Assert.assertEquals(4, pats.size());
	}
	
	@Test
	public void should_search_HiePatients_By_Name() throws Exception {
		//search patients
		List<HiePatient> pats = hieService.searchHiePatient("xx");
		Assert.assertEquals(2, pats.size());
	}
	
	@Test
	public void should_return_HiePatient_By_Identifier() throws Exception {
		//get patient by Identifier
		HiePatient pat = hieService.getHiePatientByIdentifier("xxxxx4");
		Assert.assertEquals("kavuma2", pat.getFamilyname());
	}
	
	@Test
	public void should_return_HiePatients_By_DataClasses() throws Exception {
		//get patient by Data Class
		List<HiePatient> pats = hieService.getHiePatientsByDataFormat("image");
		Assert.assertEquals(2, pats.size());
	}
}
