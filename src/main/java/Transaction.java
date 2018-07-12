import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionId;
	@Column
	private int toAccountNumber;
	@Column
	private int fromAccountNumber;
	@Column
	private int ammount;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;
	
	
	
	public Transaction(String fromName, String toName, int toAccountNumber, int fromAccountNumber, int ammount) {
		this.toAccountNumber = toAccountNumber;
		this.fromAccountNumber = fromAccountNumber;
		this.ammount = ammount;
	}

	
	
}
