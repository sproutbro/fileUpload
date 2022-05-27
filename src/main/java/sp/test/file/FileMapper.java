package sp.test.file;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("insert into tbl_file (no, file_name, repository_file_name) values (#{no}, #{currentFileName}, #{newFileName})")
    public void insertFile(int no, String currentFileName, String newFileName);

    @Select("select repository_file_name from tbl_file where no = #{no}")
    List<String> selectFileList(int no);

    @Delete("delete from tbl_file where no = #{no}")
    void deleteFileList(int no);

}
