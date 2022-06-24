package com.revature;

public class Potions implements PotionsInterface{

	private int id;
	private String potion_name;
	private int potion_price;
	private int potion_quantity;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPotion_name() {
		return potion_name;
	}

	public void setPotion_name(String potion_name) {
		this.potion_name = potion_name;
	}

	public int getPotion_price() {
		return potion_price;
	}

	public void setPotion_price(int potion_price) {
		this.potion_price = potion_price;
	}

	public int getPotion_quantity() {
		return potion_quantity;
	}

	public void setPotion_quantity(int potion_quantity) {
		this.potion_quantity = potion_quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((potion_name == null) ? 0 : potion_name.hashCode());
		result = prime * result + potion_price;
		result = prime * result + potion_quantity;
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
		Potions other = (Potions) obj;
		if (id != other.id)
			return false;
		if (potion_name == null) {
			if (other.potion_name != null)
				return false;
		} else if (!potion_name.equals(other.potion_name))
			return false;
		if (potion_price != other.potion_price)
			return false;
		if (potion_quantity != other.potion_quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Potions [id=" + id + ", potion_name=" + potion_name + ", potion_price=" + potion_price
				+ ", potion_quantity=" + potion_quantity + "]";
	}

	public void PotionName() {
		// TODO Auto-generated method stub
		
	}

	public void PotionValue() {
		// TODO Auto-generated method stub
		
	}

}
