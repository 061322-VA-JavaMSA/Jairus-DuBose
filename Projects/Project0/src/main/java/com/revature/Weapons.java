package com.revature;



public class Weapons implements WeaponsInterface{


	private int id;
	private String weapon_name;
	private int weapon_price;
	private int weapon_quantity;

	public void WeaponName() {
		// TODO Auto-generated method stub
		
	}

	public void WeaponValue() {
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeapon_name() {
		return weapon_name;
	}

	public void setWeapon_name(String weapon_name) {
		this.weapon_name = weapon_name;
	}

	public int getWeapon_price() {
		return weapon_price;
	}

	public void setWeapon_price(int weapon_price) {
		this.weapon_price = weapon_price;
	}

	public int getWeapon_quantity() {
		return weapon_quantity;
	}

	public void setWeapon_quantity(int weapon_quantity) {
		this.weapon_quantity = weapon_quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((weapon_name == null) ? 0 : weapon_name.hashCode());
		result = prime * result + weapon_price;
		result = prime * result + weapon_quantity;
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
		Weapons other = (Weapons) obj;
		if (id != other.id)
			return false;
		if (weapon_name == null) {
			if (other.weapon_name != null)
				return false;
		} else if (!weapon_name.equals(other.weapon_name))
			return false;
		if (weapon_price != other.weapon_price)
			return false;
		if (weapon_quantity != other.weapon_quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weapons [id=" + id + ", weapon_name=" + weapon_name + ", weapon_price=" + weapon_price
				+ ", weapon_quantity=" + weapon_quantity + "]";
	}

}
