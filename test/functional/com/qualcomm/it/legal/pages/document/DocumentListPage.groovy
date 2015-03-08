package com.qualcomm.it.legal.pages.document

import geb.Module
import geb.Page

class DocumentListPage extends Page {

    static url = "document"

    static at = { $('h2').text() == 'Document List' }

    static content = {
		authorFilter {$("input[ng-model='ctrl.filter.author']")}
		pubDateFilter {$("input[ng-model='ctrl.filter.pubDate']")}
		docDescriptionFilter {$("input[ng-model='ctrl.filter.docDescription']")}
		dateCreatedFilter {$("input[ng-model='ctrl.filter.dateCreated']")}
		lastUpdatedFilter {$("input[ng-model='ctrl.filter.lastUpdated']")}
	
		authorSort { $("table#list th[property='author']") }
		pubDateSort { $("table#list th[property='pubDate']") }
		docDescriptionSort { $("table#list th[property='docDescription']") }
		dateCreatedSort { $("table#list th[property='dateCreated']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList DocumentListRow, $("table#list tbody tr") }
    }

}

class DocumentListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}