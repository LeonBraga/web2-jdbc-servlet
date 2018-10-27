package br.com.unisuam.TESTE;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TESTE {

	public static void main(String[] args) {
		String createDB = ("create database if not exists dbiWeb2;\n" + "use dbiWeb2;\n"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (\r\n" + "  `idusuario` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `nome` VARCHAR(45) NOT NULL,\r\n" + "  `sobrenome` VARCHAR(45) NOT NULL,\r\n"
				+ "  `endereco` VARCHAR(45) NOT NULL,\r\n" + "  `senha` VARCHAR(45) NOT NULL,\r\n"
				+ "  `login` VARCHAR(45) NOT NULL,\r\n" + "  `dataNascimento` VARCHAR(45) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`idusuario`))\r\n" + "ENGINE = InnoDB;\r\n" + "\r\n"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`CartaoCredito` (\r\n" + "  `numeroCartao` INT NOT NULL,\r\n"
				+ "  `dataVencimento` VARCHAR(45) NOT NULL,\r\n" + "  `usuario_idusuario` INT NOT NULL,\r\n"
				+ "  PRIMARY KEY (`numeroCartao`),\r\n"
				+ "  INDEX `fk_CartaoCredito_usuario_idx` (`usuario_idusuario` ASC),\r\n"
				+ "  CONSTRAINT `fk_CartaoCredito_usuario`\r\n" + "    FOREIGN KEY (`usuario_idusuario`)\r\n"
				+ "    REFERENCES `mydb`.`usuario` (`idusuario`)\r\n" + "    ON DELETE NO ACTION\r\n"
				+ "    ON UPDATE NO ACTION)\r\n" + "ENGINE = InnoDB;");

		String insertDB = ("insert into usuario(idusuario, nome, sobrenome, endereco, login, senha, datanascimento, isadm )\n"
				+ "values(1,'Anderson' , 'Canel','Rua Severiano das Chagas', 'adm', 'adm', '15/04/1988', true);");

		// muda aqui para o seu server.
		final String HOST = "localhost:3306/";
		final String DB = "dbWeb2";
		final String URL = HOST+DB;
		final String username = "root";
		final String password = "root";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://"+URL+"?useTimezone=true&serverTimezone=UTC"+ "?user=" + username + "&password=" + password);
			st = con.createStatement();
			rs = st.executeQuery("show databases");
			while (rs.next()) {
				int i = 1;
				System.out.println(rs.getString(i));
				i++;
			}

			String[] createDBaux = createDB.split(";");
			// String[] insertDBaux = insertDB.split(";");
			// System.out.println(Arrays.toString(createDBaux));

			for (int i = 0; i < createDBaux.length; i++) {
				st.executeUpdate(createDBaux[i] + ";  ");
				// st.executeUpdate(insertDBaux[i] + "; ");
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}
