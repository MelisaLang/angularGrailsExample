package com.qualcomm.it.legal

import grails.converters.JSON

class CustomMarshallerRegistrar {
    
    void registerMarshallers() {

		JSON.registerObjectMarshaller(com.qualcomm.it.legal.Document) {
			def map = [:]
			map['id'] = it?.id
			map['author'] = it?.author
			map['pubDate'] = it?.pubDate
			map['docDescription'] = it?.docDescription
			map['dateCreated'] = it?.dateCreated
			map['lastUpdated'] = it?.lastUpdated
	    	map['toText'] = it?.toString()
			return map 
		}

		 
	}

}