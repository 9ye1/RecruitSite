package Likelion.RecruitSite.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseException;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${app.firebase-key}")
    private String path;

    @Value("${app.firebase-bucket}")
    private String firebaseBucket;

    private static final String downPath_front = "https://firebasestorage.googleapis.com/v0/b/applepie-f030c.appspot.com/o/";
    private static final String downPath_back = "?alt=media";

    private static final Integer STATUS = 1;


    public String uploadFiles(MultipartFile file, String name) throws IOException {
        Bucket bucket = StorageClient
                .getInstance()
                .bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());
        Blob blob = bucket.create(name, content, file.getContentType());
        return blob.getMediaLink();
    }

    public String saveFile(Long id, MultipartFile multipartFile) {
        try {
            //String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            String name = FilenameUtils.getBaseName(multipartFile.getName()+"-"+id);
            String link = uploadFiles(multipartFile, name); // 반환 값 미사용
            return downPath_front+name+downPath_back;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
