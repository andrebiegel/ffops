package com.github.ffops.firemen.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.metrics.annotation.Gauge;

import com.github.ffops.firemen.entity.FireMen;

@ApplicationScoped
public class FireMenStore {

	private List<FireMen> store;

	@PostConstruct
	public void init() {
		store = new ArrayList<>();
	}

	@Gauge(unit = "count")
	public int amount() {
		return this.store.size();
	}

	public List<FireMen> firemens() {
		return store;
	}

	/**
	 * add a {@link FireMen} which already a personal number assigned
	 * 
	 * @param initialized
	 */
	public void add(FireMen initialized) {
		this.store.add(initialized);

	}
}
