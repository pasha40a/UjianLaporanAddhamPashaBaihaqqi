package com.laporan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laporan.main.entity.Laporan;
import com.laporan.main.repository.LaporanRepository;
@Service
public class ModelLaporan implements ModelLaporanInterface {

	@Autowired
	LaporanRepository laporanRepo;
	@Override
	public List<Laporan> getAllLaporan() {
		// TODO Auto-generated method stub
		return (List<Laporan>) this.laporanRepo.findAll();

	}

	@Override
	public Laporan getLaporanByName(String name) {
		// TODO Auto-generated method stub
		return this.laporanRepo.findByNama(name);
	}

	@Override
	public Laporan addLaporan(Laporan laporan) {
		// TODO Auto-generated method stub
		return  this.laporanRepo.save(laporan);
	}

	@Override
	public Laporan getLaporanById(String id) {
		// TODO Auto-generated method stub
		return 	((Laporan)this.laporanRepo.findByIdLaporan(Long.parseLong(id)));
		
	}

}
