package com.axelor.module;

import com.axelor.resources.ContactResource;
import com.axelor.service.ContactService;
import com.axelor.service.ContactServiceImpl;
import com.google.inject.AbstractModule;

public class ModuleConfigure extends AbstractModule {

	@Override
	protected void configure() {
		bind(ContactResource.class);
		bind(ContactService.class).to(ContactServiceImpl.class);
	}

}
