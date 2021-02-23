export class volontario {
    codiceVoloWebVol?: number;
    nome: string;
    cognome: string;
    numCell: number;


    constructor(codiceVoloWebVol: number, nome: string, cognome:string, numCell:number) {
        this.codiceVoloWebVol = codiceVoloWebVol;
        this.nome = nome;
        this.cognome = cognome;
        this.numCell = numCell;
        
    }
}