/*
 *  Copyright (c) 2019-2020,.
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>

 */

package com.smakercloud.smaker.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smakercloud.smaker.common.security.component.CloudAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author renzl
 * @date 2019/2/1
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = CloudAuth2ExceptionSerializer.class)
public class CloudAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public CloudAuth2Exception(String msg) {
		super(msg);
	}

	public CloudAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
