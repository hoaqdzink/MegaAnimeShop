package vinhnh.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Invoices database table.
 * 
 */
@Entity
@Table(name="Invoices")
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="CreateDate")
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column(name="PHONE")
	private String phone;

	@Column(name="PlaceDelivery")
	private String placeDelivery;

	@Column(name="Quantity")
	private int quantity;

	@Column(name="TotalMoney")
	private BigDecimal totalMoney;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="IdProduct")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IdUser")
	private User user;

	//bi-directional many-to-one association to SttOder
	@OneToMany(mappedBy="invoice")
	private List<SttOder> sttOders;

	public Invoice() {
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPlaceDelivery() {
		return placeDelivery;
	}


	public void setPlaceDelivery(String placeDelivery) {
		this.placeDelivery = placeDelivery;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}


	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SttOder> getSttOders() {
		return this.sttOders;
	}

	public void setSttOders(List<SttOder> sttOders) {
		this.sttOders = sttOders;
	}

	public SttOder addSttOder(SttOder sttOder) {
		getSttOders().add(sttOder);
		sttOder.setInvoice(this);

		return sttOder;
	}

	public SttOder removeSttOder(SttOder sttOder) {
		getSttOders().remove(sttOder);
		sttOder.setInvoice(null);

		return sttOder;
	}

}