package clover.infotech.entity;


import java.util.Date;

import org.hibernate.annotations.ForeignKey;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Toll_Subscription")
public class TollSubcriptions{

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tollId;

	private String planId;
    
	private String plainName;
	
	
	private Date subscriptionMonths;
	
	private String custSupport;
	
	private String createdBy;
	
	private String modifiedBy;
	
	
	private Date createdDate;
	
	
	private Date modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="empid", nullable = false)
	 @ForeignKey(name = "FKbwuytoa79kyu0at8rs3o8mm04")
	private Employee employee;

	public Integer getTollId() {
		return tollId;
	}

	public void setTollId(Integer tollId) {
		this.tollId = tollId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlainName() {
		return plainName;
	}

	public void setPlainName(String plainName) {
		this.plainName = plainName;
	}

	public Date getSubscriptionMonths() {
		return subscriptionMonths;
	}

	public void setSubscriptionMonths(Date subscriptionMonths) {
		this.subscriptionMonths = subscriptionMonths;
	}

	public String getCustSupport() {
		return custSupport;
	}

	public void setCustSupport(String custSupport) {
		this.custSupport = custSupport;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public TollSubcriptions() {
		super();
	}

	public TollSubcriptions(Integer tollId, String planId, String plainName, Date subscriptionMonths,
			String custSupport, String createdBy, String modifiedBy, Date createdDate, Date modifiedDate,
			Employee employee) {
		super();
		this.tollId = tollId;
		this.planId = planId;
		this.plainName = plainName;
		this.subscriptionMonths = subscriptionMonths;
		this.custSupport = custSupport;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.employee = employee;
	}

	

	
	
}
