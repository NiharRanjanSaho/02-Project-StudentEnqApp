package in.nihar.service;

import java.util.List;

import in.nihar.dto.DashboardResponse;
import in.nihar.dto.EnquiryForm;
import in.nihar.dto.EnquirySearchCriteria;
import in.nihar.entity.StudentEnqEntity;

public interface EnquiryService {

	public List<String> getCourseNames();

	public List<String> getEnqStatus();

	public DashboardResponse getDashboardData(Integer userId);

	public Boolean saveEnquiry(EnquiryForm form);

	public List<EnquiryForm> getEnquies(Integer userId, EnquirySearchCriteria criteria);

	public List<StudentEnqEntity> getEnquiry();

	public List<StudentEnqEntity> getFilteredEnqs(EnquirySearchCriteria criteria, Integer userId);

}