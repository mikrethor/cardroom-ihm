package fr.mikrethor.cardroom.app.handlers;

import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import fr.mikrethor.cardroom.pojo.Account;

public class TestWsHandler {
	@Execute
	public void execute(IWorkbench workbench, Shell shell) {
		String result = "failed";

		try {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/accounts");
			ClientResponse response = webResource.get(ClientResponse.class);

			// WebResource webResource =
			// client.resource("http://localhost:8080/hand");
			// ClientResponse response = webResource.get(ClientResponse.class);
			// if (response.getStatus() != 200) {
			// throw new RuntimeException("Failed : HTTP error code : " +
			// response.getStatus());
			// }
			//
			// Hand output = response.getEntity(Hand.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			List<Account> output = response.getEntity(new GenericType<List<Account>>() {
			});
			result = "";
			for (Account a : output) {
				result = result + a;
				System.out.println(a.getPlayer().getName());
			}
			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

		MessageDialog.openInformation(shell, "Test", result);
	}
}
