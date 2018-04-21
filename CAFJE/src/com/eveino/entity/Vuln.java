package com.eveino.entity;
/***
 * 
 * @author 小王子
 *
 */
public class Vuln {
	private String name;
	private String id;
	private String regexp;
	private String decription;
	private String recommendation;
	private String reference;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegexp() {
		return regexp;
	}
	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	@Override
	public String toString() {
		return "Vuln [name=" + name + ", id=" + id + ", regexp=" + regexp + ", decription=" + decription
				+ ", recommendation=" + recommendation + ", reference=" + reference
				+ "]";
	}
	
	
}
