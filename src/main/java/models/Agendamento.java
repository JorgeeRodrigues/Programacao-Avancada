package models;

public class Agendamento {

    private int id;
    private String cliente;
    private String pet;
    private String servico;
    private String dataehora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getDataehora() {
        return dataehora;
    }

    public void setDataehora(String dataehora) {
        this.dataehora = dataehora;
    }

    @Override
    public String toString() {
        return id + ";" + cliente + ";" + pet + ";" + servico + ";" + dataehora;
    }
}
