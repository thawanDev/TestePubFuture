package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import utils.Conexao;

public class Contas {
    
    private String idcontas;   
    private String nome;
    private String sobrenome;
    private String saldo;  
    private String tipoConta;
    private String instituicaoFinanceira;

    @Override
    public String toString() {
        return "Contas{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", idcontas=" + idcontas + ", saldo=" + saldo + ", tipoConta=" + tipoConta + ", instituicaoFinanceira=" + instituicaoFinanceira + '}';
    }

    public boolean CadastrarContas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String  sql = "insert into contas ";
                sql += "(idcontas, nome, sobrenome, saldo, tipoConta, instituicaoFinanceira) ";
                sql += "values (?,?,?)";
                
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.idcontas);
                stm.setString(3, this.nome);
                stm.setString(3, this.sobrenome);                
                stm.setString(4, this.saldo);
                stm.setString(5, this.tipoConta);
                stm.setString(6, this.instituicaoFinanceira);
                stm.execute();   
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex.getMessage());
                return false;
            }            
            return true;   
}

    public boolean EditarContas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String sql  = "update contas "; 
                   sql += "set nome                  = ?, ";
                   sql += "    sobrenome              = ?, ";
                   sql += "    tipoConta              = ?, ";
                   sql += "    instituicaoFinanceira  = ?, ";
                   sql += "where idcontas             = ?";
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.nome);
                stm.setString(2, this.sobrenome);
                stm.setString(3, this.tipoConta);
                stm.setString(4, this.instituicaoFinanceira);
                stm.execute();   
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex.getMessage());
                return false; 
            }
            return true;	
}

    public boolean RemoverContas() {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String sql  = "delete from contas";
               sql += "where idcontas = ? ";
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

    public Contas ConsultarContas(String cIdContas) {
        // DECLARANDO COMANDO DE EXECUÇÃO DO BANCO DE DADOS
        String  sql  = "select idcontas, nome, sobrenome, saldo, tipoConta, instituicaoFinanceira ";
                sql += "from contas ";
                sql += "where idcontas = ?";
        // CONECTANDO COM O BANCO DE DADOS
        Connection con = Conexao.conectar();
        Contas conta = new Contas();
        try {
            PreparedStatement stm = con.prepareStatement(sql);  
            stm.setString(1, cIdContas);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
               conta = new Contas();
               conta.setIdcontas(rs.getString("idConta"));
               conta.setNome(rs.getString("nome"));
               conta.setSobrenome(rs.getString("sobrenome"));               
               conta.setSaldo(rs.getString("saldo"));
               conta.setTipoConta(rs.getString("tipoConta"));
               conta.setInstituicaoFinanceira(rs.getString("instituicaoFinanceira"));
        } 
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex.getMessage());
        }
        return conta;
    }
    
    public List<Contas> consultarContasGeral() {
        List<Contas> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql  = "select idcontas, nome, sobrenome, saldo, tipoConta, instituicaoFinanceira ";
               sql += " from contas";
               sql += " order by idcontas";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Contas listacon = new Contas();
                listacon.setIdcontas(rs.getString("idcontas"));
                listacon.setNome(rs.getString("nome"));
                listacon.setSobrenome(rs.getString("sobrenome"));
                listacon.setSaldo(rs.getString("saldo"));
                listacon.setTipoConta(rs.getString("tipoConta"));
                listacon.setInstituicaoFinanceira(rs.getString("instituicaoFinanceira"));
                lista.add(listacon);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return lista;
    }

    public void TransferirSaldoParte() {
       
    }

    public void TransferirSaldoTotal() {
        
    }
/*------------------------------------------------------------------------
                    ÁREA DE GETTERS E SETTERS
--------------------------------------------------------------------------*/

//ID CONTAS    
    public String getIdcontas() {
        return idcontas;
    }

    public void setIdcontas(String idcontas) {
        this.idcontas = idcontas;
    }
    
// NOME    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
 
//SOBRENOME    
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }    
    
//SALDO    
    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String Saldo) {
        this.saldo = Saldo;
    }
  
//TIPO CONTA    
    public String getTipoConta() {
        return tipoConta;
    }
       
    public void setTipoConta(String TipoConta) {
        this.tipoConta = TipoConta;
    }
  
//INSTITUIÇÃO FINANCEIRA     
    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }
       
    public void setInstituicaoFinanceira(String InstituicaoFinanceira) {
        this.instituicaoFinanceira = InstituicaoFinanceira;
    }

}
