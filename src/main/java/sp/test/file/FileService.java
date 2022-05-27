package sp.test.file;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {
    void fileUpload(int no, MultipartFile[] files) throws IOException;
    List<String> fileList(int no);

    void fileDownload(String fileName, HttpServletResponse response) throws IOException;

    void fileDelete(int no);
}
