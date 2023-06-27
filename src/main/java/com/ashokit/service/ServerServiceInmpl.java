package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.ServerDtlsEntity;
import com.ashokit.form.ServerDtlsDto;
import com.ashokit.repo.ServerDtlsRepo;

@Service
public class ServerServiceInmpl implements ServerService {
	@Autowired
	private ServerDtlsRepo serverDtlsRepo; 
	@Override
	public String addServerDtls(ServerDtlsDto serverDtlsDto) {
		ServerDtlsEntity serverDtls=new ServerDtlsEntity();
		serverDtls.setServerip(serverDtlsDto.getServerip());
		serverDtls.setServername(serverDtlsDto.getServername());
		System.out.println(serverDtls);
		ServerDtlsEntity savedServerDtls = serverDtlsRepo.save(serverDtls);
		System.out.println(savedServerDtls);
		if(savedServerDtls!=null) {
			return "Added Successfully";
		}else {
			return "Error Occured While Adding";
		}
	}
	@Override
	public List<ServerDtlsDto> getAllServerDtls() {
		List<ServerDtlsEntity> findAll = serverDtlsRepo.findAll();
		List<ServerDtlsDto> listDto=new ArrayList<>();
		ServerDtlsDto serverDtlsDto=null;
		for(ServerDtlsEntity entity:findAll) {
			serverDtlsDto=new ServerDtlsDto();
			serverDtlsDto.setServerip(entity.getServerip());
			serverDtlsDto.setServername(entity.getServername());
			listDto.add(serverDtlsDto);
		}
		return listDto;
	}

}
