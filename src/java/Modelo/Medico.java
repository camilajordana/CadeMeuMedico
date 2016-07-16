package Modelo;

public class Medico {

    private int idMedico;
    private String crm;
    private String nome;
    private String Endereco;
    private String bairro;
    private String email;
    private boolean atendePorConvenio;
    private boolean temClinica;
    private String site;
    private int cidade;
    private int especialidade;

    public Medico() {
    }

    public Medico(int idMedico, String crm, String nome, String Endereco, String bairro, String email, boolean atendePorConvenio, boolean temClinica, String site, int cidade, int especialidade) {
        this.idMedico = idMedico;
        this.crm = crm;
        this.nome = nome;
        this.Endereco = Endereco;
        this.bairro = bairro;
        this.email = email;
        this.atendePorConvenio = atendePorConvenio;
        this.temClinica = temClinica;
        this.site = site;
        this.cidade = cidade;
        this.especialidade = especialidade;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtendePorConvenio() {
        return atendePorConvenio;
    }

    public void setAtendePorConvenio(boolean atendePorConvenio) {
        this.atendePorConvenio = atendePorConvenio;
    }

    public boolean isTemClinica() {
        return temClinica;
    }

    public void setTemClinica(boolean temClinica) {
        this.temClinica = temClinica;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }
    
    
    
}
