package com.dit.himachal.apicontroller;

import com.dit.himachal.entities.BarrierMaster;
import com.dit.himachal.entities.DistrictMaster;
import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.entities.VehicleTypeMaster;
import com.dit.himachal.entities.VehicleUserType;
import com.dit.himachal.services.BarrierService;
import com.dit.himachal.services.DistrictService;
import com.dit.himachal.services.StatesService;
import com.dit.himachal.services.VehicleTypeService;
import com.dit.himachal.services.VehicleUserTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class API {

	@Autowired
	private StatesService statesService;

	@Autowired
	private DistrictService districtService;

	@Autowired
	private BarrierService barrierService;

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@Autowired
	private VehicleUserTypeService vehicleUserTypeService;

	public VehicleUserTypeService getVehicleUserTypeService() {
		return vehicleUserTypeService;
	}

	public void setVehicleUserTypeService(VehicleUserTypeService vehicleUserTypeService) {
		this.vehicleUserTypeService = vehicleUserTypeService;
	}

	public StatesService getStatesService() {
		return statesService;
	}

	public void setStatesService(StatesService statesService) {
		this.statesService = statesService;
	}

	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public BarrierService getBarrierService() {
		return barrierService;
	}

	public void setBarrierService(BarrierService barrierService) {
		this.barrierService = barrierService;
	}

	public VehicleTypeService getVehicleTypeService() {
		return vehicleTypeService;
	}

	public void setVehicleTypeService(VehicleTypeService vehicleTypeService) {
		this.vehicleTypeService = vehicleTypeService;
	}

	ObjectMapper objectMapper = new ObjectMapper();

	@Transactional()
	@RequestMapping(value = "/api/uploadData", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam(required = true, value = "file") MultipartFile file,
			@RequestParam(required = true, value = "jsondata") String jsondata) throws IOException {
		
		System.out.println("@#@# JsonData "+jsondata); 

		File convertFile = new File("C:\\Users\\Kush.Dhawan\\Desktop\\ImagePost" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();

//        UserData userData = objectMapper.readValue(jsondata, UserData.class);
//        System.out.println(userData.getFirstname());
//        System.out.println(userData.getLastname());

		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/states", method = RequestMethod.GET)
	public List<StatesMaster> getShops() {
		return statesService.getStates();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/districts/{stateId}", method = RequestMethod.GET)
	public List<DistrictMaster> getDistricts(@PathVariable("stateId") int state_id) {
		System.out.println(state_id);
		return districtService.getDistricts(state_id);
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/api/barriers/{districtId}", method = RequestMethod.GET)
	public List<BarrierMaster> getBarriers(@PathVariable("districtId") int districtId) {
		System.out.println(districtId);
		return barrierService.getBarriers(districtId);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/vehicletypes", method = RequestMethod.GET)
	public List<VehicleTypeMaster> getVehicleTypes() {
		return vehicleTypeService.getVehicleTypes();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/vehicleusertypes", method = RequestMethod.GET)
	public List<VehicleUserType> getVehicleUserTypes() {
		return vehicleUserTypeService.getVehicleUserTypes();
	}

}
