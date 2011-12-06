package org.indiedev.xlink.elements;
/*
 * Represents element 'arc'(CURRENTLY:Presentation arc only)
 * 
 * This represents the relationship b/w locators.
 * 
 */
public class Arc 
{
	private String parentLabel;
	private String childLabel;
	
	//stores the order value.Used while inserting arcs into the tree
	private float childLabelOrder=0;
	
	public Arc(String t_parentLabel,String t_childLabel,float childOrder)
	{
		parentLabel=t_parentLabel;
		childLabel=t_childLabel;
		childLabelOrder=childOrder;
	}
	
	public String getParentLabel() {
		return parentLabel;
	}
	
	public void setParentLabel(String parentLabel) {
		this.parentLabel = parentLabel;
	}
	
	public String getChildLabel() {
		return childLabel;
	}
	
	public void setChildLabel(String childLabel) {
		this.childLabel = childLabel;
	}

	public void setOrder(float order) {
		this.childLabelOrder = order;
	}

	public float getOrder() {
		return childLabelOrder;
	}	

}
