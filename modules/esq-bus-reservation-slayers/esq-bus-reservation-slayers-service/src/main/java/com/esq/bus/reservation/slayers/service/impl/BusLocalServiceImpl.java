/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.esq.bus.reservation.slayers.service.impl;

import com.esq.bus.reservation.slayers.model.Bus;
import com.esq.bus.reservation.slayers.service.base.BusLocalServiceBaseImpl;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author kumar
 */
@Component(
	property = "model.class.name=com.esq.bus.reservation.slayers.model.Bus",
	service = AopService.class
)
public class BusLocalServiceImpl extends BusLocalServiceBaseImpl {

	@Override
	public Bus addBus(String busNumber, String busPlateNumber,int busType, int capacity,long userId,String image1, String image2,String image3,String image4,String image5) {
	    try {
	        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	        long groupId = serviceContext.getScopeGroupId(); 

	        long busId = counterLocalService.increment(Bus.class.getName());
	        Bus bus = busPersistence.create(busId);

	        
	        Folder busRootFolder = createFolderIfNotExists(
	                groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Bus", serviceContext);

	        // 2. Create specific folder for this bus
	        Folder busSpecificFolder = createFolderIfNotExists(
	                groupId, busRootFolder.getFolderId(), String.valueOf(busId), serviceContext);

	        // 3. Upload images if available
	        if (image1 != null && !image1.isEmpty()) {
	            String url = uploadImage(groupId, busSpecificFolder.getFolderId(), image1, "image1_" + busId + ".jpg", serviceContext);
	            bus.setImage1(url);
	        }
	        if (image2 != null && !image2.isEmpty()) {
	            String url = uploadImage(groupId, busSpecificFolder.getFolderId(), image2, "image2_" + busId + ".jpg", serviceContext);
	            bus.setImage2(url);
	        }
	        if (image3 != null && !image3.isEmpty()) {
	            String url = uploadImage(groupId, busSpecificFolder.getFolderId(), image3, "image3_" + busId + ".jpg", serviceContext);
	            bus.setImage3(url);
	        }
	        if (image4 != null && !image4.isEmpty()) {
	            String url = uploadImage(groupId, busSpecificFolder.getFolderId(), image4, "image4_" + busId + ".jpg", serviceContext);
	            bus.setImage4(url);
	        }
	        if (image5 != null && !image5.isEmpty()) {
	            String url = uploadImage(groupId, busSpecificFolder.getFolderId(), image5, "image5_" + busId + ".jpg", serviceContext);
	            bus.setImage5(url);
	        }

	        // 4. Set other fields
	        bus.setBusNumber(busNumber);
	        bus.setBusPlateNumber(busPlateNumber);
	        bus.setBusType(busType);
	        bus.setBusId(busId);
	        bus.setUserId(userId);
	        bus.setCapacity(capacity);

	        // 5. Save Bus to database
	        return super.addBus(bus);

	    } catch (Exception e) {
	        _log.error("Error adding bus with images: " + busNumber, e);
	        throw new RuntimeException("Failed to add bus with images", e);
	    }
	}
	
	private Folder createFolderIfNotExists(long groupId, long parentFolderId, String folderName, ServiceContext serviceContext) throws Exception {
	    try {
	        return DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
	    } catch (NoSuchFolderException e) {
	        return DLAppServiceUtil.addFolder(
	            folderName, groupId,
	            parentFolderId,
	            folderName,
	            "Auto-created folder for bus images",
	            serviceContext
	        );
	    }
	}

	private String uploadImage(long groupId, long folderId, String base64Image, String fileName, ServiceContext serviceContext) throws Exception {
	    byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

	    InputStream inputStream = new ByteArrayInputStream(decodedBytes);

	    FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
	            fileName, groupId,
	            folderId,
	            fileName,
	            ContentTypes.IMAGE_JPEG,
	            fileName,
	            "",
	            "",
	            fileName, inputStream,
	            decodedBytes.length,
	            null, null, serviceContext
	    );

	    return "/documents/" + fileEntry.getRepositoryId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getTitle();
	}

	
	
	@Override
	public Bus deleteBus(Bus bus) {
		
		return super.deleteBus(bus);
	}

	@Override
	public Bus updateBus(Bus bus) {
		
		return super.updateBus(bus);
	}
	
	public List<Bus> getAllBuses() {
	    return busPersistence.findAll();
	}

           
	
	private static final Log _log = LogFactoryUtil.getLog(BusLocalServiceImpl.class);

	
    }
