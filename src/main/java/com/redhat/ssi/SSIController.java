package com.redhat.ssi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.oracle.ssi.kafka.producer.Sender;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/ssi", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "ssi", description = "Operations pertaining to add,delete,update,search for ssi")
@RestController
public class SSIController {

	@Autowired
	SSIRepository ssiRepository;
/*	@Autowired
	Sender sender;
	
	@Value("${spring.kafka.topic.ssiCreated}")
    String SSI_CREATED_TOPIC;
	
	@Value("${spring.kafka.topic.ssiDeleted}")
    String SSI_DELETED_TOPIC;*/

	@ApiOperation(value = "Allows you to add SSI", response = SSI.class)
	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public boolean addSSI(@RequestBody SSI ssi) {

		try {
			ssiRepository.save(ssi);
			//sender.send(SSI_CREATED_TOPIC, ssi);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	@ApiOperation(value = "Update already created SSI", response = SSI.class)
	@RequestMapping(method = RequestMethod.POST, path = "/update")
	public boolean updateSSI(@RequestBody SSI ssi) {

		try {
			ssiRepository.save(ssi);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@ApiOperation(value = "Delete an existing SSI")
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void deleteSSI(@PathVariable("id") String id) {
		SSI ssi = ssiRepository.findOneById(id);
		ssiRepository.delete(ssi);
		//sender.send(SSI_DELETED_TOPIC, ssi);
	}

	@ApiOperation(value = "Find all SSI", response = SSI.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(method = RequestMethod.GET, path = "/findAll")
	public List<SSI> findAll() {
		List<SSI> ssi = ssiRepository.findAll();

		return ssi;
	}

	@ApiOperation(value = "Find SSI by name", response = SSI.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(method = RequestMethod.POST, path = "/findBySsiName")
	public List<SSI> findBySsiName(@RequestBody SSI ssi) {
		List<SSI> result = null;

		if (ssi.getSsiName() != null && !ssi.getSsiName().trim().equals("")) {
			result = ssiRepository.findBySsiName(ssi.getSsiName());
		} else {
			result = ssiRepository.findAll();
		}
		System.out.println("ssiName: " + ssi.getSsiName());
		return result;
	}


}
