package tweet.da.cat

import org.springframework.web.multipart.MultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder

class FileUploadService {

    def uploadFile(MultipartFile file, String name, String destinationDirectory) {
        def servletContext = ServletContextHolder.servletContext
        def storagePath = servletContext.getRealPath(destinationDirectory)
        def storagePathDirectory = new File(storagePath)
        if (!storagePathDirectory.exists()) {
            storagePathDirectory.mkdirs()
        }

        if (!file.isEmpty()) {
            def filePath = "${storagePath}/${name}"
            file.transferTo(new File(filePath))
            def basePath = servletContext.getContextPath()
            return basePath + "/${destinationDirectory}/${name}"
        } else {
            return null
        }
    }
}
