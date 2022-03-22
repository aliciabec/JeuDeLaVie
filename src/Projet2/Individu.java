package Projet2;

public class Individu {

    int contamine;
    int vaccinne;

    public Individu(){
        this.contamine= 0;
        this.vaccinne=0;

    }

    public int getContamine(){
        return this.contamine;
    }

    public int getVaccinne() {
        return vaccinne;
    }

    public void setContamine(int contamine) {
        this.contamine = contamine;
    }

    public void setVaccinne(int vaccinne) {
        this.vaccinne = vaccinne;
    }
}
