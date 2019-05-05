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
 * @date 2018年06月22日16:22:03
 * 403 授权拒绝
 */
@NoArgsConstructor
public class SmakerDeniedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SmakerDeniedException(String message) {
		super(message);
	}

	public SmakerDeniedException(Throwable cause) {
		super(cause);
	}

	public SmakerDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SmakerDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
