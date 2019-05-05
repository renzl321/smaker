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

package com.smakercloud.smaker.common.core.util;

import com.smakercloud.smaker.common.core.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 响应信息主体
 *
 * @param <T>
 * @author renzl
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class SmakerResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code = CommonConstants.SUCCESS;

	@Getter
	@Setter
	private String msg = "success";


	@Getter
	@Setter
	private T data;

	public SmakerResult() {
		super();
	}

	public SmakerResult(T data) {
		super();
		this.data = data;
	}

	public SmakerResult(T data, String msg) {
		super();
		this.data = data;
		this.msg = msg;
	}

	public SmakerResult(Throwable e) {
		super();
		this.msg = e.getMessage();
		this.code = CommonConstants.FAIL;
	}
}
