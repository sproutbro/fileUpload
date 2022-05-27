package sp.test.file;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    void fileUpload(int no, MultipartFile[] files) throws IOException;
    List<String> fileList(int no);

}
