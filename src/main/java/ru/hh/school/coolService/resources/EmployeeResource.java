package ru.hh.school.coolService.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.hh.school.coolService.dto.EmployeeCreateDto;
import ru.hh.school.coolService.dto.EmployeeDto;
import ru.hh.school.coolService.dto.ResumeCreateDto;
import ru.hh.school.coolService.dto.ResumeDto;
import ru.hh.school.coolService.services.EmployeeService;

@Path("/")
@Singleton
public class EmployeeResource {
  private final EmployeeService employeeService;

  public EmployeeResource(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GET
  @Produces("application/json")
  @Path("/employee/{id}")
  @ResponseBody
  public Response getEmployee(@PathParam("id") Integer id) {
    return Response.status(Response.Status.OK)
        .entity(new EmployeeDto(employeeService.getEmployeeById(id)))
        .build();
  }

  @POST
  @Produces("application/json")
  @Path("/employee/create")
  @ResponseBody
  public Response createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto){
    return Response.status(Response.Status.OK)
        .entity(new EmployeeDto(employeeService.createEmployee(employeeCreateDto)))
        .build();
  }

  @GET
  @Produces("application/json")
  @Path("/resume/{id}")
  @ResponseBody
  public Response getResume(@PathParam("id") Integer id) {
    return Response.status(Response.Status.OK)
        .entity(new ResumeDto(employeeService.getResumeById(id)))
        .build();
  }

  @POST
  @Produces("application/json")
  @Path("/resume/create")
  @ResponseBody
  public Response createResume(@RequestBody ResumeCreateDto resumeCreateDto){
    return Response.status(Response.Status.OK)
        .entity(new ResumeDto(employeeService.createResume(resumeCreateDto)))
        .build();
  }

}
