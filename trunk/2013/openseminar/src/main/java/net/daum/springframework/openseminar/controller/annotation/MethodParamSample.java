package net.daum.springframework.openseminar.controller.annotation;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.daum.springframework.openseminar.HelloModel;
import net.daum.springframework.openseminar.HelloPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/param")
@Controller
public class MethodParamSample {

	@Autowired
	private HelloPrinter helloPrinter;

	@RequestMapping("/hello1")
	public HelloModel hello1( HttpSession session
			, HttpServletRequest req, HttpServletResponse res 
			, Locale locale 
//			, InputStream is, OutputStream os
//			, Reader reader,  Writer writer
		) {
		System.out.println("HttpServletRequest : " + req.getRemoteAddr());
		System.out.println("HttpServletResponse : " + res.getCharacterEncoding());
		System.out.println("HttpSession : " + session.getAttribute("hello"));
		session.setAttribute("hello", "hello world");
		System.out.println("Locale : " + locale.getCountry());
//		System.out.println("InputStream : " + is);
//		System.out.println("Reader : " + reader);
//		System.out.println("OutputStream : " + os);
//		System.out.println("Writer : " + writer);
		
		
		return helloPrinter.getModel();
	}
	
	@RequestMapping("/hello/{id}/{name}")
	public HelloModel hello2( @PathVariable("name") String name, @PathVariable("id") int id
			, @RequestParam("param") String param, @RequestParam(value="param2", required=false, defaultValue="1") String param2
			, @CookieValue("TIARA") String tiara,@RequestHeader("Host") String host 
		) {
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		System.out.println("param : " + param);
		System.out.println("param2 : " + param2);
		System.out.println("tiara : " + tiara);
		System.out.println("Host : " + host);
		return helloPrinter.getModel();
	}
	
	@RequestMapping("/map")
	public void hello3(Map map) {
		map.put("helloModel", helloPrinter.getModel("map"));
	}
	
	@RequestMapping("/model")
	public void hello4(Model model) {
		model.addAttribute(helloPrinter.getModel("model"));
	}	
	
	@RequestMapping("/modelMap")
	public void hello5(ModelMap modelMap) {
		modelMap.addAttribute(helloPrinter.getModel("modelMap"));
	}	
	
	@RequestMapping("/modelAttribute")
	public void hello6(@ModelAttribute HelloModel helloModel) {
		System.out.println("Name : " + helloModel.getName());
		HelloModel printerModel = helloPrinter.getModel();
		helloModel.setHello(printerModel.getHello());
		helloModel.setName(printerModel.getName());
	}
	
	
	@RequestMapping("/failParam")
	public HelloModel hello7(@RequestParam int id) {
		return helloPrinter.getModel();
	}
	
	@RequestMapping("/failModelAttribute")
	public void hello8(Model model, @ModelAttribute HelloModel helloModel, BindingResult bindingResult) {
		List<FieldError> errors = bindingResult.getFieldErrors();
		for(FieldError error : errors) {
			System.out.println(error.getField() + " field error : " + error.getRejectedValue());
			model.addAttribute(error);
		}
	}
	
}
