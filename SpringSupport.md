# SpringMVC Support #

## Project Startup and Configuration ##

For project setup and configuration, there few class that I found myself keep rewriting for each project, so I made them reusable.

`LogbackJoranConfigurer`
I started using SL4J and Logback instead of log4j, so this class allow me to specify a configuration on a specific folder.

`SystemInfoController`
Many application needs to provide some health information on it's application and system environment. So this controller just do that.

`WebappStartupConfigurer`
When webapp starts, this class will setup version string and etc once and load them into servletContext space.

## Form Validations ##

I am in favor of programmer controller and coding validation rather than configurable xml validation. What I found is that at the end, there is always some custom validation that drive your configurable version mad. We are programmer, why not just code it. Much moree simplier.

The SpringMVC and Validation framework works great! but still quit a bit of redundant code to write a class for each Command bean validation. So provided a package with very simple usage but get the job done.

Here is a partial implementation of a typeical SimpleFormController exmaples:
```
    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
        User user = (User) command;
        
        new FieldValidator(user, errors).
                notBlank("username", "This field can not be blank.").
                notBlank("password", "This field can not be blank.").
                skipIfHasError().
                function("username", new ExistingUserFunction()).
                length("username", 3, 64, "Input must between %d to %d characters.").
                length("password", 3, 64, "Input must between %d to %d characters.").
                skipIfBlank("email").
                function("email", new EmailValidatorFunction("Invalid email format."));
    }
    
    private class ExistingUserFunction implements ValidatorFunction {  
        public void apply(String fieldName, Object fieldValue, Errors errors) {
            String username = (String)fieldValue;
            if(userDao.exists(username)){
                errors.rejectValue(fieldName, "invalid.username", "Username already exists.");
            }
        }
    }
```

Above code will validate a registration form with username and password as required field. An option email field. It also check in db for duplicated user validation.

A complete example can be viewed when you generate a maven springwebapp-hibernate archetype. See MavenSupport page.