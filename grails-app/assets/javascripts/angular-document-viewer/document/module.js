//= require_self 
//= require controllers
//= require services 
//= require_tree /angular-document-viewer/document/templates/

'use strict';

angular.module('angularDocumentViewer.document', [
	'grails', 
	'angularDocumentViewer.document.controllers', 
	'angularDocumentViewer.document.services'
])
.value('defaultCrudResource', 'DocumentResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                documentList: function($route, DocumentResource) {
                    var params = $route.current.params;
                    return DocumentResource.list(params);
                } 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                document: function(DocumentResource) {
                    return DocumentResource.create();
                } 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                document: function($route, DocumentResource) {
                    var id = $route.current.params.id;
                    return DocumentResource.get(id);
                } 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                document: function($route, DocumentResource) {
                    var id = $route.current.params.id;
                    return DocumentResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
