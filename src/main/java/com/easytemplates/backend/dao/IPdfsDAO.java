import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Pdfs;

public interface IPdfsDAO extends JpaRepository<Pdfs, Long> {
	
}