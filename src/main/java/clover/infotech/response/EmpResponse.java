package clover.infotech.response;

import java.util.List;

public class EmpResponse {
	
	
private Long empid;
	
	private String empName;
	
	private String empAddress;
	
	private Long contactNo;
	
	private List<SubResponse> tollSubcriptions;

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public List<SubResponse> getTollSubcriptions() {
		return tollSubcriptions;
	}

	public void setTollSubcriptions(List<SubResponse> tollSubcriptions) {
		this.tollSubcriptions = tollSubcriptions;
	}
	
	
	

}
