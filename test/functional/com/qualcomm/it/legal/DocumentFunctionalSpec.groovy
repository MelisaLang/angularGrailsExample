package com.qualcomm.it.legal

import com.qualcomm.it.legal.pages.document.*
import geb.spock.GebReportingSpec


class DocumentFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to DocumentListPage

		then:
		at DocumentListPage
	}
	
	def "should be able to create a valid Document"() {
		when:
		to DocumentListPage

		and:
		createButton.click()

		then:
		at DocumentCreatePage

		when:
		authorField = "Foo"
		pubDateField = "01/01/2001"
		docDescriptionField = "Foo"
		dateCreatedField = "01/01/2001"
		lastUpdatedField = "01/01/2001"
			
		and:
		saveButton.click()

		then:
		at DocumentShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Document was successfully created"
	}
	
	def "should be able to sort the Document List"() {
		given:
		to DocumentListPage

		when:
		authorSort.click()
		
		then:
		authorSort.classes().contains("asc")

		when:
		pubDateSort.click()
		
		then:
		pubDateSort.classes().contains("asc")

		when:
		docDescriptionSort.click()
		
		then:
		docDescriptionSort.classes().contains("asc")

		when:
		dateCreatedSort.click()
		
		then:
		dateCreatedSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Document List"() {
		given:
		to DocumentListPage

		when:
		authorFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		pubDateFilter = "01/01/2001"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		docDescriptionFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		dateCreatedFilter = "01/01/2001"
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Document"() {
		when:
		to DocumentListPage

		and:
		rows.first().editButton.click()

		then:
		at DocumentEditPage
		
		when:
		authorField = "Foo!"
		pubDateField = "02/01/2001"
		docDescriptionField = "Foo!"
		dateCreatedField = "02/01/2001"
		lastUpdatedField = "02/01/2001"
		
		and:
		saveButton.click()
		
		then:
		at DocumentShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Document was successfully updated"
	}
	
	def "should be able to delete the first Document"() {
		when:
		to DocumentListPage

		and:
		rows.first().deleteButton.click()

		then:
		at DocumentListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Document was successfully deleted"
      }
	
}