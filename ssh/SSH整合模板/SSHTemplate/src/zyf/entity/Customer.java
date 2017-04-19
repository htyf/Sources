package zyf.entity;

/**
 * 客户实体类
 *
 */
public class Customer {
	private String custId;//客户id
	private String custName;//客户名称
	private String custLevel;//客户级别 
	private String custSource;//信息来源
	private String custLinkman;//联系人
	private String custPhone;//固定电话
	private String custMobile;//移动电话
	private String custAddress;//联系地址 
	private String custZip;//邮政编码
	private String custFax;//客户传真
	private String custWebsite;//客户网址 
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustLinkman() {
		return custLinkman;
	}
	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustZip() {
		return custZip;
	}
	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}
	public String getCustFax() {
		return custFax;
	}
	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}
	public String getCustWebsite() {
		return custWebsite;
	}
	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}
	public Customer(String custId, String custName, String custLevel, String custSource, String custLinkman,
			String custPhone, String custMobile, String custAddress, String custZip, String custFax,
			String custWebsite) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
	}
	public Customer(String custName, String custLevel, String custSource, String custLinkman, String custPhone,
			String custMobile, String custAddress, String custZip, String custFax, String custWebsite) {
		super();
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Custormer [custId=" + custId + ", custName=" + custName + ", custLevel=" + custLevel + ", custSource="
				+ custSource + ", custLinkman=" + custLinkman + ", custPhone=" + custPhone + ", custMobile="
				+ custMobile + ", custAddress=" + custAddress + ", custZip=" + custZip + ", custFax=" + custFax
				+ ", custWebsite=" + custWebsite + "]";
	}
	
	
}
