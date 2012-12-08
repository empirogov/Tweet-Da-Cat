class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
        "/authorize/login/$email/$password?"(
                controller: "authorize",
                action: "login"
        )
    }
}
