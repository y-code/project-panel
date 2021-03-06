package jp.co.ycode.webapp.web;

import java.security.Principal;

import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.ProjectMember;
import jp.co.ycode.webapp.domain.User;
import jp.co.ycode.webapp.domain.service.ProjectMgmtService;
import jp.co.ycode.webapp.domain.service.UserMgmtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	@Autowired
	private UserMgmtService userMgmtService;
	
	@Autowired
	private ProjectMgmtService projectMgmtService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String processGetAdmin(ModelMap model, Principal principal)
	{
		User user = userMgmtService.getUserByPrincipal(principal);
		model.addAttribute("projects", projectMgmtService.getAllProjectsByUser(user));
		return "admin";
	}
	
	@RequestMapping(value = "/admin/listofgoals", method = RequestMethod.GET)
	public String processGetListOfGoals(ModelMap model, Principal principal,
			@RequestParam(value = "id", required = true)
			String strProjectId)
	{
		User user = userMgmtService.getUserByPrincipal(principal);
		
		Project project = null;
		try
		{
			project = this.getProject(user, strProjectId);
		}
		catch (Exception e)
		{
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		
		model.addAttribute("project", project);
		return "admin/listofgoals";
	}
	
	@RequestMapping(value = "/admin/listofmembers", method = RequestMethod.GET)
	public String processGetListOfMembers(ModelMap model, Principal principal,
			@RequestParam(value = "id", required = true)
			String strProjectId)
	{
		User user = userMgmtService.getUserByPrincipal(principal);
		
		Project project = null;
		try
		{
			project = this.getProject(user, strProjectId);
		}
		catch (Exception e)
		{
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		
		model.addAttribute("project", project);
		return "admin/listofmembers";
	}
	
	private Project getProject(User user, String strProjectId) throws Exception
	{
		Project project = null;
		try
		{
			project = this.projectMgmtService.getProjectById(Integer.parseInt(strProjectId));
		}
		catch (NumberFormatException e)
		{
			throw new Exception("You have requested a page with an invalid URL. If you are so sure that the URL you used is right, please send the URL to us. We will look after it.");
		}
		
		if (project == null)
		{
			throw new Exception("You have requested a list of the members for invalid project. If you are so sure that the URL you used is right, please send the URL to us. We will look after it.");
		}
		
		ProjectMember member = project.getMember(user.getId());
		if (member == null)
		{
			throw new Exception("You cannot access this page because you are not a member of the project \"" + project.getName() + "\".");
		}
		
		return project;
	}
	
}
