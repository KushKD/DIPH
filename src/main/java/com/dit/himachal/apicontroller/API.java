package com.dit.himachal.apicontroller;

import com.dit.himachal.entities.BarrierMaster;
import com.dit.himachal.entities.DistrictMaster;
import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.entities.VehicleOwnerDocuments;
import com.dit.himachal.entities.VehicleOwnerEntries;
import com.dit.himachal.entities.VehicleTypeMaster;
import com.dit.himachal.entities.VehicleUserType;
import com.dit.himachal.payload.UploadFileResponse;
import com.dit.himachal.services.BarrierService;
import com.dit.himachal.services.DistrictService;
import com.dit.himachal.services.FileStorageService;
import com.dit.himachal.services.StatesService;
import com.dit.himachal.services.VehicleOwnerDocumentsService;
import com.dit.himachal.services.VehicleOwnerEntriesService;
import com.dit.himachal.services.VehicleTypeService;
import com.dit.himachal.services.VehicleUserTypeService;
import com.dit.himachal.utilities.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.Resource;

@RestController
public class API {
	
	 private static final Logger logger = LoggerFactory.getLogger(API.class);

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
	
	@Autowired
	private VehicleOwnerEntriesService entriesService;
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@Autowired
	private VehicleOwnerDocumentsService vehicleOwnerDocumentsService;
	


	ObjectMapper objectMapper = new ObjectMapper();

	@Transactional
	@RequestMapping(value = "/api/uploadData", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadFile(@RequestParam(required = true, value = "file") MultipartFile file,
			@RequestParam(required = true, value = "jsondata") String jsondata) throws IOException {
		
		VehicleOwnerEntries vehicleUSerEntries = null;
		Map<String,Object> map = null;
		
		if(file!=null && jsondata!=null) {
			 vehicleUSerEntries = objectMapper.readValue(jsondata, VehicleOwnerEntries.class);
			 //Save File
			 String fileName = fileStorageService.storeFile(file);
			 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/downloadFile/")
		                .path(fileName)
		                .toUriString();
			 
			 //Generate ID CARD NUMBER  HP/BARRIERID/Number
			 vehicleUSerEntries.setIdCardNumber("REGD.NO/HP/"+barrierService.getBarrierName(vehicleUSerEntries.getVehicleBarrierId())+"/"+entriesService.getIdCardNumberSequence());
			 vehicleUSerEntries.setVehicleOwnerImageName(fileName);
			 vehicleUSerEntries.setDataEnteredBy(4);
			 vehicleUSerEntries.setMobileInformation("");
			 vehicleUSerEntries.setOtherInformation("");
			 //Save Vehicle Entries 
			 Long ID = entriesService.saveVehicleOwnerEntries(vehicleUSerEntries);
			 System.out.println(ID);
			 int id_ = ID.intValue();
			 VehicleOwnerDocuments vehicleOwnerDocuments = new VehicleOwnerDocuments();
			 vehicleOwnerDocuments.setActive(true);
			 vehicleOwnerDocuments.setUploadedBy(vehicleUSerEntries.getDataEnteredBy());
			 vehicleOwnerDocuments.setVehicleImageOwner(file.getBytes());
			 vehicleOwnerDocuments.setVehicleOwnerId(id_);
			 vehicleOwnerDocuments.setFileType(file.getContentType());
			 String[] fileFrags = file.getOriginalFilename().split("\\.");
			          String extension = fileFrags[fileFrags.length-1];
			 vehicleOwnerDocuments.setFileExtention(extension);
			 vehicleOwnerDocumentsService.saveDocuments(vehicleOwnerDocuments);
			  map = new HashMap<String, Object>();
			  map.put(Constants.keyResponse,new UploadFileResponse(fileName, fileDownloadUri,file.getContentType(), file.getSize(), vehicleUSerEntries));
			  map.put(Constants.keyMessage, Constants.valueMessage);
			  map.put(Constants.keyStatus, HttpStatus.OK);
			  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK); 
			 
			 
			 
		}else {
			 map = new HashMap<String, Object>();
			  map.put(Constants.keyResponse,"Data Missing");
			  map.put(Constants.keyMessage, Constants.valueMessage);
			  map.put(Constants.keyStatus, HttpStatus.OK);
			  return new ResponseEntity<Map<String,Object>>(map, HttpStatus.UNPROCESSABLE_ENTITY); 
		}
	
	}
	
	 @GetMapping("/downloadFile/{fileName:.+}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	            logger.info("Could not determine file type.");
	        }

	        // Fallback to the default content type if type could not be determined
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
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
