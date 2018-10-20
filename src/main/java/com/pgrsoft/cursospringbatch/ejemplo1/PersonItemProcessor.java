package com.pgrsoft.cursospringbatch.ejemplo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public Person process(final Person person) throws Exception {
		
		final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
		
        final Person transformedPerson = new Person(firstName, lastName);
        
        int milisegundos = (int) (Math.random() * 10000);
        
        Thread.sleep(milisegundos);
        
        log.info("Converting (" + person + ") into (" + transformedPerson + " in " + milisegundos  + " milisegundos)");
        
		return transformedPerson;
	}

}
