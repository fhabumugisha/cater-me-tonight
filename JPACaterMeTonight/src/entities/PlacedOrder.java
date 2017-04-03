package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="placed_order")
public class PlacedOrder {
	//Total fields: 5  		4fk(User, Delivery Addr, Creditcard, OrderItem)
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@Column(name="date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name="number_of_people")
	private int numberOfPeople;
	
	private boolean appetizer, entre, dessert, drink;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="delivery_address_id")
	private Address deliveryAddressId;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="creditcard_id")
	private Creditcard creditCard;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItem;
	
	@ManyToOne
	@JoinColumn(name="kitchen_id")
	private Kitchen kitchen;
	
	
	
	
	
	//GETTERS and SETTERS below (no setter for 'id')
	
	public int getId() {
		return id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getDeliveryAddress() {
		return deliveryAddressId;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddressId = deliveryAddress;
	}
	public Creditcard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(Creditcard creditCard) {
		this.creditCard = creditCard;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}	
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public boolean isAppetizer() {
		return appetizer;
	}
	public void setAppetizer(boolean appetizer) {
		this.appetizer = appetizer;
	}
	public boolean isEntre() {
		return entre;
	}
	public void setEntre(boolean entre) {
		this.entre = entre;
	}
	public boolean isDessert() {
		return dessert;
	}
	public void setDessert(boolean dessert) {
		this.dessert = dessert;
	}
	public boolean isDrink() {
		return drink;
	}
	public void setDrink(boolean drink) {
		this.drink = drink;
	}
	public Address getDeliveryAddressId() {
		return deliveryAddressId;
	}
	public void setDeliveryAddressId(Address deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlacedOrder [dateCreated=");
		builder.append(dateCreated);
		builder.append("Number of People=");
		builder.append(numberOfPeople);
		builder.append("]");
		return builder.toString();
	}
		
	
	
}
