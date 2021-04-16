package com.laporan.main.service;

import java.util.List;

import com.laporan.main.entity.Kejadian;

public interface ModelKejadianInterface {
	public List<Kejadian> getAllKejadian();
	
	public Kejadian addKejadian(Kejadian kejadian);
	public Kejadian getKejadianById(String id);
	public void deleteKejadian(String id);
}
