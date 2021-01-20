package modello;

import javax.validation.constraints.NotNull;

public class Login {

	private @NotNull Long codiceVoloWebLogin;
	private @NotNull String passwordLogin;

	
	
	public Long getCodiceVoloWebLogin() {
		return codiceVoloWebLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}
	
	
	
}
