package in.ineuron.bo;

public class EmployeeBO {
	private Integer eid;
	private String ename;
	private Integer eage;
	private String eaddr;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public String getEaddr() {
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}

	@Override
	public String toString() {
		return "EmployeeBO [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eaddr=" + eaddr + "]";
	}

}
