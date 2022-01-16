package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import utils.Conexao;

public class Despesas {
    
    public Despesas() {
    }
    
    private String idDespesas;
    private String valor;
    private Date dataPagamento;
    private Date dataPagamentoEsperado;
    private String tipoDespesas;
    private String conta;

    @Override
    public String toString() {
        return "Despesas{" + "idDespesas=" + idDespesas + ", valor=" + valor + ", dataPagamento=" + dataPagamento + ", dataPagamentoEsperado=" + dataPagamentoEsperado + ", tipoDespesas=" + tipoDespesas + ", conta=" + conta + '}';
    }

    public boolean CadastrarDespesas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String  sql = "insert into despesas ";
                sql += "(idDespesas, valor, dataPagamento, dataPagamentoEsperado, tipoDespesas, conta) ";
                sql += "values (?,?,?,?,?,?)";
                
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.idDespesas);
                stm.setString(2, this.valor);
                stm.setDate  (3, (java.sql.Date) this.dataPagamento);
                stm.setDate  (4, (java.sql.Date) this. dataPagamentoEsperado);
                stm.setString(5, this.tipoDespesas);
                stm.setString(6, this.conta);
                stm.execute();   
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex.getMessage());
                return false;
            }            
            return true;         
    }

    public boolean EditarDespesas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String sql  = "update despesas                     "; 
                   sql += "set valor                  = ?, ";
                   sql += "    dataPagamento          = ?, ";
                   sql += "    dataPagamentoEsperado  = ?, ";
                   sql += "    tipoDepesas            = ?, ";
                   sql += "    conta                  = ?, ";
                   sql += "where iddespesas           = ?";
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.valor);
                stm.setDate  (2, (java.sql.Date) this.dataPagamento);
                stm.setDate  (3, (java.sql.Date) this.dataPagamentoEsperado);
                stm.setString(4, this.tipoDespesas);
                stm.setString(5, this.conta);
                stm.execute();   
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex.getMessage());
                return false; 
            }
            return true;        
    }

    public boolean RemoverDespesas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String sql  = "delete from despesas";
               sql += "where idDespesas = ? ";
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

    public Despesas ConsultarDespesas(String dIdDespesas) {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String  sql  = "select idDespesas, valor, dataPagamento, dataPagamentoEsperado, tipoDespesas, conta ";
                sql += "from despesas ";
                sql += "where idDespesas = ?";
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
        Despesas despesa = new Despesas();
        try {
            PreparedStatement stm = con.prepareStatement(sql);  
            stm.setString(1, dIdDespesas);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
               despesa = new Despesas();
               despesa.setIdDespesas(rs.getString("idDespesas"));
               despesa.setValor(rs.getString("valor"));
               despesa.setDataPagamento(rs.getDate("dataPagamento"));
               despesa.setDataPagamentoEsperado(rs.getDate("dataRecebimentoEsperado"));
               despesa.setTipoDespesas(rs.getString("tipoDespesas"));
               despesa.setConta(rs.getString("conta"));
            } 
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex.getMessage());
        }
        return despesa;       
    }

/*------------------------------------------------------------------------
                    ÁREA DE GETTERS E SETTERS
--------------------------------------------------------------------------*/
    
    public String getIdDespesas() {
        return idDespesas;
    }

    public void setIdDespesas(String idDespesas) {
        this.idDespesas = idDespesas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public String getTipoDespesas() {
        return tipoDespesas;
    }

    public void setTipoDespesas(String tipoDespesas) {
        this.tipoDespesas = tipoDespesas;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}