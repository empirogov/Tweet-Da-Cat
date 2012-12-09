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
        "/register?" (controller: "login", action: "index")
        "500" (view:'/error')
    }
}
