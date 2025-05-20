package com.user.bus.reservation.portlet;

import com.esq.bus.reservation.slayers.model.Bus;
import com.esq.bus.reservation.slayers.service.BusLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=your_portlet_name",
	        "mvc.command.name=/view"
	    },
	    service = MVCRenderCommand.class
	)
public class ViewBusesMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
    private BusLocalService busLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
            List<Bus> busList = busLocalService.getBuses(-1, -1);
            renderRequest.setAttribute("busList", busList);
        } catch (Exception e) {
            throw new PortletException("Unable to retrieve bus list", e);
        }
        return "/view.jsp";
    }

}
