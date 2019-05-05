/*
 *  Copyright (c) .
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
smakercloud.smaker

 */

package com.smakercloud.smaker.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smakercloud.smaker.admin.api.entity.SysOauthClientDetails;
import com.smakercloud.smaker.admin.service.SysOauthClientDetailsService;
import com.smakercloud.smaker.common.core.util.SmakerResult;
import com.smakercloud.smaker.common.log.annotation.SysLog;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author renzl
 * @since 2018-05-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class OauthClientDetailsController {
	private final SysOauthClientDetailsService sysOauthClientDetailsService;

	/**
	 * 通过ID查询
	 *
	 * @param id ID
	 * @return SysOauthClientDetails
	 */
	@GetMapping("/{id}")
	public SmakerResult getById(@PathVariable Integer id) {
		return new SmakerResult<>(sysOauthClientDetailsService.getById(id));
	}


	/**
	 * 简单分页查询
	 *
	 * @param page                  分页对象
	 * @param sysOauthClientDetails 系统终端
	 * @return
	 */
	@GetMapping("/page")
	public SmakerResult getOauthClientDetailsPage(Page page, SysOauthClientDetails sysOauthClientDetails) {
		return new SmakerResult<>(sysOauthClientDetailsService.page(page, Wrappers.query(sysOauthClientDetails)));
	}

	/**
	 * 添加
	 *
	 * @param sysOauthClientDetails 实体
	 * @return success/false
	 */
	@SysLog("添加终端")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('sys_client_add')")
	public SmakerResult add(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
		return new SmakerResult<>(sysOauthClientDetailsService.save(sysOauthClientDetails));
	}

	/**
	 * 删除
	 *
	 * @param id ID
	 * @return success/false
	 */
	@SysLog("删除终端")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_client_del')")
	public SmakerResult removeById(@PathVariable String id) {
		return new SmakerResult<>(sysOauthClientDetailsService.removeClientDetailsById(id));
	}

	/**
	 * 编辑
	 *
	 * @param sysOauthClientDetails 实体
	 * @return success/false
	 */
	@SysLog("编辑终端")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('sys_client_edit')")
	public SmakerResult update(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
		return new SmakerResult<>(sysOauthClientDetailsService.updateClientDetailsById(sysOauthClientDetails));
	}
}
