package com.rs.spbwebdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the T_RA_BONUS_SALES_STATUS database table.
 * 
 */
@Entity
@Table(name="T_RA_BONUS_SALES_STATUS")
@NamedQuery(name="TRaBonusSalesStatus.findAll", query="SELECT t FROM TRaBonusSalesStatus t")
public class TRaBonusSalesStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.DATE)
	private Date cdate;

	private String creator;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private String editor;

	@Column(name="HOMERID_RA")
	private String homeridRa;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_D_MONTH")
	private Date lastDMonth;

	//bi-directional many-to-one association to TReportType
	@ManyToOne
	@JoinColumn(name="REPORT_CODE")
	private TReportType TReportType;

	//bi-directional many-to-one association to TStatus
	@ManyToOne
	@JoinColumn(name="STATUS_CODE")
	private TStatus TStatus;

	public TRaBonusSalesStatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getHomeridRa() {
		return this.homeridRa;
	}

	public void setHomeridRa(String homeridRa) {
		this.homeridRa = homeridRa;
	}

	public Date getLastDMonth() {
		return this.lastDMonth;
	}

	public void setLastDMonth(Date lastDMonth) {
		this.lastDMonth = lastDMonth;
	}

	public TReportType getTReportType() {
		return this.TReportType;
	}

	public void setTReportType(TReportType TReportType) {
		this.TReportType = TReportType;
	}

	public TStatus getTStatus() {
		return this.TStatus;
	}

	public void setTStatus(TStatus TStatus) {
		this.TStatus = TStatus;
	}

}