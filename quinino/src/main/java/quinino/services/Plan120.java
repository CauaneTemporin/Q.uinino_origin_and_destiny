package quinino.services;

import java.sql.SQLException;

public class Plan120 extends Plan {
	
	private int plan = 120;
	
	public Plan120(String sourceCode, String destinationCode, Float timeInMinutes) throws SQLException {
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
