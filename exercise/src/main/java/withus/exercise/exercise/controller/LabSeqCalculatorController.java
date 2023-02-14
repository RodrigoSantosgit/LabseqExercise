/**
 * LabSeqCalculatorController
 * 
 * Web GUI Invoker
 * 
 * @author Rodrigo Santos
*/

package withus.exercise.exercise.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/calculateLabseq")
public class LabSeqCalculatorController {

    public LabSeqCalculatorController(){}

    @RequestMapping("")
	public String calculateLabseq() {
    	return "index";
	}
    
}
