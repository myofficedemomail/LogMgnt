package com.ashokit.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CITIZEN_PLANS_INFO")
public class InsuranceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITIZEN_ID")
	private Integer citizen_id;
	@Column(name = "CITIZEN_NAME")
	private Integer citizen_name;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "PLAN_NAME")
	private String plan_name;
	@Column(name = "PLAN_STATUS")
	private String plan_status;
	@Column(name = "PLAN_START_DATE")
	private Date plan_start_date;
	@Column(name = "PLAN_END_DATE")
	private Date plan_end_date;
	@Column(name = "BENEFIT_AMOUNT")
	private Integer benefit_amount;
	@Column(name = "DENIAL_REASON")
	private String denial_reason;
	@Column(name = "TERMINATED_DATE")
	private Date terminated_date;
	@Column(name = "TERMINATION_REASON")
	private String termination_reason;

	public Integer getCitizen_id() {
		return citizen_id;
	}

	public InsuranceEntity(String plan_name, String plan_status, String gender, Date plan_start_date,
			Date plan_end_date) {
		super();
		this.gender = gender;
		this.plan_name = plan_name;
		this.plan_status = plan_status;
		this.plan_start_date = plan_start_date;
		this.plan_end_date = plan_end_date;
	}

	public InsuranceEntity(Integer citizen_name, String gender, String plan_name, String plan_status,
			Date plan_start_date, Date plan_end_date, Integer benefit_amount, String denial_reason,
			Date terminated_date, String termination_reason) {
		super();
		this.citizen_name = citizen_name;
		this.gender = gender;
		this.plan_name = plan_name;
		this.plan_status = plan_status;
		this.plan_start_date = plan_start_date;
		this.plan_end_date = plan_end_date;
		this.benefit_amount = benefit_amount;
		this.denial_reason = denial_reason;
		this.terminated_date = terminated_date;
		this.termination_reason = termination_reason;
	}

	public void setCitizen_id(Integer citizen_id) {
		this.citizen_id = citizen_id;
	}

	public Integer getCitizen_name() {
		return citizen_name;
	}

	public void setCitizen_name(Integer citizen_name) {
		this.citizen_name = citizen_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getPlan_status() {
		return plan_status;
	}

	public void setPlan_status(String plan_status) {
		this.plan_status = plan_status;
	}

	public Date getPlan_start_date() {
		return plan_start_date;
	}

	public void setPlan_start_date(Date plan_start_date) {
		this.plan_start_date = plan_start_date;
	}

	public Date getPlan_end_date() {
		return plan_end_date;
	}

	public void setPlan_end_date(Date plan_end_date) {
		this.plan_end_date = plan_end_date;
	}

	public Integer getBenefit_amount() {
		return benefit_amount;
	}

	public void setBenefit_amount(Integer benefit_amount) {
		this.benefit_amount = benefit_amount;
	}

	public String getDenial_reason() {
		return denial_reason;
	}

	public void setDenial_reason(String denial_reason) {
		this.denial_reason = denial_reason;
	}

	public Date getTerminated_date() {
		return terminated_date;
	}

	public void setTerminated_date(Date terminated_date) {
		this.terminated_date = terminated_date;
	}

	public String getTermination_reason() {
		return termination_reason;
	}

	public void setTermination_reason(String termination_reason) {
		this.termination_reason = termination_reason;
	}
}
