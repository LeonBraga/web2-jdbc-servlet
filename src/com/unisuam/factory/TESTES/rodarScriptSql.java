/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisuam.factory.TESTES;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author AHP
 */
public class rodarScriptSql {

  public static  String createDB = ("create database if not exists meubanco;\n"
            + "use meubanco;\n"
            + "CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (\n"
            		+  "`idusuario` INT NOT NULL AUTO_INCREMENT,\n"
            		  +"`nome` VARCHAR(45) NOT NULL,\n"
            		  +"`sobrenome` VARCHAR(45) NOT NULL,\n"
            		  +"`login` VARCHAR(45) NOT NULL,\n"
            		  +" `senha` VARCHAR(45) NOT NULL,\n"
            		  +"`dataNascimento` DATETIME NOT NULL,\n"
            		  +"`endereco` VARCHAR(45) NOT NULL,\n"
            		  +"PRIMARY KEY (`idusuario`))");

    
// public class SQLite {
    private static Connection connection;
    private Statement statement;
    private ResultSet resultset;
    public rodarScriptSql() {
        openDatabase();
    }
    public static Connection getConnection() {
        return connection;
    }
    public ResultSet getResultset() {
        return resultset;
    }
    public Statement getStatement() {
        return statement;
    }
    public static Statement createStatement() {
        try {
            Statement stmt = connection.createStatement();
            return stmt;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    private void openDatabase() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/meubanco";//criar o arquivo na pasta de projeto chamado : meusdados.db
        String user = "root";
        String pass = "root";
        System.out.println("Conectando ao Banco de Dados...");
        //JOptionPane.showMessageDialog(null, "Conectando ao Banco de Dados");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexão OK");
            statement = connection.createStatement();
            checkEstruturadeTabelas();
        } catch (ClassNotFoundException e) {
            System.out.println("Falha de conexão faltando drivers.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Falha de conexão ou na checagem das estruturas das Tabelas!");
            JOptionPane.showMessageDialog(null, e);
            System.exit(1);
        }
    }
    private void checkEstruturadeTabelas() {
        try {
            this.resultset = this.statement.executeQuery("select * from usuario;");// checar se tem tabelas e criar tableas automaticamente ou importar de um script.sql talves...
            System.out.println("Estruturas das Tabelas OK");
        } catch (SQLException e) {
            System.out.println("Banco de Dados sem estruturas de tabelas...");
            System.out.println("Iniciando Assitente para configuração do Banco de Dados...");
            openAssitenteDialog();//chamar por exemplo interação com usuario para executar script sql manualmente !
            System.out.println("Aguardando interação com usuário...");
            //e.printStackTrace();
        }
    }
    //JDInstall dialog;
    private void openAssitenteDialog() {
        //dialog = new JDInstall(null, true);
        //dialog.setVisible(true);
    }
    /*private void openAssitenteDialogThread() {
     java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
     dialog = new JDInstall(null, true);
     dialog.addWindowListener(new java.awt.event.WindowAdapter() {
     @Override
     public void windowClosing(java.awt.event.WindowEvent e) {
     //System.exit(0);
     }
     });
     dialog.setVisible(true);
     }
     });
     }*/
    public static boolean executeScript(String script) {
        System.out.println(script);
        try {
            createStatement().executeUpdate(script);
            //this.connection.commit();
            System.out.println("Criação de Estruturas das Tabelas OK");
            return true;
        } catch (SQLException e) {
            /*try {
             //this.connection.rollback();
             System.out.println("Erro ao executar script...");
             System.out.println("Erro: " + e);
             } catch (SQLException ex) {
             System.out.println("Erro em rollback: " + ex);
             }*/
            JOptionPane.showMessageDialog(null, "ERRO:" + e.getErrorCode() + "\n" + e, "ERRO DE EXECUÇÃO", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        executeScript(createDB);
    }

    
    
    
    
}
