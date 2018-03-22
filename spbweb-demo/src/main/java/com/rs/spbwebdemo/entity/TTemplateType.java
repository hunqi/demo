package com.rs.spbwebdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the T_TEMPLATE_TYPE database table.
 * 
 */
@Entity
@Table(name="T_TEMPLATE_TYPE")
@NamedQuery(name="TTemplateType.findAll", query="SELECT t FROM TTemplateType t")
public class TTemplateType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String code;

	@Temporal(TemporalType.DATE)
	private Date cdate;

	private String creator;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private String editor;

	//bi-directional many-to-one association to TMsgInfo
	@OneToMany(mappedBy="TTemplateType")
	private List<TMsgInfo> TMsgInfos;

	//bi-directional many-to-one association to TTemplate
	@OneToMany(mappedBy="TTemplateType")
	private List<TTemplate> TTemplates;

	public TTemplateType() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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
		TMsgInfo.setTTemplateType(this);

		return TMsgInfo;
	}

	public TMsgInfo removeTMsgInfo(TMsgInfo TMsgInfo) {
		getTMsgInfos().remove(TMsgInfo);
		TMsgInfo.setTTemplateType(null);

		return TMsgInfo;
	}

	public List<TTemplate> getTTemplates() {
		return this.TTemplates;
	}

	public void setTTemplates(List<TTemplate> TTemplates) {
		this.TTemplates = TTemplates;
	}

	public TTemplate addTTemplate(TTemplate TTemplate) {
		getTTemplates().add(TTemplate);
		TTemplate.setTTemplateType(this);

		return TTemplate;
	}

	public TTemplate removeTTemplate(TTemplate TTemplate) {
		getTTemplates().remove(TTemplate);
		TTemplate.setTTemplateType(null);

		return TTemplate;
	}

}