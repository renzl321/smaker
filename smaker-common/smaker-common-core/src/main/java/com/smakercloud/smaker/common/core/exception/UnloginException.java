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

package com.smakercloud.smaker.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author renzl
 * @date 2018年06月22日16:22:10
 */
@NoArgsConstructor
public class UnloginException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnloginException(String message) {
		super(message);
	}

	public UnloginException(Throwable cause) {
		super(cause);
	}

	public UnloginException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnloginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
