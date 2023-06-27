package com.ashokit.service;

import java.util.List;

import com.ashokit.form.ServerDtlsDto;

public interface ServerService {
	public String addServerDtls(ServerDtlsDto serverDtlsDto);
	public List<ServerDtlsDto> getAllServerDtls();
}
