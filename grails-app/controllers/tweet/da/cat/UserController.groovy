package tweet.da.cat

import org.springframework.web.multipart.MultipartHttpServletRequest

class UserController {

    def fileUploadService
    def authService

    def index = {
        [users: User.all]
    }

    def show = {
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
                user.avatar = fileUploadService.uploadFile(avatarFile, "${user.nickname}-${avatarFile.fileItem.fileName}", 'upload/avatars')
            }
            user.save();
            redirect(action: 'show', id: user.id)
        }
    }

    def update = {
        def user = User.get params.id
        if (user) {
            user.properties = params
            if (user.save(flush: true)) {
                flash.message = " Пользователь успешно обновлен"
                redirect(action: 'show', id: user.id)
            } else {
                flash.message = " Пользователь успешно обновлен"
                render(view: 'show', model: [user: user])
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
