package jp.co.ycode.webapp.web;

import java.security.Principal;

import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.ProjectGoal;
import jp.co.ycode.webapp.domain.ProjectMember;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/admin/member")
@SessionAttributes("goal")
public class MemberForm {

	@Autowired
	private UserMgmtService userMgmtService;
	
	@Autowired
	private ProjectMgmtService projectMgmtService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		dataBinder.setDisallowedFields("id");
		dataBinder.setAllowedFields("goal");
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String processGetGoal(ModelMap model, Principal principal,
			@RequestParam(value = "id", required = false)
			String strGoalId,
			@RequestParam(value = "projectid", required = false)
			String strProjectId)
	{
		User user = userMgmtService.getUserByPrincipal(principal);
		Project project = null;
		ProjectGoal goal = null;
		
		if (strGoalId == null && strProjectId == null)
		{
			model.addAttribute("message", "You have requested a page with an invalid URL. If you are so sure that the URL you used is right, please send the URL to us. We will look after it.");
			return "error";
		}
		else if (strGoalId != null)
		{
			int goalId;
			try
			{
				goalId = Integer.parseInt(strGoalId);
			}
			catch (NumberFormatException e)
			{
				model.addAttribute("message", "You have requested a page with an invalid URL. If you are so sure that the URL you used is right, please send the URL to us. We will look after it.");
				return "error";
			}
			project = this.projectMgmtService.getProjectByGoalId(goalId);
			
			if (project == null)
			{
				model.addAttribute("message", "You have requested an page to edit a goal. However, the goal was not found. If you are so sure that the URL you used is right, please send the URL to us. We will look after it.");
				return "error";
			}
			
			goal = project.getGoal(goalId);
		}
		else
		{
			try
			{
				int projectId = Integer.parseInt(strProjectId);
				project = this.projectMgmtService.getProjectById(projectId);
				
				if (project == null)
				{
					model.addAttribute("message", "You have requested an page to edit a goal. However, the project to which you add a goal was not found. If you are so sure that the URL you used is right, please send the URL to us. We will look after it.");
					return "error";
				}
			}
			catch (NumberFormatException e)
			{
				model.addAttribute("message", "You have requested a page with an invalid URL. If you are so sure that the URL you used is right, please send the URL to us. We will look after it.");
				return "error";
			}
			
			goal = new ProjectGoal(project);
		}
		
		ProjectMember member = project.getMember(user.getId());
		if (member == null)
		{
			model.addAttribute("message", "You cannot access this page because you are not a member of the project \"" + project.getName() + "\".");
		}
		
		model.addAttribute("goal", goal);
		
		return "admin/goal";
	}
	
	@RequestMapping(params = "add_member", method = RequestMethod.POST)
	public String processPostAddGoal(SessionStatus status, Principal principal, ModelMap model,
			@ModelAttribute("goal")
			ProjectGoal goal,
			BindingResult result, // An attribute of BindingResult class need to be placed after an attribute bound with the post request.
			ProjectGoal goal0,
			BindingResult result0)
	{
		// The parameter goal is an object comming from the session and updated with the post request.
		// The parameter goal0 is an object newly initialized and updated with the post request.
		// Therefore, @ModelAttribute must be used in this case
		// in order to get an object via ProjectGoal.getProject(), which was set in 'processGetGoal' method above.
		User user = userMgmtService.getUserByPrincipal(principal);
		if (!this.projectMgmtService.isUserAllowedToEditPoject(user, goal.getProject().getId()))
		{
			model.addAttribute("message", "You have to be a member of the project \"" + goal.getProject().getName() + "\" to add goals to it.");
			return "error";
		}
		
		this.projectMgmtService.addNewGoal(goal);
//		return "redirect:/admin/listofgoals?id=" + goal.getProject().getId();
		return "redirect:/admin/project?id=" + goal.getProject().getId();
	}
	
	@RequestMapping(params = "update_member", method = RequestMethod.POST)
	public String processPostUpadteGaol(SessionStatus status, Principal principal, ModelMap model,
			@ModelAttribute("goal")
			ProjectGoal goal,
			BindingResult result)
	{
		User user = userMgmtService.getUserByPrincipal(principal);
		if (!this.projectMgmtService.isUserAllowedToEditPoject(user, goal.getProject().getId()))
		{
			model.addAttribute("message", "You have to be a member of the project \"" + goal.getProject().getName() + "\" to edit its goals.");
			return "error";
		}
		
		this.projectMgmtService.saveGoal(goal);
//		return "redirect:/admin/listofgoals?id=" + goal.getProject().getId();
		return "redirect:/admin/project?id=" + goal.getProject().getId();
	}
	
}
