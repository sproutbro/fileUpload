package sp.test.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private FileMapper fileMapper;

    @Autowired
    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public void fileUpload(int no /*문서번호*/, MultipartFile[] files) throws IOException {

        for (MultipartFile file : files) {
            String currentFileName = file.getOriginalFilename();
            String newFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            File uploadFile = new File(newFileName);
            file.transferTo(uploadFile);

            fileMapper.insertFile(no, currentFileName, newFileName);

            System.out.println("currentFileName = " + currentFileName);
            System.out.println("new_file_name = " + newFileName);
        }

    }

    @Override
    public List<String> fileList(int no) {
        return fileMapper.selectFileList(no);
    }
}
