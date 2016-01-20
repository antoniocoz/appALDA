package fr.universite.bordeaux.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CritereCRUDSteps {
	
	private CloseableHttpClient client;
	private HttpPost httpPost;
	private CloseableHttpResponse response;
	
	public final String url="http://localhost:8080/ecommerce/api/criteres";
	
	@Given("a critere with type $type ville $ville prix_min $prix_min prix_max $prix_max surface_min $surface_min surface_max $surface_max")
	public void givenAPersonne(String type,String ville,String prix_min,String prix_max,String surface_min,String surface_max) throws UnsupportedEncodingException{
		client = HttpClients.createDefault();
		httpPost = new HttpPost(url);
		String role="{\"id\":\"1\",\"nom\":\"administrateur\",\"description\":\"administrateur\"}";
		 
		String personne= "{\"id\":\"2\",\"prenom\":\"Antonio\",\"nom\":\"Coz\",\"adresse\":\"2, rue des tests\","+
			           "\"ville\":\"Test 2\",\"tel\":\"0101010101\",\"mail\":\"a.c@email.com\",\"pass\":\"123456\","+
			           "\role\":\""+role+"\"}";
		
		String critere= "{\"type\":\""+type+"\",\"ville\":\""+ville+"\",\"prix_min\":\""+prix_min+"\","+
		           "\"prix_max\":\""+prix_max+"\",\"surface_min\":\""+surface_min+"\",\"surface_max\":\""+surface_max+"\","+
		           "\"personne\":\""+personne+"\"}";
		
	    StringEntity entity = new StringEntity(critere);
	    httpPost.setEntity(entity);
	    httpPost.setHeader("Content-type", "application/json");
	}
	
	@When("I add critere")
	public void addUser() throws ClientProtocolException, IOException{
		response = client.execute(httpPost);
	}
	
	@Then("a critere with id $id should be added into the database")
	public void checkIfUserAdded(String id) throws IOException{
		assertThat(response.getStatusLine().getStatusCode()).isEqualTo(204);
		HttpGet httpGet = new HttpGet(url+id);
		response = client.execute(httpGet);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
		    result.append(line);
		}

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(result.toString());
		String retrievedEmail = actualObj.get("id").textValue();
		assertThat(retrievedEmail).isEqualTo(id);
		
		HttpDelete httpDelete = new HttpDelete(url+id);
		client.execute(httpDelete);
		client.close();
	}

}
