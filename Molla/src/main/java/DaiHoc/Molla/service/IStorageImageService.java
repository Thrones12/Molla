package DaiHoc.Molla.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;



public interface IStorageImageService {
	
	void save(MultipartFile file); 

}
