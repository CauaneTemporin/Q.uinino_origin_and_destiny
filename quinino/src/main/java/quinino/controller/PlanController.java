package quinino.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quinino.services.Plan;
import quinino.services.Plan120;
import quinino.services.Plan30;
import quinino.services.Plan60;

public class PlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Plan planFactory;

	public PlanController() {
		super();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dddOrigin = String.valueOf(request.getParameter("txtOrigin"));
		String dddDestiny = String.valueOf(request.getParameter("txtDestiny"));
		Float timeInMinutes = Float.parseFloat(String.valueOf(request.getParameter("txtTime")));

		try {
			switch (String.valueOf(request.getParameter("slctPlan"))) {
			case "30":
				planFactory = new Plan30(dddOrigin, dddDestiny, timeInMinutes);
				break;
			case "60":
				planFactory = new Plan60(dddOrigin, dddDestiny, timeInMinutes);
				break;

			case "120":
				planFactory = new Plan120(dddOrigin, dddDestiny, timeInMinutes);
				break;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		SetarValores(request, response, planFactory);

	}

	public void SetarValores(HttpServletRequest request, HttpServletResponse response, Plan plan)
			throws ServletException, IOException {

		request.setAttribute("valueOrigin", plan.getSourceCode());
		request.setAttribute("valueDestination", plan.getDestinationCode());
		request.setAttribute("valueTimeMinutes", plan.getTimeInMinutes());
		request.setAttribute("priceWithoutPlan", String.format("%.2f", plan.getPriceWithoutPlan()));
		request.setAttribute("priceWithPlan", String.format("%.2f", plan.calculatePlan()));
		
		request.setAttribute("plan", String.valueOf(request.getParameter("slctPlan")));
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);

	}

}
