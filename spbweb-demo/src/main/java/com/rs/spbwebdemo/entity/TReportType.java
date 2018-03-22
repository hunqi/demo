package com.rs.spbwebdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the T_REPORT_TYPE database table.
 * 
 */
@Entity
@Table(name="T_REPORT_TYPE")
@NamedQuery(name="TReportType.findAll", query="SELECT t FROM TReportType t")
public class TReportType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REPORT_CODE")
	private String reportCode;

	@Temporal(TemporalType.DATE)
	private Date cdate;

	private String creator;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private String editor;

	//bi-directional many-to-one association to TRaBonusSalesStatus
	@OneToMany(mappedBy="TReportType")
	private List<TRaBonusSalesStatus> TRaBonusSalesStatuses;

	public TReportType() {
	}

	public String getReportCode() {
		return this.reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
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

	public List<TRaBonusSalesStatus> getTRaBonusSalesStatuses() {
		return this.TRaBonusSalesStatuses;
	}

	public void setTRaBonusSalesStatuses(List<TRaBonusSalesStatus> TRaBonusSalesStatuses) {
		this.TRaBonusSalesStatuses = TRaBonusSalesStatuses;
	}

	public TRaBonusSalesStatus addTRaBonusSalesStatus(TRaBonusSalesStatus TRaBonusSalesStatus) {
		getTRaBonusSalesStatuses().add(TRaBonusSalesStatus);
		TRaBonusSalesStatus.setTReportType(this);

		return TRaBonusSalesStatus;
	}

	public TRaBonusSalesStatus removeTRaBonusSalesStatus(TRaBonusSalesStatus TRaBonusSalesStatus) {
		getTRaBonusSalesStatuses().remove(TRaBonusSalesStatus);
		TRaBonusSalesStatus.setTReportType(null);

		return TRaBonusSalesStatus;
	}

}