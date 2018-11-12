package com.suam.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import com.suam.factory.ConnectionFactory;

public class DataUtils {

	// formatar datas
	public static SimpleDateFormat formatarData() {
		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");
		return formato;
	}

	public static String gravarDataEHoraAtualBD() throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		// PEGANDO A DATA ATUAL NO SERVER DB:::
		String agora = null;
		Statement statement = conexao.createStatement();
		try {
			statement.execute("SELECT DATE_FORMAT(now(), '%y-%m-%d %H:%i:%s')as 'agora'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = statement.getResultSet();
		try {
			while (rs.next()) {
				agora = rs.getString("agora");
				System.out.println("Hora Atual: " + rs.getString("agora"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//conexao.close();
		return agora;
	}

	public static String dataAtualSistema() {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyy");
		String hojeFormatado = hoje.format(formatador);
		System.out.println("LocalDateTime depois de formatar: " + hojeFormatado);
		return hojeFormatado;
	}

	public static String dataEhoraAtualSistema() {
		// Obt�m LocalDateTime de agora
		LocalDateTime agora = LocalDateTime.now();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
		java.util.Date date = null;
		try {
			date = formato.parse(agora.format(formatador).toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("====>>" + date);
		return date.toString();
	}

	public static void dataFormato() {
		// cria��o de datas com a nova classe LocalDate e
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
		System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
		System.out.println("Mes: " + localDate.getMonthValue());
		System.out.println("Mes: " + localDate.getMonth().name());
		System.out.println("Ano: " + localDate.getYear());
	}

	public static long comparaInstantesDiferentes() {
		// compara��o entre diferentes instantes de tempo
		Instant iInicial = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant iFinal = Instant.now();

		Duration duracao = Duration.between(iInicial, iFinal);
		System.out.println("Dura��o em nanos segundos: " + duracao.toNanos());
		System.out.println("Dura��o em minutos: " + duracao.toMinutes());
		System.out.println("Dura��o em horas: " + duracao.toHours());
		System.out.println("Dura��o em milisegundos: " + duracao.toMillis());
		System.out.println("Dura��o em dias: " + duracao.toDays());

		return duracao.toMillis();
	}

	public static void comparaDatas() {
		// compara��o de datas (antes, depois, per�odo entre duas datas)
		LocalDate localDateAntigo = LocalDate.of(2010, 3, 7);
		LocalDate localDateNovo = LocalDate.of(2015, 3, 5);

		System.out.println(localDateAntigo.isAfter(localDateNovo));
		System.out.println(localDateAntigo.isBefore(localDateNovo));
		System.out.println(localDateAntigo.isEqual(localDateNovo));

		Period periodo = Period.between(localDateAntigo, localDateNovo);
		System.out
				.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
		System.out.println("Apenas meses: " + periodo.toTotalMonths());
	}

	public static void operacaoComData() {
		// opera��es em datas como adi��o e subtra��o de dias, meses e anos
		LocalDate dataManipulacao = LocalDate.now();
		System.out.println("Data Original: " + dataManipulacao);

		System.out.println("Mais 5 dias: " + dataManipulacao.plusDays(5));
		System.out.println("Mais 5 semanas: " + dataManipulacao.plusWeeks(5));
		System.out.println("Mais 5 anos: " + dataManipulacao.plusYears(5));
		System.out.println("Mais 2 meses: " + dataManipulacao.plusMonths(2));
		System.out.println("Menos 1 ano: " + dataManipulacao.minusYears(1));
		System.out.println("Menos 1 m�s: " + dataManipulacao.minusMonths(1));
		System.out.println("Menos 3 dia: " + dataManipulacao.minusDays(3));

		// classe LocalDate � imut�vel
		System.out.println("Data Original: " + dataManipulacao);
	}

	public static void formataDataNovaAPI() {
		// formata��o de datas com a nova API
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatadorTraco = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		System.out.println("Data com /: " + hoje.format(formatadorBarra));
		System.out.println("Data com -: " + hoje.format(formatadorTraco));
	}

	public static void utils() {
		LocalDate data = LocalDate.now();
		System.out.println("Ano bissexto: " + data.isLeapYear());
		System.out.println("N�mero de dias do m�s: " + data.lengthOfMonth());
		System.out.println("N�mero de dias do ano: " + data.lengthOfYear());
		System.out.println("Menor data: " + LocalDate.MIN);
		System.out.println("Maior data: " + LocalDate.MAX);
	}

	public static void obtemLocalDate() {
		// Obt�m LocalDate de hoje
		LocalDate hoje2 = LocalDate.now();
		System.out.println("LocalDate antes de formatar: " + hoje2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String hojeFormatado = hoje2.format(formatter);
		System.out.println("LocalDate depois de formatar: " + hojeFormatado);
	}

	public static void obtemLocalDateTime() {
		// Obt�m LocalDate de hoje
		LocalDateTime agora = LocalDateTime.now();
		System.out.println("LocalDateTime antes de formatar: " + agora);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String agoraFormatado = agora.format(formatter);
		System.out.println("LocalDateTime depois de formatar: " + agoraFormatado);
	}

	// TESTES
	public static void main(String[] args) {
		obtemLocalDateTime();
	}

}