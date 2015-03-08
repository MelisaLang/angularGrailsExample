'use strict';

function DocumentResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/document', 'Document');
}

angular.module('angularDocumentViewer.document.services', ['grails'])
    .factory('DocumentResource', DocumentResource);
