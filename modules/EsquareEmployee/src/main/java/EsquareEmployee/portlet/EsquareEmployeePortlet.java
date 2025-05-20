package EsquareEmployee.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import EsquareEmployee.constants.EsquareEmployeePortletKeys;
import EsquareEmployee_Slayer.model.Employees;
import EsquareEmployee_Slayer.service.EmployeesLocalServiceUtil;

/**
 * @author kuamr
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=EsquareEmployee", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EsquareEmployeePortletKeys.ESQUAREEMPLOYEE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EsquareEmployeePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<Employees> employeesList = EmployeesLocalServiceUtil.getEmployeeses(-1, -1);
		renderRequest.setAttribute("employeesList", employeesList);
		super.doView(renderRequest, renderResponse);
	}

	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException, PortalException {
		System.out.println("Excecuting Method::::::");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		String employeeName = ParamUtil.getString(actionRequest, "employeeName");
		System.out.println("Employee Name::::" + employeeName);
		String employeeMobileNumber = ParamUtil.getString(actionRequest, "employeeMobileNumber");
		String employeeDesignation = ParamUtil.getString(actionRequest, "employeeDesignation");
		System.out.println("employeeDesignation : :::::" + employeeDesignation);

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		InputStream empPhotoStream = uploadPortletRequest.getFileAsStream("employeePhoto");
		System.out.println("employeePhoto  ::::::" + empPhotoStream);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(EsquareEmployeePortlet.class.getName(),
				actionRequest);
		EmployeesLocalServiceUtil.addEmployees(groupId, companyId, employeeName, employeeMobileNumber,
				employeeDesignation, empPhotoStream, serviceContext);
		System.out.println("Employeee Created ::::::");
	}
  
	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException, PortalException {

		
		
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		System.out.println("Employee ID::::" + employeeId);
		String employeeName = ParamUtil.getString(actionRequest, "employeeName");
		System.out.println("Employee Name::::" + employeeName);
		String employeeMobileNumber = ParamUtil.getString(actionRequest, "employeeMobileNumber");
		System.out.println("employeeMobileNumber::::" + employeeMobileNumber);
		String employeeDesignation = ParamUtil.getString(actionRequest, "employeeDesignation");
		System.out.println("employeeDesignation : :::::" + employeeDesignation);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		InputStream empPhotoStream = uploadPortletRequest.getFileAsStream("employeePhoto");
		System.out.println("employeePhoto  ::::::" + empPhotoStream);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(EsquareEmployeePortlet.class.getName(),
				actionRequest);
		  
		 
		

		EmployeesLocalServiceUtil.updateEmployees(employeeId, employeeName, employeeMobileNumber, employeeDesignation,
				empPhotoStream,serviceContext);
		_log.info("End UpdateEmployee Method :::::::");
	}

	public void deleteEntry(ActionRequest request, ActionResponse response) throws Exception {
		_log.info("Started deleteEmployee Method :::::::");
		
		long employeeId = ParamUtil.getLong(request, "employeeId", GetterUtil.DEFAULT_LONG);
		try {
			EmployeesLocalServiceUtil.deleteEmployees(employeeId);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		_log.info("Employee deleted successfully.");
	}

	private static final Log _log = LogFactoryUtil.getLog(EsquareEmployeePortlet.class);
}
