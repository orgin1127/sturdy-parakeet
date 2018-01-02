package com.sesoc.web5.vo;

public class Customer {
	
	private String custid; //고객 ID
	private String password; //고객 Password
	private String name; //고객 이름
	private String email; //고객 email
	private String division; //고객 구분 personal(개인), company(기업)
	private String idno; //고객 식별 번호 개인:주민번호, 기업:사업자 번호
	private String address; //고객 주소
	
	public String getCustid() {return custid;}
	public void setCustid(String custid) {this.custid = custid;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getDivision() {return division;}
	public void setDivision(String division) {this.division = division;}
	public String getIdno() {return idno;}
	public void setIdno(String idno) {this.idno = idno;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	public Customer() {}
	public Customer(String custid, String password, String name, String email, String division, String idno,
			String address) {
		this.custid = custid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.division = division;
		this.idno = idno;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", division=" + division + ", idno=" + idno + ", address=" + address + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((custid == null) ? 0 : custid.hashCode());
		result = prime * result + ((division == null) ? 0 : division.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idno == null) ? 0 : idno.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (custid == null) {
			if (other.custid != null)
				return false;
		} else if (!custid.equals(other.custid))
			return false;
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idno == null) {
			if (other.idno != null)
				return false;
		} else if (!idno.equals(other.idno))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}
