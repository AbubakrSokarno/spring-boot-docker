package com.flairstech.task.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.flairstech.task.DTO.CityCountryLangDTO;
import com.flairstech.task.world.DatabaseConnection;

@Repository
@Transactional
public class CityCountryLangRepositoryImpl implements CityCountryLangRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<CityCountryLangDTO> findCitiesByCountryCode(String CountryCode) {

		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
		    conn.getConnection().setAutoCommit(false);
		    Statement st = conn.getConnection().createStatement();
		    
		    String sql = conn.getConnection().nativeSQL(
					"SELECT country.name, country.continent , country.population, country.life_expectancy,country_language.language "
							+ "FROM city " + "JOIN country ON city.country_code = country.code "
							+ "JOIN country_language ON country_language.country_code = city.country_code WHERE city.country_code = '"+CountryCode+"'");
		    
		    ResultSet rs = st.executeQuery(sql);

			List<CityCountryLangDTO> result = new ArrayList<CityCountryLangDTO>();

			while (rs.next()) {
				CityCountryLangDTO item = new CityCountryLangDTO(rs.getString("name"), rs.getString("continent"), rs.getLong("population"),
						rs.getFloat("life_expectancy"), rs.getString("language"));
				result.add(item);
			}

			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
