package clover.infotech.resource;

import java.util.List;

import clover.infotech.entity.Employee;
import clover.infotech.repo.EmployeeRepository;
import clover.infotech.repo.TollSubcriptionsRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employees")
public class EmployeeResource {
	
	@Inject
	private EmployeeRepository employeeRepo;
	
	@Inject
	private TollSubcriptionsRepo tollSubcriptionsRepo;
	
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    @Transactional
	    public Response registerEmployee(Employee employee) {
	        try {
	        	employeeRepo.persist(employee);
	            return Response.status(Response.Status.CREATED).entity(employee).build();
	        } catch (Exception e) {
	            e.printStackTrace(); // Replace with your logging mechanism
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                           .entity("Error creating employee: " + e.getMessage())
	                           .build();
	        }
	    }
	    
	    
	    //get employee by Id
	    @GET
		@Path("/{empid}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getById(@PathParam("empid") Long empid) {
			Employee employee = employeeRepo.findById(empid);
			return Response.ok(employee).build();

		}
	    
	    
	    
//	    @GET
//	    @Path("/{empId}/subscriptions")
//	    @Produces(MediaType.APPLICATION_JSON)
//	    public Response getSubscriptionsForEmployee(@PathParam("empId") Integer empid) {
//	        try {
//	        	Employee employee = employeeRepo.findAll(empid);
//				return Response.ok(employee).build();
//	        } catch (Exception e) {
//	            // Log the exception or handle it as needed
//	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error fetching subscriptions").build();
//	        }
//	    }
	    
	    
	    //TollSubscription save record 
		/*
		 * @POST
		 * 
		 * @Transactional public Response savTollSubscription(TollSubcriptions
		 * tollSubscription) { try { tollSubcriptionsRepo.persist(tollSubscription);
		 * return
		 * Response.status(Response.Status.CREATED).entity(tollSubscription).build(); }
		 * catch (Exception e) { e.printStackTrace(); // Replace with your logging
		 * mechanism return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
		 * .entity("Error creating toll subscription: " + e.getMessage()) .build(); } }
		 */
	}
	
	


