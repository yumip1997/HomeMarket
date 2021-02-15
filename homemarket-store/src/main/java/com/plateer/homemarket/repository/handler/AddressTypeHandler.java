package com.plateer.homemarket.repository.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.plateer.homemarket.entity.Address;
import com.plateer.homemarket.util.JsonUtil;

public class AddressTypeHandler extends BaseTypeHandler<List<Address>>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<Address> parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		String addressJson = JsonUtil.toJson(parameter);
		ps.setString(i, addressJson);
	}

	@Override
	public List<Address> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		String addressJson = rs.getString(columnName);
		
		return Optional.ofNullable(addressJson)
				.map(json -> JsonUtil.fromJsonList(addressJson, Address.class))
				.orElse(new ArrayList<>());
	}

	@Override
	public List<Address> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String addressJson = rs.getString(columnIndex);
		
		return Optional.ofNullable(addressJson)
				.map(json -> JsonUtil.fromJsonList(addressJson, Address.class))
				.orElse(new ArrayList<>());
	}

	@Override
	public List<Address> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String addressJson = cs.getString(columnIndex);
		
		return Optional.ofNullable(addressJson)
				.map(json -> JsonUtil.fromJsonList(addressJson, Address.class))
				.orElse(new ArrayList<>());
	}

}
