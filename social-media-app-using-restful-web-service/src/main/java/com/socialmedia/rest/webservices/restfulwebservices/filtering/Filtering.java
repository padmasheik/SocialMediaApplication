package com.socialmedia.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class Filtering {
	@GetMapping("/filtering")
	// filter only phone
	public MappingJacksonValue retrieveParentsAcc() {
		ParentsAcct parentsAcct = new ParentsAcct("Nasreen", "candy", 123456);

		return setFilter(Arrays.asList(parentsAcct), "username", "phone");
	}

	private MappingJacksonValue setFilter(List<ParentsAcct> parentsAcct, String... fieldsToInclude) {
		MappingJacksonValue mapping = new MappingJacksonValue(parentsAcct);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToInclude);
		FilterProvider filters = new SimpleFilterProvider().addFilter("ParentAcctFilter", filter);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfParentsAcc() {
		return setFilter(
				Arrays.asList(new ParentsAcct("Nas", "candy", 123456), new ParentsAcct("Saleem", "time", 666765)),
				"username", "phone");

	}
}
