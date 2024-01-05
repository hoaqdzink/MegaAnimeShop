package vinhnh.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the SttOders database table.
 * 
 */
@Entity
@Table(name="SttOders")
@NamedQuery(name="SttOder.findAll", query="SELECT s FROM SttOder s")
public class SttOder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="CreateDate")
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column(name="Descriptions")
	private String descriptions;

	@Column(name="Statuss")
	private String statuss;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="IdInvoice")
	private Invoice invoice;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IdUser")
	private User user;

	public SttOder() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getStatuss() {
		return statuss;
	}

	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}