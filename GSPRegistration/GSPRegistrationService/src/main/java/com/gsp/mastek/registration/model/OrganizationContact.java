package com.gsp.mastek.registration.model;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.gsp.mastek.common.entity.BaseEntity;

/**
 * OrganizationContact generated by hbm2java
 */
@Entity
public class OrganizationContact extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long organizationcontactId;
	
	private String contactType;
	
	private String contactValue;
	
	private Long addressId;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationcontactId", referencedColumnName = "organizationcontactId")
	private Set<OrganizationContactpreference> organizationContactpreferences;

	public Long getOrganizationcontactId() {
		return organizationcontactId;
	}

	public void setOrganizationcontactId(Long organizationcontactId) {
		this.organizationcontactId = organizationcontactId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactValue() {
		return contactValue;
	}

	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Set<OrganizationContactpreference> getOrganizationContactpreferences() {
		return organizationContactpreferences;
	}

	public void setOrganizationContactpreferences(Set<OrganizationContactpreference> organizationContactpreferences) {
		this.organizationContactpreferences = organizationContactpreferences;
	}
	
	public void addOrganizationContactpreference(OrganizationContactpreference organizationContactpreference) {
		if (this.organizationContactpreferences == null) {
			this.organizationContactpreferences = new HashSet<OrganizationContactpreference>();
			this.organizationContactpreferences.add(organizationContactpreference);
		} else {
			this.organizationContactpreferences.add(organizationContactpreference);
		}
	}


	@Override
	public String toString() {
		return "OrganizationContact [organizationcontactId=" + organizationcontactId + ", contactType=" + contactType
				+ ", contactValue=" + contactValue + ", addressId=" + addressId + ", organizationContactpreferences="
				+ organizationContactpreferences + "]";
	}
}
