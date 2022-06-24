package com.revature;

public class Armours implements ArmoursInterface{

	private int id;
	private String armour_name;
	private int armour_price;
	private int armour_quantity;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArmour_name() {
		return armour_name;
	}

	public void setArmour_name(String armour_name) {
		this.armour_name = armour_name;
	}

	public int getArmour_price() {
		return armour_price;
	}

	public void setArmour_price(int armour_price) {
		this.armour_price = armour_price;
	}

	public int getArmour_quantity() {
		return armour_quantity;
	}

	public void setArmour_quantity(int armour_quantity) {
		this.armour_quantity = armour_quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((armour_name == null) ? 0 : armour_name.hashCode());
		result = prime * result + armour_price;
		result = prime * result + armour_quantity;
		result = prime * result + id;
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
		Armours other = (Armours) obj;
		if (armour_name == null) {
			if (other.armour_name != null)
				return false;
		} else if (!armour_name.equals(other.armour_name))
			return false;
		if (armour_price != other.armour_price)
			return false;
		if (armour_quantity != other.armour_quantity)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Armours [id=" + id + ", armour_name=" + armour_name + ", armour_price=" + armour_price
				+ ", armour_quantity=" + armour_quantity + "]";
	}

	public void ArmourName() {
		// TODO Auto-generated method stub
		
	}

	public void ArmourValue() {
		// TODO Auto-generated method stub
		
	}


}
