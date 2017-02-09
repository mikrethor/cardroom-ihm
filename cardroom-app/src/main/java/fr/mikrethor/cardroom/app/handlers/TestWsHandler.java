package fr.mikrethor.cardroom.app.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import fr.mikrethor.cardroom.app.ws.client.AccountsClient;
import fr.mikrethor.cardroom.enums.Domain;
import fr.mikrethor.cardroom.pojo.Account;
import fr.mikrethor.cardroom.pojo.Cardroom;
import fr.mikrethor.cardroom.pojo.Player;

public class TestWsHandler {
	@Execute
	public void execute(IWorkbench workbench, Shell shell) {
		String result = "failed";

		try {

			Cardroom pokerstars = new Cardroom("Pokerstars", Domain.COM);

			Player aP = new Player(pokerstars, "testnamePlayerPS");

			Account acP = new Account(aP, pokerstars, "test path");

			// Test get list
			for (Account a : AccountsClient.getInstance().listAll()) {
				result = result + a;
				System.out.println(a.getPlayer().getName());
			}

			// Test delete
			System.out.println("delete : " + AccountsClient.getInstance().delete(1l));

			// Test post
			System.out.println("save : " + AccountsClient.getInstance().save(acP).getId());
			result = "ok";

		} catch (Exception e) {

			e.printStackTrace();

		}

		MessageDialog.openInformation(shell, "Test", result);
	}

}
