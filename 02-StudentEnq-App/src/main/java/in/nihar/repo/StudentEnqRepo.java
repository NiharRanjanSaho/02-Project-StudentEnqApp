package in.nihar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nihar.entity.StudentEnqEntity;
import in.nihar.entity.UserDtlsEntity;

public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity, Integer> {

	public List<StudentEnqEntity> findByUser(UserDtlsEntity user);

}