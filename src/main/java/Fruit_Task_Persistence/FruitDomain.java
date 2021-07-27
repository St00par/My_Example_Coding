package Fruit_Task_Persistence;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FruitDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String type;
	
	private String colour;
	
	private double cost;

	
	public FruitDomain() {
		super();
	}
	
	public FruitDomain(long id, String type, String colour, double cost) {
		super();
		this.id = id;
		this.type = type;
		this.colour = colour;
		this.cost = cost;
	}

	public FruitDomain(String type, String colour, double cost) {
		super();
		this.type = type;
		this.colour = colour;
		this.cost = cost;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, cost, id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FruitDomain other = (FruitDomain) obj;
		return Objects.equals(colour, other.colour)
				&& Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && id == other.id
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "FruitDomian [id=" + id + ", type=" + type + ", colour=" + colour + ", cost=" + cost + "]";
	}

	
	


}
