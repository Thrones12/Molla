package DaiHoc.Molla.service.Imp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import DaiHoc.Molla.service.IStorageImageService;

@Service
public class StorageImageService implements IStorageImageService{
	
	private Path rootLocation;

	public StorageImageService() {
		this.rootLocation = Paths.get("src/main/resources/static/assets/images/manufacture");
	}

	@Override
	public void save(MultipartFile file) {
		try {
			
			Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename())).normalize()
					.toAbsolutePath();
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
