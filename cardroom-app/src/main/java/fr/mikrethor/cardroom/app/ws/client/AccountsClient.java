package fr.mikrethor.cardroom.app.ws.client;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import fr.mikrethor.cardroom.pojo.Account;

public class AccountsClient {
	private static AccountsClient INSTANCE;

	private String url;

	private Client client;

	private WebResource webResource;

	public static AccountsClient getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new AccountsClient();
		}

		return INSTANCE;
	}

	private AccountsClient() {
		url = "http://localhost:8080/accounts";
	}

	private Client getClient() {
		if (client == null) {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			client = Client.create(clientConfig);
		}

		return client;
	}

	private WebResource getWebResource() {
		if (webResource == null) {
			webResource = this.getClient().resource(url);
		}

		return webResource;
	}

	public List<Account> listAll() {
		ClientResponse response = getWebResource().get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		return response.getEntity(new GenericType<List<Account>>() {
		});
	}

	public boolean delete(Long id) {
		ClientResponse response = getWebResource().queryParam("id", String.valueOf(id)).delete(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String res = response.getEntity(String.class);
		return "true".equals(res);
	}

	public Account save(Account Account) {

		Builder builder = getWebResource().type(MediaType.APPLICATION_JSON);
		builder.accept(MediaType.APPLICATION_JSON);
		Account a = builder.post(Account.class, Account);
		return a;
	}

}
