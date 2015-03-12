package jp.co.ycode.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Hello world!
 *
 */
@Controller
public class WelcomeController 
{
	@RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView processGetWelcome()
    {
		ModelAndView model = new ModelAndView();
        model.addObject("message", "Hello World");
        model.setViewName("welcome");
		return model;
    }
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView processGetAdmin()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Projec Panel");
		model.addObject("message", "This is protected page.");
		model.setViewName("admin");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView processGetLogin(
			@RequestParam(value = "error", required = false)
			String error,
			@RequestParam(value = "logout", required = false)
			String logout)
	{
		ModelAndView model = new ModelAndView();
		if (error != null)
			model.addObject("error", "Invalid username and/or password");
		if (logout != null)
			model.addObject("message", "You've been successfully logged out.");
		return model;
	}
	
	@RequestMapping(value = "/devroom**", method = RequestMethod.GET)
    public String processGetDevroom()
    {
		return "devroom";
    }
	
}
