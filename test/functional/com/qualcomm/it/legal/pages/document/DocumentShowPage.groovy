package com.qualcomm.it.legal.pages.document

import geb.Page

class DocumentShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Document' }

    static content = {
        successMessage { $(".alert-success") }
    }

}