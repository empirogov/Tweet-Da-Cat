package tweet.da.cat

import grails.converters.JSON

class UserController {

    def fileUploadService
    def authService

    def index = {
        [users: User.all]
    }

    def profile = {
        def user = authService.user
        if (user) {
            [user: user]
        } else {
            render status: 404
        }
    }

    def updateAvatar = {
        def user = User.get params.id
        if (user) {
            def avatarFile = request.getFile('avatar')
            if (!avatarFile.isEmpty()) {
                user.avatar = fileUploadService.uploadFile(avatarFile, "${user.nickname}.${getExt(avatarFile)}", 'upload/avatars')
            }
            user.save();
            flash.message = " Пользователь успешно обновлен"
            render(view: 'profile', model: [user: user])
        }
    }

    def update = {
        def user = User.get params.id
        if (user) {
            user.properties = params
            if (user.save(flush: true)) {
                flash.message = " Пользователь успешно обновлен"
                redirect(controller: "mainView", action: 'index')
            } else {
                flash.message = " Ошибка при сохранении!"
                render(view: 'profile', model: [user: user])
            }
        } else {
            render status: 404
        }
    }

    def getResult(resultCode) {
        return ['result': resultCode]
    }

    def subscribe = {
        if (authService.user && params.get("id")) {
            User toFollow = User.get params.id
            if (toFollow && authService.user.addToFollowing(toFollow)) {
                render getResult("SUCCESS") as JSON
                return
            }
        }
        render getResult("ERROR") as JSON
    }

    String getExt(file) {
        if(file.getContentType()=='image/jpeg'){
            return "jpeg"
        }
        if(file.getContentType()=='image/gif'){
            return "gif"
        }
        if(file.getContentType()=='image/png'){
            return "png"
        }
        if(file.getContentType()=='image/bmp'){
            return "bmp"
        }
        return "unknown"
    }

}
