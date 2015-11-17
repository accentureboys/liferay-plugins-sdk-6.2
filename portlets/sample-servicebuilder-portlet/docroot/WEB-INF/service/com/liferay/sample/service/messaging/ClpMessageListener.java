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

package com.liferay.sample.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay.sample.service.ClpSerializer;
import com.liferay.sample.service.DegreeLocalServiceUtil;
import com.liferay.sample.service.DegreeServiceUtil;
import com.liferay.sample.service.EducationLocalServiceUtil;
import com.liferay.sample.service.EducationServiceUtil;
import com.liferay.sample.service.HonourLocalServiceUtil;
import com.liferay.sample.service.HonourServiceUtil;
import com.liferay.sample.service.MajorLocalServiceUtil;
import com.liferay.sample.service.MajorServiceUtil;
import com.liferay.sample.service.PropertyLocalServiceUtil;
import com.liferay.sample.service.PropertyServiceUtil;
import com.liferay.sample.service.ThesisLocalServiceUtil;
import com.liferay.sample.service.ThesisServiceUtil;

/**
 * @author jasonxiang
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			DegreeLocalServiceUtil.clearService();

			DegreeServiceUtil.clearService();
			EducationLocalServiceUtil.clearService();

			EducationServiceUtil.clearService();
			HonourLocalServiceUtil.clearService();

			HonourServiceUtil.clearService();
			MajorLocalServiceUtil.clearService();

			MajorServiceUtil.clearService();
			PropertyLocalServiceUtil.clearService();

			PropertyServiceUtil.clearService();
			ThesisLocalServiceUtil.clearService();

			ThesisServiceUtil.clearService();
		}
	}
}