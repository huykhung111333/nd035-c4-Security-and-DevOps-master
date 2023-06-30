package com.example.demo.model.persistence;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Entity
@Table(name = "cart")
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	@Column
	private Long id;
	
	@ManyToMany
	@JsonProperty
	@Column
    private List<Item> items;
	
	@OneToOne(mappedBy = "cart")
	@JsonProperty
    private User user;
	
	@Column
	@JsonProperty
	private BigDecimal total;

	public void addItem(Item item) {
		items.add(item);
		if (total == null) {
			total = new BigDecimal(0);
		}
		total = total.add(item.getPrice());
	}

	public void removeItem(Item item) {
		items.remove(item);
		if (total == null) {
			total = new BigDecimal(0);
		}
		total = total.subtract(item.getPrice());
	}
}
