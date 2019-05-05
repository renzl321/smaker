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

package com.smakercloud.smaker.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.smakercloud.smaker.common.core.constant.CommonConstants;
import com.smakercloud.smaker.common.security.exception.CloudAuth2Exception;
import lombok.SneakyThrows;

/**
 * @author renzl
 * @date 2019/2/1
 * <p>
 * OAuth2 异常格式化
 */
public class CloudAuth2ExceptionSerializer extends StdSerializer<CloudAuth2Exception> {
	public CloudAuth2ExceptionSerializer() {
		super(CloudAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(CloudAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
