package com.springboot.basics.Helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
//    public final String UPLOAD_DIR = "/home/isus/Workspace/Intellij Idea Projects/SpringBootBasics/src/main/resources/static/images";

    //    Making Dynamic Path
    public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
    boolean f = false;

    public FileUploadHelper() throws IOException {
    }

    public boolean uploadFile(MultipartFile multipartFile) {

//        Using Stream Api
        streamApi(multipartFile);

//        Using nIO
//        nIO(multipartFile);

        return f;
    }

    private void streamApi(MultipartFile multipartFile) {
        try {
//            Read
            InputStream is = multipartFile.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);

//            Write
            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + "/" + multipartFile.getOriginalFilename());
            fileOutputStream.write(data);

            fileOutputStream.flush();
            fileOutputStream.close();
            f = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void nIO(MultipartFile multipartFile) {
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
