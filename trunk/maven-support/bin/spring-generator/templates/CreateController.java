package ${packageName};

import javasupport.spring.webmvc.validation.FieldValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.SimpleFormController;

/** Create Form Controller for ${className}. */
public class CreateController extends SimpleFormController {
	private ${className}Dao ${beanName}Dao;

	public void set${className}Dao(${className}Dao that) {
		this.${beanName}Dao = that;
	}

	public CreateController() {
		setCommandClass(${className}.class);
		setCommandName("${beanName}");

		setSuccessView("${classNamePath}/create");
		setFormView("${classNamePath}/create");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		${className} ${beanName} = (${className}) command;
		logger.info("Saving new command object " + ${beanName});
		${beanName}Dao.save(${beanName});

		ModelAndView mv = new ModelAndView(getSuccessView());
		mv.addObject("message", "Record created. New ID=" + ${beanName}.getId());
		return mv;
	}

	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
		${className} ${beanName} = (${className}) command;

		// Validate command object.
		FieldValidator validator = new FieldValidator(${beanName}, errors);
		
		//required fields
		<% for (field in displayFields) { %>
		validator.notBlank("${field[0]}", "This field can not be blank.");
		<% } %>
		
		//exit if there are errors
		if(validator.hasErrors())
			return;
		
		//length validations
		<% for (field in displayFields) { 
			def maxLen = 255 // default String length
			def type = field[1].toLowerCase()
			if(type == "integer" || type == "int") maxLen = 9
			else if(type == "double") maxLen = 12
		%>
		validator.length("${field[0]}", 1, ${maxLen}, "Input must between %d to %d characters.");
		<% } %>		
		
		//exit if there are errors
		if(validator.hasErrors())
			return;
		
		//value validations
		<% for (field in displayFields) { 
			def type = field[1].toLowerCase()
			if(type == "integer" || type == "int"){
		%>
		validator.match("${field[0]}", "\\\\d+", "Invalid integer value.");
	  <%
			}else if(type == "double"){
		%>
		validator.match("${field[0]}", "\\\\d{1,9}(\\\\.\\\\d{1,2}){0,1}", "Invalid decimal value. Try #.## format.");
	  <%
			}else{
		%>
		validator.match("${field[0]}", "\\\\p{ASCII}", "Invalid ascii characters value.");
		<% 
			}
		} //for loop
		%>
	}
}

