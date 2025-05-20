package com.user.bus.reservation.portlet;

import com.esq.bus.reservation.slayers.model.Bus;
import com.esq.bus.reservation.slayers.service.BusLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.user.bus.reservation.constants.User_bus_reservationPortletKeys;

import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + User_bus_reservationPortletKeys.USER_BUS_RESERVATION,
	        "mvc.command.name=addEmployee"
	    },
	    service = MVCActionCommand.class
	)
public class Bususer_reservation extends BaseMVCActionCommand {
	
	
	@Reference
    private BusLocalService busLocalService;

    private static final Log _log = LogFactoryUtil.getLog(Bususer_reservation.class);


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
          System.out.println("Excecuting Method::::::");
		
		
          
          UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

          try {
              String busNumber = ParamUtil.getString(uploadPortletRequest, "busNumber");
              String busPlateNumber = ParamUtil.getString(uploadPortletRequest, "busPlateNumber");
              int busType = ParamUtil.getInteger(uploadPortletRequest, "busType");
              int capacity = ParamUtil.getInteger(uploadPortletRequest, "capacity");
              long userId = PortalUtil.getUserId(actionRequest);

              // Read uploaded files safely
              String image1Base64 = convertInputStreamToBase64(uploadPortletRequest.getFileAsStream("image1"));
              String image2Base64 = convertInputStreamToBase64(uploadPortletRequest.getFileAsStream("image2"));
              String image3Base64 = convertInputStreamToBase64(uploadPortletRequest.getFileAsStream("image3"));
              String image4Base64 = convertInputStreamToBase64(uploadPortletRequest.getFileAsStream("image4"));
              String image5Base64 = convertInputStreamToBase64(uploadPortletRequest.getFileAsStream("image5"));

              // Service call
              Bus bus = busLocalService.addBus(
                  busNumber,
                  busPlateNumber,
                  busType,
                  capacity,
                  userId,
                  image1Base64,
                  image2Base64,
                  image3Base64,
                  image4Base64,
                  image5Base64
              );

              // Success
              actionResponse.setRenderParameter("mvcPath", "/view.jsp");

          } catch (Exception e) {
              _log.error("Error while adding bus details: ", e);
              throw new PortletException("Error adding bus", e);
          }
      }

      private String convertInputStreamToBase64(InputStream inputStream) throws Exception {
          if (inputStream == null) {
              return null;
          }
          byte[] bytes = inputStream.readAllBytes();
          return java.util.Base64.getEncoder().encodeToString(bytes);
      }
  }          
	


