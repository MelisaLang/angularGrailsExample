'use strict';

function ListCtrl($scope, DocumentResource, documentList, pageSize) {
    var self = this;
    self.documentList = documentList;
	
    self.pageSize = pageSize;
    self.page = 1;
    self.filter = {};

    $scope.$watchCollection(function() { return self.filter }, function() {
        self.reload();
    });

    self.load = function() {
        var params = {page: self.page};

        if (self.sort) {
            angular.extend(params, self.sort);
        }
		if (self.filter) {
			params.filter = self.filter
		}

        DocumentResource.list(params).then(function(items) {
            self.documentList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(document) {
    var self = this;
    self.document = document;
};

function CreateEditCtrl(document ) {
    var self = this;
	
    self.document = document;
}

angular.module('angularDocumentViewer.document.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);