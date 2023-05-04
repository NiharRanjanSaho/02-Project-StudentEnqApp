package in.nihar.dto;

import lombok.Data;

@Data
public class DashboardResponse {

	private Integer totalEnquries;

	private Integer enrolledCnt;

	private Integer lostCnt;

	public Integer getTotalEnquries() {
		return totalEnquries;
	}

	public void setTotalEnquries(Integer totalEnquries) {
		this.totalEnquries = totalEnquries;
	}

	public Integer getEnrolledCnt() {
		return enrolledCnt;
	}

	public void setEnrolledCnt(Integer enrolledCnt) {
		this.enrolledCnt = enrolledCnt;
	}

	public Integer getLostCnt() {
		return lostCnt;
	}

	public void setLostCnt(Integer lostCnt) {
		this.lostCnt = lostCnt;
	}
}
