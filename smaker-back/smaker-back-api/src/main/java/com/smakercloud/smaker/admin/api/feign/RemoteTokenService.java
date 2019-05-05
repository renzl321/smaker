/*
 *  Copyright (c) .
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
smakercloud.smaker

 */

package com.smakercloud.smaker.admin.api.feign;

import com.smakercloud.smaker.admin.api.feign.factory.RemoteTokenServiceFallbackFactory;
import com.smakercloud.smaker.common.core.constant.SecurityConstants;
import com.smakercloud.smaker.common.core.constant.ServiceNameConstants;
import com.smakercloud.smaker.common.core.util.SmakerResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author renzl
 * @date 2019/2/1
 */
@FeignClient(value = ServiceNameConstants.AUTH_SERVICE, fallbackFactory = RemoteTokenServiceFallbackFactory.class)
public interface RemoteTokenService {
	/**
	 * 分页查询token 信息
	 *
	 * @param params 分页参数
	 * @param from   内部调用标志
	 * @return page
	 */
	@PostMapping("/oauth/listToken")
	SmakerResult selectPage(@RequestBody Map<String, Object> params, @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 删除token
	 *
	 * @param token token
	 * @param from  调用标志
	 * @return
	 */
	@DeleteMapping("/oauth/delToken/{token}")
	SmakerResult<Boolean> deleteTokenById(@PathVariable("token") String token, @RequestHeader(SecurityConstants.FROM) String from);
}
