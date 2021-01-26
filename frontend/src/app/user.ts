export class User {

    codiceVoloWebLogin: number;
    passwordLogin: string;

    constructor(codiceVoloWebLogin: number, passwordLogin: string) {
        this.codiceVoloWebLogin = codiceVoloWebLogin;
        this.passwordLogin = passwordLogin;
    }
}