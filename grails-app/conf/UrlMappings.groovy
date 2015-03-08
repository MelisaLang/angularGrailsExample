class UrlMappings {

	static mappings = {

        		'/document'(view: 'document')
		'/api/document'(resources: 'document')
"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
