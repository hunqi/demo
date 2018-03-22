package com.rs.spbwebdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the T_STATUS database table.
 * 
 */
@Entity
@Table(name="T_STATUS")
@NamedQuery(name="TStatus.findAll", query="SELECT t FROM TStatus t")
public class TStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STATUS_CODE")
	private long statusCode;

	@Temporal(TemporalType.DATE)
	private Date cdate;

	private String creator;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private String editor;

	//bi-directional many-to-one association to TMsgInfo
	@OneToMany(mappedBy="TStatus")
	private List<TMsgInfo> TMsgInfos;

	//bi-directional many-to-one association to TRaBonusSalesStatus
	@OneToMany(mappedBy="TStatus")
	private List<TRaBonusSalesStatus> TRaBonusSalesStatuses;

	public TStatus() {
	}

	public long getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<TMsgInfo> getTMsgInfos() {
		return this.TMsgInfos;
	}

	public void setTMsgInfos(List<TMsgInfo> TMsgInfos) {
		this.TMsgInfos = TMsgInfos;
	}

	public TMsgInfo addTMsgInfo(TMsgInfo TMsgInfo) {
		getTMsgInfos().add(TMsgInfo);
		TMsgInfo.setTStatus(this);

		return TMsgInfo;
	}

	public TMsgInfo removeTMsgInfo(TMsgInfo TMsgInfo) {
		getTMsgInfos().remove(TMsgInfo);
		TMsgInfo.setTStatus(null);

		return TMsgInfo;
	}

	public List<TRaBonusSalesStatus> getTRaBonusSalesStatuses() {
		return this.TRaBonusSalesStatuses;
	}

	public void setTRaBonusSalesStatuses(List<TRaBonusSalesStatus> TRaBonusSalesStatuses) {
		this.TRaBonusSalesStatuses = TRaBonusSalesStatuses;
	}

	public TRaBonusSalesStatus addTRaBonusSalesStatus(TRaBonusSalesStatus TRaBonusSalesStatus) {
		getTRaBonusSalesStatuses().add(TRaBonusSalesStatus);
		TRaBonusSalesStatus.setTStatus(this);

		return TRaBonusSalesStatus;
	}

	public TRaBonusSalesStatus removeTRaBonusSalesStatus(TRaBonusSalesStatus TRaBonusSalesStatus) {
		getTRaBonusSalesStatuses().remove(TRaBonusSalesStatus);
		TRaBonusSalesStatus.setTStatus(null);

		return TRaBonusSalesStatus;
	}

}