package com.laporan.main.service;

import java.util.List;

import com.laporan.main.entity.Laporan;


public interface ModelLaporanInterface {
	public List<Laporan> getAllLaporan();
	public Laporan getLaporanByName(String name);
	
	public Laporan addLaporan(Laporan laporan);
	public Laporan getLaporanById(String id);
}
