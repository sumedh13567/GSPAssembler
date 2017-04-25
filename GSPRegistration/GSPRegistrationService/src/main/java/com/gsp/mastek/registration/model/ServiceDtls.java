package com.gsp.mastek.registration.model;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.gsp.mastek.common.entity.BaseEntity;

/**
 * ServiceDtls generated by hbm2java
 */
@Entity
public class ServiceDtls extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long servicedtlsId;
	
	@OneToOne(cascade = { CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId", referencedColumnName = "organizationId")
	private Organization organization;
	
	private String serviceDescription;
	
	private Integer sacCode;

	public Long getServicedtlsId() {
		return servicedtlsId;
	}

	public void setServicedtlsId(Long servicedtlsId) {
		this.servicedtlsId = servicedtlsId;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Integer getSacCode() {
		return sacCode;
	}

	public void setSacCode(Integer sacCode) {
		this.sacCode = sacCode;
	}

	@Override
	public String toString() {
		return "ServiceDtls [servicedtlsId=" + servicedtlsId + ", organization=" + organization
				+ ", serviceDescription=" + serviceDescription + ", sacCode=" + sacCode + "]";
	}
}
