package in.nihar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nihar.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

}