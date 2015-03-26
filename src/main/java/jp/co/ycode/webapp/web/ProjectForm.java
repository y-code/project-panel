package jp.co.ycode.webapp.web;

import java.security.Principal;

import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.User;
import jp.co.ycode.webapp.domain.service.ProjectMgmtService;
import jp.co.ycode.webapp.domain.service.UserMgmtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/admin/project")
@SessionAttributes("project")
public class ProjectForm {
	
	@Autowired
	private UserMgmtService userMgmtService;
	
	@Autowired
	private ProjectMgmtService projectMgmtService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		dataBinder.setDisallowedFields("id");
		dataBinder.setAllowedFields("name", "vision", "mission");
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String processGet(ModelMap model,
			@RequestParam(value = "id", required = false)
			String strProjectId,
			Principal principal)
	{
		//TODO: Need a check to validate the user should be the project owner or member.
		
		User user = this.userMgmtService.getUserByPrincipal(principal);
		
		Project project = null;
		if (strProjectId == null)
		{
			if (!this.projectMgmtService.isUserStillAbleToAddNewProject(user))
			{
				if (user.isPremiumUser())
				{
					model.addAttribute("message", "Thank you for using our services. Unfortunately, you have already made your projects upto the max number. If you would like to get a special offer, please contact us.");
					return "error";
				}
				else
				{
					model.addAttribute("message", "You have made your projects upto the number that is allowed for a general user. Please consider to upgrade your user account to the premium user account.");
					return "premiumsignup";
				}
			}
		}
		else
		{
			try {
				int projectId = Integer.parseInt(strProjectId);
				project = this.projectMgmtService.getProjectById(projectId);
			} catch (NumberFormatException e) {
				//Process as adding new Project.
			}
		}
		if (project == null)
			project = new Project();
		model.addAttribute("project", project);
		return "admin/project";
	}
	
	@RequestMapping(params = "add_project", method = RequestMethod.POST)
	public String processPostAddProject(Project project, BindingResult result, SessionStatus status, Principal principal)
	{
		User user = this.userMgmtService.getUserByPrincipal(principal);
		this.projectMgmtService.addNewProject(project, user);
		status.setComplete();
		return "redirect:/admin/project?id=" + project.getId();
	}
	
	@RequestMapping(params = "update_project", method = RequestMethod.POST)
	public String processPostUpadteProject(Project project, BindingResult result, SessionStatus status, Principal principal)
	{
		this.projectMgmtService.saveProject(project);
		status.setComplete();
		return "redirect:/admin";
	}
	
}
