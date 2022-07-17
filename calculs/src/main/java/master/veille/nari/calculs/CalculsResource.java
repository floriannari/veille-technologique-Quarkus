package master.veille.nari.calculs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestQuery;

import master.veille.nari.calculs.service.CalculsService;

@Path("/calculs")
public class CalculsResource {

	@Inject
	private CalculsService calculsService;
	
    @GET
    @Path("/levenshtein")
    public int levenshtein(@RestQuery String str1, @RestQuery String str2) {
        return calculsService.levenshteinDistance(str1, str2);
    }
}