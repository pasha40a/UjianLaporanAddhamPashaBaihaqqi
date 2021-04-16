package com.laporan.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="laporan")
public class Laporan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLaporan;
	private String nama;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idKejadian")
	private Kejadian kejadian;
	private String alamat;
	private int status;
	private String keterangan; 
	private String gambar;


	
}