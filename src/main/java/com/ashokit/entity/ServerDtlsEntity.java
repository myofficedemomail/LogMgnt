package com.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ServerDtlsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serverId;
	private String servername;
	private String serverip;
}
