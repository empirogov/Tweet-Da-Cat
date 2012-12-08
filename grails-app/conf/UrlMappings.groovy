class UrlMappings {

	static mappings = {

        "/user/update/$id?"(
                controller: "user",
                action: "update"
        )

        "/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
        "500"(view:'/error')
//        "404"(view:'/error')
        "/authorize/login/$email/$password?"(
                controller: "authorize",
                action: "login"
        )


    }
}
