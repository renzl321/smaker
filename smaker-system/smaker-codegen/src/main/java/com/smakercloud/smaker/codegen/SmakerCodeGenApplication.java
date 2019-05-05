/*
 *  Copyright (c) .
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
smakercloud.smaker

 */

package com.smakercloud.smaker.codegen;

import com.smakercloud.smaker.common.security.annotation.EnableSmakerFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author renzl
 * @date 2019/2/1
 * 代码生成模块
 */
@SpringCloudApplication
@EnableSmakerFeignClients
public class SmakerCodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmakerCodeGenApplication.class, args);
	}
}
