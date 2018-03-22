package com.rs.spbwebdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the T_MSG_INFO database table.
 * 
 */
@Entity
@Table(name="T_MSG_INFO")
@NamedQuery(name="TMsgInfo.findAll", query="SELECT t FROM TMsgInfo t")
public class TMsgInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="BATCH_ID")
	private BigDecimal batchId;

	@Temporal(TemporalType.DATE)
	private Date cdate;

	private String creator;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private String editor;

	@Column(name="HOMERID_RA")
	private String homeridRa;

	@Column(name="MSG_BODY")
	private String msgBody;

	//bi-directional many-to-one association to TStatus
	@ManyToOne
	@JoinColumn(name="STATUS_CODE")
	private TStatus TStatus;

	//bi-directional many-to-one association to TTemplate
	@ManyToOne
	@JoinColumn(name="ID_TEMPLATE")
	private TTemplate TTemplate;

	//bi-directional many-to-one association to TTemplateType
	@ManyToOne
	@JoinColumn(name="TEMPLATE_TYPE_CODE")
	private TTemplateType TTemplateType;

	public TMsgInfo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getBatchId() {
		return this.batchId;
	}

	public void setBatchId(BigDecimal batchId) {
		this.batchId = batchId;
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

	public String getMsgBody() {
		return this.msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public TStatus getTStatus() {
		return this.TStatus;
	}

	public void setTStatus(TStatus TStatus) {
		this.TStatus = TStatus;
	}

	public TTemplate getTTemplate() {
		return this.TTemplate;
	}

	public void setTTemplate(TTemplate TTemplate) {
		this.TTemplate = TTemplate;
	}

	public TTemplateType getTTemplateType() {
		return this.TTemplateType;
	}

	public void setTTemplateType(TTemplateType TTemplateType) {
		this.TTemplateType = TTemplateType;
	}

}