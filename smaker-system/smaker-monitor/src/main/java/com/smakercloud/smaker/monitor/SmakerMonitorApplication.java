/*
 *  Copyright (c) .
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
smakercloud.smaker

 */

package com.smakercloud.smaker.monitor;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author renzl
 * @date 2018年06月21日
 * 监控中心
 */
@EnableAdminServer
@SpringCloudApplication
public class SmakerMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmakerMonitorApplication.class, args);
	}
}
