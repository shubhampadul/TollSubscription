package clover.infotech.entity;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empid;
	
	private String empName;
	
	private String empAddress;
	
	private Long contactNo;
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<TollSubcriptions> tollSubcriptions;

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

	public List<TollSubcriptions> getTollSubcriptions() {
		return tollSubcriptions;
	}

	public void setTollSubcriptions(List<TollSubcriptions> tollSubcriptions) {
		this.tollSubcriptions = tollSubcriptions;
	}

	public Employee() {
		super();
	}

	public Employee(Long empid, String empName, String empAddress, Long contactNo,
			List<TollSubcriptions> tollSubcriptions) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empAddress = empAddress;
		this.contactNo = contactNo;
		this.tollSubcriptions = tollSubcriptions;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empAddress=" + empAddress + ", contactNo="
				+ contactNo + ", tollSubcriptions=" + tollSubcriptions + ", getEmpid()=" + getEmpid()
				+ ", getEmpName()=" + getEmpName() + ", getEmpAddress()=" + getEmpAddress() + ", getContactNo()="
				+ getContactNo() + ", getTollSubcriptions()=" + getTollSubcriptions() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

	
}
