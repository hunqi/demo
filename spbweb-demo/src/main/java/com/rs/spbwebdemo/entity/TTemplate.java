package com.rs.spbwebdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the T_TEMPLATE database table.
 * 
 */
@Entity
@Table(name="T_TEMPLATE")
@NamedQuery(name="TTemplate.findAll", query="SELECT t FROM TTemplate t")
public class TTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.DATE)
	private Date cdate;

	private String content;

	private String creator;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private String editor;

	//bi-directional many-to-one association to TMsgInfo
	@OneToMany(mappedBy="TTemplate")
	private List<TMsgInfo> TMsgInfos;

	//bi-directional many-to-one association to TTemplateType
	@ManyToOne
	@JoinColumn(name="TYPE_CODE")
	private TTemplateType TTemplateType;

	public TTemplate() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCdate() {
		return this.cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public List<TMsgInfo> getTMsgInfos() {
		return this.TMsgInfos;
	}

	public void setTMsgInfos(List<TMsgInfo> TMsgInfos) {
		this.TMsgInfos = TMsgInfos;
	}

	public TMsgInfo addTMsgInfo(TMsgInfo TMsgInfo) {
		getTMsgInfos().add(TMsgInfo);
		TMsgInfo.setTTemplate(this);

		return TMsgInfo;
	}

	public TMsgInfo removeTMsgInfo(TMsgInfo TMsgInfo) {
		getTMsgInfos().remove(TMsgInfo);
		TMsgInfo.setTTemplate(null);

		return TMsgInfo;
	}

	public TTemplateType getTTemplateType() {
		return this.TTemplateType;
	}

	public void setTTemplateType(TTemplateType TTemplateType) {
		this.TTemplateType = TTemplateType;
	}

}