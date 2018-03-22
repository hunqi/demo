package com.rs.spbwebdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the T_RA_INFO database table.
 * 
 */
@Entity
@Table(name="T_RA_INFO")
@NamedQuery(name="TRaInfo.findAll", query="SELECT t FROM TRaInfo t")
public class TRaInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HOMERID_RA")
	private String homeridRa;

	@Temporal(TemporalType.DATE)
	private Date cdate;

	private String creator;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private String editor;

	@Column(name="HOMERID_DSM")
	private String homeridDsm;

	@Column(name="NAME_DSM")
	private String nameDsm;

	@Column(name="NAME_RA")
	private String nameRa;

	@Column(name="TEXT_EMAIL_ADDRESS")
	private String textEmailAddress;

	public TRaInfo() {
	}

	public String getHomeridRa() {
		return this.homeridRa;
	}

	public void setHomeridRa(String homeridRa) {
		this.homeridRa = homeridRa;
	}

	public Date getCdate() {
		return this.cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getEditor() {
		return this.editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getHomeridDsm() {
		return this.homeridDsm;
	}

	public void setHomeridDsm(String homeridDsm) {
		this.homeridDsm = homeridDsm;
	}

	public String getNameDsm() {
		return this.nameDsm;
	}

	public void setNameDsm(String nameDsm) {
		this.nameDsm = nameDsm;
	}

	public String getNameRa() {
		return this.nameRa;
	}

	public void setNameRa(String nameRa) {
		this.nameRa = nameRa;
	}

	public String getTextEmailAddress() {
		return this.textEmailAddress;
	}

	public void setTextEmailAddress(String textEmailAddress) {
		this.textEmailAddress = textEmailAddress;
	}

	@Override
	public String toString() {
		return "TRaInfo [homeridRa=" + homeridRa + ", cdate=" + cdate + ", creator=" + creator + ", edate=" + edate
				+ ", editor=" + editor + ", homeridDsm=" + homeridDsm + ", nameDsm=" + nameDsm + ", nameRa=" + nameRa
				+ ", textEmailAddress=" + textEmailAddress + "]";
	}
	
}