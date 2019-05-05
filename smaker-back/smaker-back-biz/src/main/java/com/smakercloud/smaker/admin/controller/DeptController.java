/*
 *  Copyright (c) .
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
smakercloud.smaker

 */

package com.smakercloud.smaker.admin.controller;

import com.smakercloud.smaker.admin.api.entity.SysDept;
import com.smakercloud.smaker.admin.service.SysDeptService;
import com.smakercloud.smaker.common.core.util.SmakerResult;
import com.smakercloud.smaker.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author renzl
 * @since 2019/2/1
 */
@RestController
@AllArgsConstructor
@Api(value = "部门管理接口")
@RequestMapping("/dept")
public class DeptController {
	private final SysDeptService sysDeptService;

	/**
	 * 通过ID查询
	 *
	 * @param id ID
	 * @return SysDept
	 */
	@ApiOperation(value = "通过ID查询", notes = "通过ID查询")
	@ApiImplicitParam(name = "id", value = "新增用户组form表单", required = true, dataType = "Integer")
	@GetMapping("/{id}")
	public SmakerResult getById(@PathVariable Integer id) {
		return new SmakerResult<>(sysDeptService.getById(id));
	}


	/**
	 * 返回树形菜单集合
	 *
	 * @return 树形菜单
	 */
	@GetMapping(value = "/tree")
	public SmakerResult getTree() {
		return new SmakerResult<>(sysDeptService.selectTree());
	}

	/**
	 * 返回当前用户树形菜单集合
	 *
	 * @return 树形菜单
	 */
	@GetMapping(value = "/user-tree")
	public SmakerResult getUserTree() {
		return new SmakerResult<>(sysDeptService.getUserTree());
	}

	/**
	 * 添加
	 *
	 * @param sysDept 实体
	 * @return success/false
	 */
	@SysLog("添加部门")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('sys_dept_add')")
	public SmakerResult save(@Valid @RequestBody SysDept sysDept) {
		return new SmakerResult<>(sysDeptService.saveDept(sysDept));
	}

	/**
	 * 删除
	 *
	 * @param id ID
	 * @return success/false
	 */
	@SysLog("删除部门")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_dept_del')")
	public SmakerResult removeById(@PathVariable Integer id) {
		return new SmakerResult<>(sysDeptService.removeDeptById(id));
	}

	/**
	 * 编辑
	 *
	 * @param sysDept 实体
	 * @return success/false
	 */
	@SysLog("编辑部门")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('sys_dept_edit')")
	public SmakerResult update(@Valid @RequestBody SysDept sysDept) {
		sysDept.setUpdateTime(LocalDateTime.now());
		return new SmakerResult<>(sysDeptService.updateDeptById(sysDept));
	}
}
