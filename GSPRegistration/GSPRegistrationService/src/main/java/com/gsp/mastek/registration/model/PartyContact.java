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
 * PartyContact generated by hbm2java
 */
@Entity
public class PartyContact extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long partycontactId;
	
	private String contactType;
	
	private String contactValue;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "partycontactId", referencedColumnName = "partycontactId")
	private Set<PartycontactPreference> partycontactPreferences;

	public Long getPartycontactId() {
		return partycontactId;
	}

	public void setPartycontactId(Long partycontactId) {
		this.partycontactId = partycontactId;
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

	public Set<PartycontactPreference> getPartycontactPreferences() {
		return partycontactPreferences;
	}

	public void setPartycontactPreferences(Set<PartycontactPreference> partycontactPreferences) {
		this.partycontactPreferences = partycontactPreferences;
	}
	
	public void addPartycontactPreference(PartycontactPreference partycontactPreference) {
		if (this.partycontactPreferences == null) {
			this.partycontactPreferences = new HashSet<PartycontactPreference>();
			this.partycontactPreferences.add(partycontactPreference);
		} else {
			this.partycontactPreferences.add(partycontactPreference);
		}
	}

	@Override
	public String toString() {
		return "PartyContact [partycontactId=" + partycontactId + ", contactType=" + contactType + ", contactValue="
				+ contactValue + ", partycontactPreferences=" + partycontactPreferences + "]";
	}
}
