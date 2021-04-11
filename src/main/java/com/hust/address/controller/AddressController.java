package com.hust.address.controller;

import java.security.Principal;
import java.util.List;

import com.hust.address.entity.Commune;
import com.hust.address.entity.District;
import com.hust.address.entity.Province;
import com.hust.address.model.InputModelCommune;
import com.hust.address.model.InputModelDistrict;
import com.hust.address.service.CommuneService;
import com.hust.address.service.DistrictService;
import com.hust.address.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private CommuneService communeService;
	
	
	@GetMapping("/get-all-province")
	public ResponseEntity<?> getAllProvince(Principal principal){
		List<Province> depts = provinceService.getAllProvince();
		return ResponseEntity.ok().body(depts);
	}
	
	@PostMapping("/get-all-district")
	public ResponseEntity<?> getAllDistrict(Principal principal, @RequestBody InputModelDistrict input){
		List<District> dis = districtService.getAllDistrict(input.getProvinceId());
		return ResponseEntity.ok().body(dis);
	}
	
	@PostMapping("/get-all-commune")
	public ResponseEntity<?> getAllCommune(Principal principal, @RequestBody InputModelCommune input){
		List<Commune> com = communeService.getAllCommune(input.getDistrictId());
		return ResponseEntity.ok().body(com);
	}
}
