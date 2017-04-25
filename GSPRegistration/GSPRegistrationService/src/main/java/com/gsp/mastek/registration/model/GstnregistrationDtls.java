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
 * GstnregistrationDtls generated by hbm2java
 */
@Entity
public class GstnregistrationDtls extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gstnregistrationdtlsId;
	
	@OneToOne(cascade = { CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId", referencedColumnName = "organizationId")
	private Organization organization;
	
	private String stateCd;
	
	private String gstin;

	public Long getGstnregistrationdtlsId() {
		return gstnregistrationdtlsId;
	}

	public void setGstnregistrationdtlsId(Long gstnregistrationdtlsId) {
		this.gstnregistrationdtlsId = gstnregistrationdtlsId;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	@Override
	public String toString() {
		return "GstnregistrationDtls [gstnregistrationdtlsId=" + gstnregistrationdtlsId + ", organization="
				+ organization + ", stateCd=" + stateCd + ", gstin=" + gstin + "]";
	}

}
