class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }
        "/" (controller: "mainView", action: "index")
        "/user/update/$id?" (controller: "user", action: "update")
        "/authorize/login?" (controller: "authorize", action: "login")
        "500" (view:'/error')
    }
}
