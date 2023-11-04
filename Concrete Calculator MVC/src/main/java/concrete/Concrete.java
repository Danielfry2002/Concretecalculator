package concrete;

import java.text.NumberFormat;

public class Concrete {
	//Create variables that hold the input 
	
	private double width;
	private double length; 
	private double thickness;
	private int bagSize;
	private double rate50 = 2.45;
	private double rate60 = 2.83;
	private double rate80 = 3.75;
	private double convert50 = 0.0138;
	private double convert60 = 0.0167;
	private double convert80 = 0.022;
	private double Cost=0;
	private int numBags = 0;
	private double cubYards=0;

	
	/**
	 * 
	 */
	public Concrete() {
	}
	/**
	 * @param width
	 * @param length
	 * @param thickness
	 * @param bagSize
	 */
	public Concrete(double width, double length, double thickness, int bagSize) {
		this.width = width;
		this.length = length;
		this.thickness = thickness/12;
		this.bagSize = bagSize;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getThickness() {
		return thickness;
	}
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	public double getBagSize() {
		return bagSize;
	}
	public void setBagSize(int bagSize) {
		this.bagSize = bagSize;
	} 
	
	
	// Create formula for concrete conversions
	public double getCost() {
		
		switch (bagSize) {
		
		
		case 50:
			Cost = ((int) Math.ceil(((double)(width/3 * length/3 * thickness/3))/convert50))* rate50;
			return Cost;
		
		case 60:
			Cost = ((int) Math.ceil(((double)(width/3 * length/3 * thickness/3))/convert60))* rate60;
			return Cost;
		
		case 80:
		    Cost = ((int) Math.ceil(((double)(width/3 * length/3 * thickness/3))/convert80))* rate80;
		    return Cost;
		
		default:
			Cost = 0;
			return Cost;
			
			
	

		}
		
		
		
	}

public int getNumBags() {
		
		switch (bagSize) {
		
		
		case 50:
			numBags= (int) Math.ceil(((double)(width/3 * length/3 * thickness/3))/convert50);
			return numBags;
		
		case 60:
			numBags = (int) Math.ceil(((double)(width/3 * length/3 * thickness/3))/convert60);
			return numBags;
		
		case 80:
			numBags = (int) Math.ceil(((double)(width/3 * length/3 * thickness/3))/convert80);
		    return numBags;
		
		default:
			
			return 0;
		}
			
			
	

		}
		
		public double getCubYards() {
			
			switch (bagSize) {
			
			
			case 50:
				cubYards=((double)(width/3 * length/3 * thickness/3));
				return cubYards;
			
			case 60:
				cubYards= ((double)(width/3 * length/3 * thickness/3));
				return cubYards;
			
			case 80:
				cubYards = ((double)(width/3 * length/3 * thickness/3));
			    return cubYards;
			
			default:
				
				return 0;
			}
				
				
		

			}
			//getConcrete consolidates the formulas into one place and adds html
			 public String getConcrete() {
			        String concreteHTML = "";
			        
			        NumberFormat cf = NumberFormat.getCurrencyInstance();
			        NumberFormat pf = NumberFormat.getInstance();
			        pf.setMaximumFractionDigits(2);
			        cf.setMaximumFractionDigits(2);
			        
			        concreteHTML += "<h2>Here are your slab input values:</h2>";
			        concreteHTML += "<p>Width: " + pf.format(this.width) + " feet</p>";
			        concreteHTML += "<p>Length: " +   pf.format(this.length) + " feet</p>";
			        concreteHTML += "<p>Thickness: " + pf.format(this.thickness*12) + " inches</p>";
			        concreteHTML += "<p>Bag Size: " + pf.format(this.bagSize) + "</p>";
			        concreteHTML += "<h2>This will require the following:</h2>";
			        concreteHTML += "<p>Total Cubic Yards: " + pf.format(this.getCubYards()) + "</p>";
			        concreteHTML += "<p>Total Number of Bags: " + this.getNumBags() + "</p>";
			        concreteHTML += "<p>Estimated cost: " + cf.format(this.getCost()) + "</p>";
			        

			        return concreteHTML;
			
		
		
		
		
		
	}

	
	
	
}
