package sp.test.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {

    @GetMapping("/fileUploadPage")
    public String fileUploadPage() {
        return "fileUploadPage";
    }
}
