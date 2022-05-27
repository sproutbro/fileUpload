package sp.test.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class FileApiController {

    private FileService fileService;

    @Autowired
    public FileApiController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/fileUpload")
    public void fileUpload(MultipartFile[] files) throws IOException {

        int no = 1; //        문서번호
        fileService.fileUpload(no, files);

    }

    @GetMapping("/fileList")
    public List<String> fileList(int no) {
        return fileService.fileList(no);
    }
}
