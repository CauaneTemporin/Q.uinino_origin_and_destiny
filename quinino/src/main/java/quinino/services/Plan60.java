package quinino.services;

import java.sql.SQLException;

public class Plan60 extends Plan{
	
	public Plan60(String sourceCode, String destinationCode, Float timeInMinutes) throws SQLException {
		super(sourceCode, destinationCode, timeInMinutes);
	}

	private int plan = 60;

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
