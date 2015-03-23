package jp.co.ycode.webapp.web;

import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.service.ProjectMgmtService;
import jp.co.ycode.webapp.domain.service.UserMgmtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @Autowired
    private UserMgmtService userMgmtService;
    
    @Autowired
    private ProjectMgmtService projectMgmtService;
	
	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public ModelAndView processGetWelcome()
    {
		ModelAndView model = new ModelAndView();
        model.addObject("projects", projectMgmtService.getAllProjects())
        	.setViewName("welcome");
		return model;
    }
	
	@RequestMapping(value = "/projectpanel", method = RequestMethod.GET)
	public String processGetProjectPanel(ModelMap model,
			@RequestParam(value = "id", required = true)
			String strProjectId)
	{
		Project project = null;
		if (strProjectId != null)
		{
			try {
				int projectId = Integer.parseInt(strProjectId);
				project = this.projectMgmtService.getProjectById(projectId);
			} catch (NumberFormatException e) {
				//Display emply project.
			}
		}
		if (project == null)
			project = new Project();
		model.addAttribute("project", project);
		return "projectpanel";
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
	
	@RequestMapping(value = "/devroom", method = RequestMethod.GET)
    public String processGetDevroom()
    {
		return "devroom";
    }
	
	@RequestMapping(value = "/signedup", method = RequestMethod.GET)
	public String processGetSignedup()
	{
		return "signedup";
	}
	
}
