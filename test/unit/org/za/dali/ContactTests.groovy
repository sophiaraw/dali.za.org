package org.za.dali

import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 * 
 * test-app Contact -echoOut
 */
@TestFor(Contact)
class ContactTests {
	Contact contact
	
	protected void setUp() {
		super.setUp()
		mockForConstraintsTests Contact
		mockLogging(Contact, enableDebug = false)
	}
    void testValidation() {
		contact = new Contact(firstName:'Sophia',lastName:'Raw',emailAddress:'soph@quirk.biz')
		mockForConstraintsTests(Contact, [contact])

		assertTrue contact.validate()
		contact.errors.allErrors.each{
			println it
		}
    }
}
