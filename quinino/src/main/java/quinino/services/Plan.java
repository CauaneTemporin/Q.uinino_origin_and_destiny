package quinino.services;


import java.sql.SQLException;

import quinino.DAO.PlanDAO;



public abstract class Plan {
	
	protected   String sourceCode;  
	protected   String destinationCode;

	protected   float timeInMinutes;
	protected   double  priceWithoutPlan;
	
	protected   PlanDAO plandao = new PlanDAO();
 
    
    public Plan(String sourceCode, String destinationCode, float timeInMinutes){
    	this.sourceCode = sourceCode;
    	this.destinationCode = destinationCode;
    	this.timeInMinutes = timeInMinutes;
    	try {
			calculateWithouPlan();
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    
	public  void calculateWithouPlan() throws SQLException   {
		priceWithoutPlan =  timeInMinutes * plandao.getTaxa(sourceCode, destinationCode);
		
	}
    
    public abstract double calculatePlan();

	
    public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}


	public String getDestinationCode() {
		return destinationCode;
	}


	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}


	public float getTimeInMinutes() {  
		return timeInMinutes;
	}


	public void setTimeInMinutes(float timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}

	public double getPriceWithoutPlan() {
		return priceWithoutPlan;
	}

	public PlanDAO getPlandao() {
		return plandao;
	}
}
