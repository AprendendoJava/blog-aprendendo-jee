package org.aprendendo.javaee.microconfighello.rest;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@RequestScoped
@Path("/config")
public class ConfigEndpoint {

	private static final String PROPERTY_PARAM = "propertyName";

	private static final String CUSTOM_PROPERTY = "custom.property";

	@Inject
	@ConfigProperty(name = CUSTOM_PROPERTY, defaultValue = "POST to /config/custom.property to set a new value")
	String customProperty;
	
	@Inject
	Config config;

	@GET
	@Path("/provider")
	public String providerName() {
		return "Provider: " + config.getClass().getName();
	}

	@GET
	@Path(CUSTOM_PROPERTY)
	public String getProperty() {
		return customProperty;
	}

	@GET
	@Path("{" + PROPERTY_PARAM + "}")
	public String getProperty(@PathParam(PROPERTY_PARAM) String propertyName) {
		String result = "Value for property \""+ propertyName + "\" not found";
		Optional<String> value = config.getOptionalValue(propertyName, String.class);
		if(value.isPresent()) {
			result = propertyName + "=" + value.get();
		}			
		return result;
	}

	@POST
	@Path("{" + PROPERTY_PARAM + "}")
	public void setProperty(@PathParam(PROPERTY_PARAM) String propertyName, String value) {
		System.out.println("Setting: " + propertyName + "=" + value);
		System.setProperty(propertyName, value);
	}
}