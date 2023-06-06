package in.ineuron.vo;

public class EmployeeVO {
	private String eid;
	private String ename;
	private String eage;
	private String eaddr;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEage() {
		return eage;
	}

	public void setEage(String eage) {
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
		return "EmployeeVO [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eaddr=" + eaddr + "]";
	}

}
