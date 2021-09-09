package com.something;

public class Adult implements Person{
	
	private String name;
	private int age;
	private String city;
	private String country;
	
	

	public Adult(String name, int age, String city, String country) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.country = country;
	}

	public void introduce() {
		System.out.println("My name is " + this.name);
		
	}

	public void sayAge() {
		System.out.println("I am " + this.age + " years old");
		
	}

	public void sayWhereFrom() {
		System.out.println("I'm from " + this.getCity() + ", " + this.getCountry());
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Adult other = (Adult) obj;
		if (age != other.age)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adult [name=" + name + ", age=" + age + ", city=" + city + ", country=" + country + "]";
	}
	
	

}
