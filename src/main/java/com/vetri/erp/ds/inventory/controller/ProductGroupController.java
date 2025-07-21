package com.vetri.erp.ds.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetri.erp.ds.inventory.dto.prodGroupDto;
import com.vetri.erp.ds.inventory.service.ProdGroupService;

@RestController
@RequestMapping("api/{orgId}/inventory/productGroup/")

public class ProductGroupController {

	@Autowired
	ProdGroupService prodGroupService;

	@GetMapping
	List<prodGroupDto> getAllProductGroup(@PathVariable Integer orgId) {
		return prodGroupService.getAll(orgId);
	}

	@GetMapping("{id}")
	prodGroupDto getByIdProductGroup(@PathVariable Integer orgId, @PathVariable Integer id) {
		return prodGroupService.getbyId(orgId, id);
	}

	@PutMapping
	prodGroupDto updateProductGroup(@PathVariable Integer orgId, @RequestBody prodGroupDto dto) {
		return prodGroupService.update(orgId, dto);
	}

	@PostMapping
	prodGroupDto saveProductGroup(@PathVariable Integer orgId, @RequestBody prodGroupDto dto) {
		return prodGroupService.save(dto);
	}

	@DeleteMapping("{id}")
	void deleteProductGroup(@PathVariable Integer orgId, @PathVariable Integer id) {
		prodGroupService.delete(orgId, id);
	}
}
