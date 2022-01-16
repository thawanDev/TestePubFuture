package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import utils.Conexao;

public class Receitas {

    public Receitas() {
    }
    private String idReceitas;
    private String valor;
    private Date dataRecebimento;
    private Date dataRecebimentoEsperado;
    private String descricao;
    private String tipoReceitas;

    @Override
    public String toString() {
        return "Receitas{" + "idReceitas=" + idReceitas + ", valor=" + valor + ", dataRecebimento=" + dataRecebimento + ", dataRecebimentoEsperado=" + dataRecebimentoEsperado + ", descricao=" + descricao + ", tipoReceita=" + tipoReceitas + '}';
    }

        public boolean CadastrarReceitas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String  sql = "insert into receitas ";
                sql += "(idReceitas, valor, dataRecebimento, dataRecebimentoEsperado, descricao, tipoReceita) ";
                sql += "values (?,?,?,?,?,?)";
                
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.idReceitas);
                stm.setString(2, this.valor);
                stm.setDate  (3, (java.sql.Date) this.dataRecebimento);
                stm.setDate  (4, (java.sql.Date) this. dataRecebimentoEsperado);
                stm.setString(5, this.descricao);
                stm.setString(6, this.tipoReceitas);
                stm.execute();   
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex.getMessage());
                return false;
            }            
            return true; 
    }

        public boolean EditarReceitas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String sql  = "update receitas "; 
                   sql += "set valor                    = ?, ";
                   sql += "    dataRecebimento          = ?, ";
                   sql += "    dataRecebimentoEsperado  = ?, ";
                   sql += "    descricao                = ?, ";
                   sql += "    tipoReceitas                = ?, ";
                   sql += "where idreceitas             = ?";
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.valor);
                stm.setDate  (2, (java.sql.Date) this.dataRecebimento);
                stm.setDate  (3, (java.sql.Date) this.dataRecebimentoEsperado);
                stm.setString(4, this.descricao);
                stm.setString(5, this.tipoReceitas);
                stm.execute();   
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex.getMessage());
                return false; 
            }
            return true;        
    }

        public boolean RemoverReceita() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String sql  = "delete from receitas";
               sql += "where idreceitas = ? ";
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
              try {
                PreparedStatement stm = con.prepareStatement(sql);
                 stm.execute();   
            } catch (SQLException ex) {
                 System.out.println("Erro:" + ex.getMessage());
                 return false; 
            }
            return true;        
    }

        public Receitas ConsultarReceitas(String rIdReceitas) {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String  sql  = "select idReceitas, valor, dataRecebimento, dataRecebimentoEsperada, descricao, tipoReceitas ";
                sql += "from receitas ";
                sql += "where idReceitas = ?";
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
        Receitas receita = new Receitas();
        try {
            PreparedStatement stm = con.prepareStatement(sql);  
            stm.setString(1, rIdReceitas);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
               receita = new Receitas();
               receita.setIdReceitas(rs.getString("idReceitas"));
               receita.setValor(rs.getString("valor"));
               receita.setDataRecebimento(rs.getDate("dataRecebimento"));
               receita.setDataRecebimentoEsperado(rs.getDate("dataRecebimentoEsperado"));
               receita.setDescricao(rs.getString("descricao"));
               receita.setTipoReceita(rs.getString("receita"));
            } 
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex.getMessage());
        }
        return receita;       
    }
        
/*------------------------------------------------------------------------
                    ÁREA DE GETTERS E SETTERS
--------------------------------------------------------------------------*/
        
    public String getIdReceitas() {
        return idReceitas;
    }

    public void setIdReceitas(String idReceitas) {
        this.idReceitas = idReceitas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoReceita() {
        return tipoReceitas;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceitas = tipoReceita;
    }

}