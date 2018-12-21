package webServices;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exceptions.CouponSystemException;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;

@Controller
public class LogIn {
/**
 * in this login we get from the user:
 * name,password and client-type.
 * if the login happen successfully we set the facade on the session . 
 * @throws CouponSystemException
 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doPostRedirect(

			@RequestParam String name, @RequestParam String pwd, @RequestParam String usertype, HttpServletRequest request)
			throws CouponSystemException {

		switch (usertype) {
		case "Admin":
			AdminFacade adminFacade = new AdminFacade();
			if (adminFacade.logIn(name, pwd)) {
				adminFacade.logIn(name, pwd);
				request.getSession().setAttribute("facade", adminFacade);
				return "redirect:http://localhost:8080/admin/index.html";
			}
			break;

		case "Company":
			CompanyFacade companyFacade = new CompanyFacade();
			if (companyFacade.logIn(name, pwd)) {
				companyFacade.logIn(name, pwd);
				request.getSession().setAttribute("facade", companyFacade);
				return "redirect:http://localhost:8080/company/index.html";
			}
			break;
		case "Customer":
			CustomerFacade customerFacade = new CustomerFacade();
			if (customerFacade.logIn(name, pwd)) {
				customerFacade.logIn(name, pwd);
				request.getSession().setAttribute("facade", customerFacade);
				return "redirect:http://localhost:8080/customer/index.html";
			}
			break;
		}
		return "redirect:http://localhost:8080";
	}

}
