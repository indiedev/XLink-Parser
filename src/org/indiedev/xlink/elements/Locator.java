package org.indiedev.xlink.elements;
/*
 * Represents element 'Locator'.
 * It is created from 'arc' tag but validated from 'link:loc' tag ...
 */
public class Locator {
	private String Label=null;//label content.
	private String href=null;//reference to schema.
	
	/*
	 * Position among its siblings.
	 * For Top-most RootNode this value is '0'.
	 * This is used while displaying it in a tree struture
	 */
	private float siblingOrder=0f;
	
	public Locator(String t_label,float t_order)
	{
		Label=t_label;
		siblingOrder=t_order;
	}
	public void setLabel(String temp)
	{
		this.Label=temp;
	}
	
	public String getLabel()
	{
		return Label;
	}
	
	public void setHref(String temp)
	{
		this.href=temp;
	}
	
	public String getHref()
	{
		return href;
	}
	
	public void setSiblingOrder(float order)
	{
		this.siblingOrder=order;
	}
	
	public float getSiblingOrder()
	{
		return this.siblingOrder;
	}
}
