package com.vuyu;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class ItemDAOImpl implements ItemDAO{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertItem(int iid, String iname, float iprice) {
		String query ="Insert into items values(?,?,?)";
		jdbcTemplate.update(query,iid,iname,iprice);System.out.println("1 Record inserted successfully\n");
	}

	@Override
	public List<Map<String, Object>> displayItems() {
		String query = "Select * from items";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public void updateItem(int iid, float iprice) {
		String query = "update items set iprice =?where iid=?";
		jdbcTemplate.update(query,iprice,iid);
		System.out.println("1 Record modified successful\n");
	}

	@Override
	public void deleteItem(int iid) {
		String query = "DELETE FROM items WHERE iid = ?";
        jdbcTemplate.update(query, iid);
        System.out.println("Record deleted successfully");
	}
	
	

}
