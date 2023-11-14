package co.istad.s4mbanking.api.file;

import co.istad.s4mbanking.api.file.web.FileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    FileDto uploadSingle(MultipartFile file);

    List<FileDto> uploadMultiple(List<MultipartFile> files);

    void delete(String name);

    FileDto findByName(String name) throws IOException;

    Resource download(String name);

}
