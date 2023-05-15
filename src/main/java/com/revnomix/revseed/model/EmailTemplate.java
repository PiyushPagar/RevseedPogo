package com.revnomix.revseed.model;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.joda.time.DateTime;

@Entity
@Table(name = "email_template")
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name = "template_code")
    private String templateCode;
    
    @Column(name = "subject")
    private String subject;
    
    @Column(name = "from")
    private String from;
    
    @Column(name = "to")
    private String to;
    
    @Column(name = "cc")
    private String cc;
    
    @Column(name = "bcc")
    private String bcc;
    
    @Column(name = "body")
    private String body;
    
    @Column(name = "attachments")
    private String attachments;
    
    @Column(name = "status")
    private Boolean status;
    
    @Column(name = "created_by")
    private Long createdBy;
    
    @Column(name = "created_at")
    private DateTime createdAt;
    
    @Column(name = "updated_by")
    private Long updatedBy;
    
    @Column(name = "updated_at")
    private DateTime updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
		

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public EmailTemplate() {}
	
	public EmailTemplate(Integer id, @NotNull String templateCode,String subject, String from, String to, String cc, String bcc,
			String body, String attachments, Boolean status, Long createdBy, DateTime createdAt, Long updatedBy,
			DateTime updatedAt) {
		super();
		this.id = id;
		this.templateCode = templateCode;
		this.subject = subject;
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.body = body;
		this.attachments = attachments;
		this.status = status;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	public String toString() {
		return "EmailTemplate [id=" + id + ", templateCode=" + templateCode + ", subject=" + subject + ", from=" + from + ", to=" + to + ", cc="
				+ cc + ", bcc=" + bcc + ", body=" + body + ", attachments=" + attachments + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt="
				+ updatedAt + "]";
	}
    
    
    
    

}
