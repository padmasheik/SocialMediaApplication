package com.socialmedia.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
	@GetMapping("/person/v1")
	public Person1 getPersonV1() {
		return new Person1("Bob Charlie");
	}

	@GetMapping("/person/v2")
	public Person2 getPersonV2() {
		return new Person2(new Name("Bob", "Charlie"));
	}

	@GetMapping(value = "/person/param", params = "version=1")
	public Person1 personParamV1() {
		return new Person1("Bob Charlie");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public Person2 personParamV2() {
		return new Person2(new Name("Bob", "Charlie"));
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public Person1 personHeaderV1() {
		return new Person1("Bob Charlie");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public Person2 personHeaderV2() {
		return new Person2(new Name("Bob", "Charlie"));
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public Person1 personProducesV1() {
		return new Person1("Bob Charlie");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public Person2 personProducesV2() {
		return new Person2(new Name("Bob", "Charlie"));
	}

}
