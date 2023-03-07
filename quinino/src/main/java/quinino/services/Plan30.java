package quinino.services;

import java.sql.SQLException;

public class Plan30 extends Plan {
	
	private int plan = 30;
	
	public Plan30(String sourceCode, String destinationCode, Float timeInMinutes) throws SQLException {
		super(sourceCode, destinationCode, timeInMinutes);
	}


	@Override
	public double calculatePlan() {

		try {
			
			if(timeInMinutes > plan) {
				return (timeInMinutes - plan) * getPlandao().getTaxa(sourceCode, destinationCode) * 1.1 ;
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0.0;
		
	}

}
