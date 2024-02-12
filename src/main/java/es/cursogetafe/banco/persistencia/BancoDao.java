package es.cursogetafe.banco.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class BancoDao implements BancoDaoInterface {
	private DataSource dataSource;

	public BancoDao() {
//		this.dataSource = MyDataSource.getDataSource();
//		esta dependencia la inyectamos a traves de Spring
	}

	public void cambiarSaldo(long id, double incrementoSaldo) {
		String sql = "update clientes set saldo = saldo + " + incrementoSaldo
				+ " where id = " + id;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			int n = con.createStatement().executeUpdate(sql);
			if (n == 1) {
				System.out.println("Se ha incrementado el saldo de " + id
						+ " en " + incrementoSaldo + " euros");
			} else {
				System.out.println("No existe el cliente con el " + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}