package tweet.da.cat

class UserController {

    def index = {
        [users: User.all]
    }

    def show = {
        def user = User.get(params.id)
        if (user) {
           [user: user]
        } else {
            render status: 404
        }
    }

    def update = {
        def user = User.get params.id
        if (user) {
            user.properties = params
            if (!user.hasErrors() && user.save(flush: true)) {
                flash.message =" Пользователь успешно обновлен"
                redirect(action: 'show', id: user.id)
            } else {
                flash.message =" Пользователь успешно обновлен"
                render(view: 'show', model: [user:user])
            }
        } else {
            render status: 404
        }
    }

    def getResult(status, data) {
        [
                status: status,
                result: data
        ]
    }

}
