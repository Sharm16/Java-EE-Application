import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import antlr.collections.List;


@Entity
public class Account {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long accountId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int accountNumber;
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
//	private List<Transaction> transactions;
	
	public Account(long accountId, String firstName, String lastName, int accountNumber) {

		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}