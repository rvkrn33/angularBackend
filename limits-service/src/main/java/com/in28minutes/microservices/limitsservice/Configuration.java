package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties("limits-service")
public class Configuration {

	private int minimum;
	private int maximum;
	
	@Override
    public String toString() {
 
        return "minimum: "+ this.minimum+"\n"
                + "maximum: "+this.maximum+"\n";
    }
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}
