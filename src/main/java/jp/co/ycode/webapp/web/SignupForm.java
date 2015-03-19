package jp.co.ycode.webapp.web;

import jp.co.ycode.webapp.domain.User;
import jp.co.ycode.webapp.domain.service.UserMgmtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for Sign up functionality
 * @author Yas Ikeda
 * @see http://levelup.lishman.com/spring/hibernate-orm/quick-start.php
 * TODO: Add Facebook login. Firstly, refer the page:
 *   - http://projects.spring.io/spring-social-facebook/
 *   - http://www.petrikainulainen.net/programming/spring-framework/adding-social-sign-in-to-a-spring-mvc-web-application-configuration/
 */
@Controller
@RequestMapping("/signup")
@SessionAttributes("user")
public class SignupForm {
	
	@Autowired
	private UserMgmtService userMgmtService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		dataBinder.setDisallowedFields("id");
		dataBinder.setAllowedFields("firstName", "lastName", "name", "password", "email");
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView processGet()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		return model;
	}
	
	@RequestMapping(params = "signup", method = RequestMethod.POST)
	public String signup(User user, BindingResult result, SessionStatus status)
	{
		this.userMgmtService.signupUser(user);
		status.setComplete();
		return "redirect:/signedup";
	}
	
}
