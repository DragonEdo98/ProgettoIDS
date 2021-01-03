export class ModelloA {

    codiceId?: number;
    tipoEvento: string;
    luogoEvento: string;
    orarioArrivoEvento?: string;
    dataArrivoEvento?: string;
    note?: string;
    firmaResponsabileOrg: string;

    constructor(codiceId: number, tipoEvento: string, luogoEvento: string, orarioArrivoEvento: string, dataArrivoEvento: string, note: string, firmaResponsabileOrg: string) {
        this.codiceId = codiceId;
        this.tipoEvento = tipoEvento;
        this.luogoEvento = luogoEvento;
        this.orarioArrivoEvento = orarioArrivoEvento;
        this.dataArrivoEvento = dataArrivoEvento;
        this.note = note;
        this.firmaResponsabileOrg = firmaResponsabileOrg;
    }

}