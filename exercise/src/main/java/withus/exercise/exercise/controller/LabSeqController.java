/**
 * LabSeqController
 * 
 * REST Service
 * 
 * @author Rodrigo Santos
*/

package withus.exercise.exercise.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labseq")
public class LabSeqController {

	private Map <Integer, Integer> storage = new HashMap<Integer, Integer>(20000);

	public LabSeqController(){
		storage.put(0, 0);
		storage.put(1, 1);
		storage.put(2, 0);
		storage.put(3, 1);
	}

	/**
	 * GET Mapping labseq
	 * Call for and return the labseq computation for the given value
	 * 
	 * @param value	index value to compute
	 * @return computed result of labseq function
	 */
	@GetMapping("/{value}")
	public String labseq(@PathVariable int value) {
		
		if (value < 0){
			return "ERROR: INVALID NUMBER";
		}

		int result = computeLabSeq(value);
    	return "" + result;
	}

	/**
	 * computeLabSeq
	 * Calculates recursively and returns the labseq function for the given value
	 * 
	 * @param value	index value to compute
	 * @return computed result of labseq function
	 */
	private int computeLabSeq(int value) {
		int result=0;

		if (storage.containsKey(value) && storage.get(value)!= null){
			return storage.get(value);
		}
		else{
			result = computeLabSeq(value - 4) + computeLabSeq(value - 3);
			storage.put(value, result);
		}

		return result;
	}
}
