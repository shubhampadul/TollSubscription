package clover.infotech.resource;

import java.util.ArrayList;
import java.util.List;

import clover.infotech.entity.Employee;
import clover.infotech.entity.TollSubcriptions;
import clover.infotech.repo.EmployeeRepository;
import clover.infotech.repo.TollSubcriptionsRepo;
import clover.infotech.request.TollRequest;
import clover.infotech.response.EmpResponse;
import clover.infotech.response.SubResponse;
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

@Path("/tollSubscription")
public class TollSubscriptionResource {

	@Inject
	private TollSubcriptionsRepo tollSubcriptionsRepo;
	
	@Inject
	EmployeeRepository empRepo;
	
	// TollSubscription save record

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response savTollSubscription(TollRequest tollRequest) {
		
		try {
			Employee emp=empRepo.findById(tollRequest.getEmpId());
			TollSubcriptions tlsSplEntity=new TollSubcriptions();
			
			  tlsSplEntity.setCreatedBy(tollRequest.getCreatedBy());
			  tlsSplEntity.setCustSupport(tollRequest.getCustSupport());
			 
			  tlsSplEntity.setEmployee(emp);
			
			  tlsSplEntity.setPlanId(tollRequest.getPlanId());
			  tlsSplEntity.setPlainName(tollRequest.getPlainName());
			  tlsSplEntity.setSubscriptionMonths(tollRequest.getSubscriptionMonths());
			  tlsSplEntity.setCustSupport(tollRequest.getCustSupport());
			  tlsSplEntity.setCreatedBy(tollRequest.getCreatedBy());
			  tlsSplEntity.setModifiedBy(tollRequest.getModifiedBy());
			  tlsSplEntity.setCreatedDate(tollRequest.getCreatedDate());
			  tlsSplEntity.setModifiedDate(tollRequest.getModifiedDate());
			 
			tollSubcriptionsRepo.persist(tlsSplEntity);
			return Response.status(Response.Status.CREATED).entity(tollRequest).build();
		} catch (Exception e) {
			e.printStackTrace();
			// Replace with your logging mechanism
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Error creating toll subscription: " + e.getMessage()).build();
		}
	}



         @GET
         @Path("/{id}")
         @Produces(MediaType.APPLICATION_JSON)
          public Response getById(@PathParam("id") Long id) {
	      TollSubcriptions tollSubcriptions = tollSubcriptionsRepo.findById(id);
	      
	      Employee emp=empRepo.findById(id);
	      EmpResponse empRes=new EmpResponse();
	      empRes.setEmpName(emp.getEmpName());
	      empRes.setEmpid(emp.getEmpid());
	      empRes.setContactNo(emp.getContactNo());
	      emp.getTollSubcriptions();
	      
	      List<SubResponse> resSUbList=new  ArrayList<SubResponse>();
	      
	      
	      for(TollSubcriptions res:emp.getTollSubcriptions()) {
	    	SubResponse resSub=new SubResponse();
	    	resSub.setPlanId(res.getPlanId());
	    	resSub.setPlainName(res.getPlainName());
	    	resSub.setSubscriptionMonths(res.getSubscriptionMonths());
	    	resSub.setCustSupport(res.getCustSupport());
	    	resSub.setCreatedBy(res.getCreatedBy());
	    	resSub.setModifiedBy(res.getModifiedBy());
	    	resSub.setCreatedDate(res.getCreatedDate());
	    	resSub.setModifiedDate(res.getModifiedDate());
	    	resSUbList.add(resSub);
	      }
	      empRes.setTollSubcriptions(resSUbList);
	      
	      return Response.ok(empRes).build();

}
}