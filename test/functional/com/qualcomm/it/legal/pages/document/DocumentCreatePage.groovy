package com.qualcomm.it.legal.pages.document

import geb.Module
import geb.Page

class DocumentCreatePage extends Page {

    static url = "document#/create"

    static at = { $('h2').text() == 'Create Document' }

    static content = { 
		authorField {$("input[ng-model='ctrl.document.author']")}
		pubDateField {$("input[ng-model='ctrl.document.pubDate']")}
		docDescriptionField {$("input[ng-model='ctrl.document.docDescription']")}
		dateCreatedField {$("input[ng-model='ctrl.document.dateCreated']")}
		lastUpdatedField {$("input[ng-model='ctrl.document.lastUpdated']")}
        saveButton { $('button[crud-button="save"]') }
    }

}