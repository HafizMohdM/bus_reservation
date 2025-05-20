package EsquareEmployee.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=your_portlet_name", // Replace with your portlet name
	        "com.liferay.portlet.display-category=category.sample",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.security-role-ref=power-user,user"
	    },
	    service = javax.portlet.Portlet.class 
)	    
public class RoleChecking extends MVCPortlet {

	 private static final Log _log = LogFactoryUtil.getLog(RoleChecking.class);


	 @Override
	    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
	        try {
	            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

	            if (themeDisplay == null) {
	                _log.error("ThemeDisplay is null.");
	                return;
	            }

	            User currentUser = themeDisplay.getUser();
	            if (currentUser == null) {
	                _log.error("Current user is null.");
	                return;
	            }

	           
	            List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(currentUser.getUserId());
	            boolean isAdmin = false;
	            boolean isProAdmin = false;

	           
	            for (Role role : userRoles) {
	                if ("Admin".equals(role.getName())) {
	                    isAdmin = true;
	                } else if ("ProAdmin".equals(role.getName())) {
	                    isProAdmin = true;
	                }
	            }

	          
	            _log.info("User ID: " + currentUser.getUserId());
	            _log.info("Is Admin: " + isAdmin);
	            _log.info("Is ProAdmin: " + isProAdmin);

	           
	            renderRequest.setAttribute("isAdmin", isAdmin);
	            renderRequest.setAttribute("isProAdmin", isProAdmin);

	            super.doView(renderRequest, renderResponse); // Call the parent doView method
	        } catch (Exception e) {
	            _log.error("Error in EsquareEmployeePortlet doView method", e);
	        }
	    }
	 


}
