package com.dit.himachal.apicontroller;

import com.dit.himachal.entities.BarrierMaster;
import com.dit.himachal.entities.DistrictMaster;
import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.entities.VehicleOwnerEntries;
import com.dit.himachal.entities.VehicleTypeMaster;
import com.dit.himachal.entities.VehicleUserType;
import com.dit.himachal.services.BarrierService;
import com.dit.himachal.services.DistrictService;
import com.dit.himachal.services.StatesService;
import com.dit.himachal.services.VehicleTypeService;
import com.dit.himachal.services.VehicleUserTypeService;
import com.dit.himachal.utilities.Constants;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		byte [] content = file.getBytes();

		File convertFile = new File("/Users/kush/Desktop/testImages/" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();

        VehicleOwnerEntries vehicleUSerEntries = objectMapper.readValue(jsondata, VehicleOwnerEntries.class);
//        System.out.println(userData.getFirstname());
//        System.out.println(userData.getLastname());

		return new ResponseEntity<>(vehicleUSerEntries.toString()+file.getSize()+"==="+file.getOriginalFilename()+ content.toString(), HttpStatus.OK);

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/states", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getStates() {
		Map<String,Object> map = null;
		try{
			List<StatesMaster> states = statesService.getStates();
			if(!states.isEmpty()) {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,states);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}else {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,states);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}
		}catch(Exception ex) {
			 map = new HashMap<String, Object>();
			 map.put(Constants.keyResponse,"");
			 map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
			 map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR);
			 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}

	/**
	 * 
	 * @return   
	 */
	@RequestMapping(value = "/api/districts/{stateId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getDistricts(@PathVariable("stateId") int state_id) {
		Map<String,Object> map = null;
		try{
			List<DistrictMaster> districts = districtService.getDistricts(state_id);
			if(!districts.isEmpty()) {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,districts);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}else {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,districts);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}
		}catch(Exception ex) {
			 map = new HashMap<String, Object>();
			 map.put(Constants.keyResponse,"");
			 map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
			 map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR);
			 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/api/barriers/{districtId}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getBarriers(@PathVariable("districtId") int districtId) {
		System.out.println(districtId);
		Map<String,Object> map = null;
		try{
			List<BarrierMaster> barriers = barrierService.getBarriers(districtId);
			if(!barriers.isEmpty()) {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,barriers);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}else {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,barriers);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}
		}catch(Exception ex) {
			 map = new HashMap<String, Object>();
			 map.put(Constants.keyResponse,"");
			 map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
			 map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR);
			 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/vehicletypes", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getVehicleTypes() {
		
		Map<String,Object> map = null;
		try{
			List<VehicleTypeMaster> vehicleType = vehicleTypeService.getVehicleTypes();
			if(!vehicleType.isEmpty()) {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,vehicleType);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}else {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,vehicleType);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}
		}catch(Exception ex) {
			 map = new HashMap<String, Object>();
			 map.put(Constants.keyResponse,"");
			 map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
			 map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR);
			 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/vehicleusertypes", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getVehicleUserTypes() {
		 
		Map<String,Object> map = null;
		try{
			List<VehicleUserType> vehicleUserType = vehicleUserTypeService.getVehicleUserTypes();
			if(!vehicleUserType.isEmpty()) {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,vehicleUserType);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}else {
				  map = new HashMap<String, Object>();
				  map.put(Constants.keyResponse,vehicleUserType);
				  map.put(Constants.keyMessage, Constants.valueMessage);
				  map.put(Constants.keyStatus, HttpStatus.OK);
				  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			}
		}catch(Exception ex) {
			 map = new HashMap<String, Object>();
			 map.put(Constants.keyResponse,"");
			 map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
			 map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR);
			 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}

}
