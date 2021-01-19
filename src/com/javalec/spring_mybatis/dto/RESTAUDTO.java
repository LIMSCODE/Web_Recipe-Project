package com.javalec.spring_mybatis.dto;
//UPSO_NM VARCHAR2(4000) PRIMARY KEY,
//ADMDNG_NM VARCHAR2(4000), 
//SITE_ADDR VARCHAR2(4000),   
//SITE_ADDR_RD VARCHAR2(4000), 
//UPSO_SITE_TELNO VARCHAR2(4000), 
//SNT_UPTAE_NM VARCHAR2(4000)


public class RESTAUDTO {
	private String upso_nm;
	private String admdng_nm;
	private String site_addr;
	private String site_addr_rd;
	private String upso_site_telno;
	private String snt_uptae_nm;
	private String dcb_ymd;
	
	
	
	public RESTAUDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RESTAUDTO(String upso_nm, String admdng_nm, String site_addr, String site_addr_rd, String upso_site_telno,
			String snt_uptae_nm, String dcb_ymd) {
		super();
		this.upso_nm = upso_nm;
		this.admdng_nm = admdng_nm;
		this.site_addr = site_addr;
		this.site_addr_rd = site_addr_rd;
		this.upso_site_telno = upso_site_telno;
		this.snt_uptae_nm = snt_uptae_nm;
		this.dcb_ymd=dcb_ymd;
	}
	
	
	
	public String getUpso_nm() {
		return upso_nm;
	}
	public void setUpso_nm(String upso_nm) {
		this.upso_nm = upso_nm;
	}
	public String getAdmdng_nm() {
		return admdng_nm;
	}
	public void setAdmdng_nm(String admdng_nm) {
		this.admdng_nm = admdng_nm;
	}
	public String getSite_addr() {
		return site_addr;
	}
	public void setSite_addr(String site_addr) {
		this.site_addr = site_addr;
	}
	public String getSite_addr_rd() {
		return site_addr_rd;
	}
	public void setSite_addr_rd(String site_addr_rd) {
		this.site_addr_rd = site_addr_rd;
	}
	public String getUpso_site_telno() {
		return upso_site_telno;
	}
	public void setUpso_site_telno(String upso_site_telno) {
		this.upso_site_telno = upso_site_telno;
	}
	public String getSnt_uptae_nm() {
		return snt_uptae_nm;
	}
	public String getDcb_ymd() {
		return dcb_ymd;
	}
	public void setDcb_ymd(String dcb_ymd) {
		this.dcb_ymd = dcb_ymd;
	}
	public void setSnt_uptae_nm(String snt_uptae_nm) {
		this.snt_uptae_nm = snt_uptae_nm;
	}
	

}
