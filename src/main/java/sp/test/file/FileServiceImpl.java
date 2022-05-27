package sp.test.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private FileMapper fileMapper;

    @Autowired
    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Value("${spring.servlet.multipart.location}")
    String path;

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
    @Override
    public void fileDownload(String fileName, HttpServletResponse response) throws IOException {
        String filePath = path + "/" + fileName;
        File file = new File(filePath);
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream out = response.getOutputStream();

        int read = 0;
        byte[] buffer = new byte[1024];
        while ((read = fileInputStream.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }

    }

    @Override
    public void fileDelete(int no) {
        //파일삭제
        List<String> fileList = fileMapper.selectFileList(no);
        for (String file : fileList) {
            String filePath = path + "/" + file;
            File deleteFile = new File(filePath);
            deleteFile.delete();
        }
        //DB삭제

        fileMapper.deleteFileList(no);

    }
}
