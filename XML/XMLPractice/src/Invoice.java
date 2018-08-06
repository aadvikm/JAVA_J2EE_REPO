import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invoice {
	private int invoiceNo;
	private int billNo;
	private int amount;
	private String billDate;
	
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute(name="no")
	public int getInvoiceNo() {
		return invoiceNo;
	}


	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@XmlElement(name ="billno")
	public int getBillNo() {
		return billNo;
	}


	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	@XmlElement(name ="amount")
	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}

	@XmlElement(name ="billdate")
	public String getBillDate() {
		return billDate;
	}


	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNo=" + invoiceNo + ", billNo=" + billNo + ", amount=" + amount + ", billDate="
				+ billDate + "]";
	}
	
	
	
	
	
	
		
}
