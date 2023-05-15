package com.revnomix.revseed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "file_log")
public class FileLogs extends BaseEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "client_id")
	private Integer clientId;
	
	@Column(name = "upload_date")
	private Date uploadDate;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "status")
	private String status;

	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "err_file_path")
	private String errFilePath;
}
