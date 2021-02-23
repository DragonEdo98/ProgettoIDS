export class OrganizzazioneVol {
    
    nomeOrg: string;
    codiceVoloWeb: number;
    passwordVoloWeb: string;
    IdcoordinatoreOrg: number;
    nomeCoordinatore: string;
    cognomeCoordinatore: string;

    constructor(nomeOrg: string, codiceVoloWeb: number, passwordVoloWeb: string, IdcoordinatoreOrg: number, nomeCoordinatore: string, cognomeCoordinatore: string) {
        this.nomeOrg = nomeOrg;
        this.codiceVoloWeb = codiceVoloWeb;
        this.passwordVoloWeb = passwordVoloWeb;
        this.IdcoordinatoreOrg = IdcoordinatoreOrg;
        this.nomeCoordinatore = nomeCoordinatore;
        this.cognomeCoordinatore = cognomeCoordinatore;
    }

}