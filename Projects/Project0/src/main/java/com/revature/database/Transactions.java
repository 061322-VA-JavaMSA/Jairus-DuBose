package com.revature.database;

public class Transactions {

	private int id;
	private String item_purchased;
	private String customer_name;
	private String transaction_date;
	private int transaction_amount;
	private String transaction_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_purchased() {
		return item_purchased;
	}
	public void setItem_purchased(String item_purchased) {
		this.item_purchased = item_purchased;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public int getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getTransaction_status() {
		return transaction_status;
	}
	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((item_purchased == null) ? 0 : item_purchased.hashCode());
		result = prime * result + transaction_amount;
		result = prime * result + ((transaction_date == null) ? 0 : transaction_date.hashCode());
		result = prime * result + ((transaction_status == null) ? 0 : transaction_status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transactions other = (Transactions) obj;
		if (customer_name == null) {
			if (other.customer_name != null)
				return false;
		} else if (!customer_name.equals(other.customer_name))
			return false;
		if (id != other.id)
			return false;
		if (item_purchased == null) {
			if (other.item_purchased != null)
				return false;
		} else if (!item_purchased.equals(other.item_purchased))
			return false;
		if (transaction_amount != other.transaction_amount)
			return false;
		if (transaction_date == null) {
			if (other.transaction_date != null)
				return false;
		} else if (!transaction_date.equals(other.transaction_date))
			return false;
		if (transaction_status == null) {
			if (other.transaction_status != null)
				return false;
		} else if (!transaction_status.equals(other.transaction_status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", item_purchased=" + item_purchased + ", customer_name=" + customer_name
				+ ", transaction_date=" + transaction_date + ", transaction_amount=" + transaction_amount
				+ ", transaction_status=" + transaction_status + "]";
	} 
	
	
	
	
}
