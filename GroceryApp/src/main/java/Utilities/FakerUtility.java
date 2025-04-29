package Utilities;

import java.util.Date;

import com.github.javafaker.Faker;

public class FakerUtility {
	
	Faker faker = new Faker();
	
	public String generateName() {
		return faker.name().fullName();
	
	}
	
	public String generateAddress()
	{
		return faker.address().fullAddress();
		
	}
	
	public String generatePhone()
	{
		return faker.phoneNumber().phoneNumber();
		
	}
	
	public String gnerateEmail()
	{
		return faker.internet().emailAddress();
		
	}

	public Date generateDate()
	{
		return faker.date().birthday();
		
	}
	
	public String generatjob()
	{
		return faker.job().field();
		
	}
	public String generatefakeNewsBody() {
		
		return faker.lorem().paragraph();
	}
	
}