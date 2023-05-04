package in.nihar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nihar.dto.DashboardResponse;
import in.nihar.dto.EnquiryForm;
import in.nihar.dto.EnquirySearchCriteria;
import in.nihar.entity.CourseEntity;
import in.nihar.entity.EnqStatusEntity;
import in.nihar.entity.StudentEnqEntity;
import in.nihar.entity.UserDtlsEntity;
import in.nihar.repo.CourseRepo;
import in.nihar.repo.EnqStatusRepo;
import in.nihar.repo.StudentEnqRepo;
import in.nihar.repo.UserDtlsRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private StudentEnqRepo studentRepo;

	@Autowired
	private UserDtlsRepo userRepo;

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private EnqStatusRepo enqStatusRepo;

	@Autowired
	private HttpSession session;

	@Override
	public List<String> getCourseNames() {
		List<CourseEntity> courses = courseRepo.findAll();

		List<String> courseName = new ArrayList<>();

		for (CourseEntity courseEntity : courses) {
			courseName.add(courseEntity.getCourseName());
		}
		return courseName;
	}

	@Override
	public List<String> getEnqStatus() {

		List<EnqStatusEntity> enqStatus = enqStatusRepo.findAll();
		List<String> enqStatusName = new ArrayList<>();

		for (EnqStatusEntity entity : enqStatus) {
			enqStatusName.add(entity.getStatusName());
		}

		return enqStatusName;
	}

	@Override
	public DashboardResponse getDashboardData(Integer userId) {

		DashboardResponse response = new DashboardResponse();

		Optional<UserDtlsEntity> userOptional = userRepo.findById(userId);

		if (userOptional.isPresent()) {
			UserDtlsEntity user = userOptional.get();

			List<StudentEnqEntity> enquiries = user.getEnquiries();

			Integer totalCnt = enquiries.size();

			Integer enroledCnt = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("Enrolled"))
					.collect(Collectors.toList()).size();

			Integer LostCnt = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("Lost"))
					.collect(Collectors.toList()).size();

			response.setTotalEnquries(totalCnt);
			response.setEnrolledCnt(enroledCnt);
			response.setLostCnt(LostCnt);

		}

		return response;
	}

	@Override
	public Boolean saveEnquiry(EnquiryForm form) {

		StudentEnqEntity enqEntity = new StudentEnqEntity();

		BeanUtils.copyProperties(form, enqEntity);

		Integer userId = (Integer) session.getAttribute("userId");
		Optional<UserDtlsEntity> findById = userRepo.findById(userId);

		UserDtlsEntity userDtlsEntity = findById.get();
		enqEntity.setUser(userDtlsEntity);

		studentRepo.save(enqEntity);

		return true;
	}

	@Override
	public List<EnquiryForm> getEnquies(Integer userId, EnquirySearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentEnqEntity> getEnquiry() {
		Integer userId = (Integer) session.getAttribute("userId");

		Optional<UserDtlsEntity> findById = userRepo.findById(userId);

		UserDtlsEntity userDtlsEntity = findById.get();

		List<StudentEnqEntity> enquiries = userDtlsEntity.getEnquiries();

		return enquiries;

	}

	@Override
	public List<StudentEnqEntity> getFilteredEnqs(EnquirySearchCriteria criteria, Integer userId) {

		Optional<UserDtlsEntity> findById = userRepo.findById(userId);
		if (findById.isPresent()) {

			UserDtlsEntity userDtlsEntity = findById.get();

			List<StudentEnqEntity> enquiries = userDtlsEntity.getEnquiries();

			// filter Logic

			if (null != criteria.getCourseName() & !"".equals(criteria.getCourseName())) {
				enquiries = enquiries.stream().filter(e -> e.getCourseName().equals(criteria.getCourseName()))
						.collect(Collectors.toList());
			}

			if (null != criteria.getEnquiryStatus() & !"".equals(criteria.getEnquiryStatus())) {
				enquiries = enquiries.stream().filter(e -> e.getEnquiryStatus().equals(criteria.getEnquiryStatus()))
						.collect(Collectors.toList());
			}

			if (null != criteria.getClassMode() & !"".equals(criteria.getClassMode())) {
				enquiries = enquiries.stream().filter(e -> e.getClassMode().equals(criteria.getClassMode()))
						.collect(Collectors.toList());
			}

			return enquiries;
		}
		return null;
	}

}