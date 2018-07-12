import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.google.gson.Gson;

public class Functions {

	Gson util = new Gson();
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Transactional(TxType.SUPPORTS)
	public List getAllAccounts() {
		Query query = em.createQuery("select * from account");
		return query.getResultList();

	}

	@Transactional(TxType.SUPPORTS)
	public List findAnAccount(String searchId) {

		Query query = em.createQuery("select * from account where id=" + searchId);
		return query.getResultList();

	}

	@Transactional(TxType.REQUIRED)
	public String createAnAccount(String account) {
		Account a = util.fromJson(account, Account.class);
		em.persist(a);
		return "{\"message\": \"movie sucessfully added\"}";

	}

	@Transactional(TxType.REQUIRED)
	public int updateAnAccount(long accountId, String changingField, String changingTo) {
		
		Query query = em.createQuery("update account set "+changingField+" = '"+changingTo+"' where accountId="+accountId);
		return query.executeUpdate();
	}

	@Transactional(TxType.REQUIRED)
	public int deleteAnAccount(long accountId) {
		Query query= em.createQuery("delete from account where accountId= "+accountId);
		return query.executeUpdate();
	}

}
