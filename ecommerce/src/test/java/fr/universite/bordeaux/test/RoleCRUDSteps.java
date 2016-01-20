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

public class RoleCRUDSteps {
	
	private CloseableHttpClient client;
	private HttpPost httpPost;
	private CloseableHttpResponse response;
	
	private final String url="http://localhost:8080/ecommerce/api/roles";
	
	@Given("a role with nom $nom description $description")
	public void givenAPersonne(String nom,String description) throws UnsupportedEncodingException{
		client = HttpClients.createDefault();
		httpPost = new HttpPost(url);
		String role="{\"nom\":\""+nom+"\",\"description\":\""+description+"\"}";		
	    StringEntity entity = new StringEntity(role);
	    httpPost.setEntity(entity);
	    httpPost.setHeader("Content-type", "application/json");
	}
	
	@When("I add role")
	public void addUser() throws ClientProtocolException, IOException{
		response = client.execute(httpPost);
	}
	
	@Then("a role with id $id should be added into the database")
	public void checkIfUserAdded(String id) throws IOException{
		assertThat(response.getStatusLine().getStatusCode()).isEqualTo(204);
		HttpGet httpGet = new HttpGet(url+"/"+id);
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
		
		HttpDelete httpDelete = new HttpDelete(url+"/"+id);
		client.execute(httpDelete);
		client.close();
	}

}
