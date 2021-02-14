package com.plateer.homemarket.store.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.plateer.homemarket.entity.enumType.Role;
import com.plateer.homemarket.util.JsonUtil;

public class RoleTypeHandler extends BaseTypeHandler<List<Role>>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<Role> parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		String roleJson = JsonUtil.toJson(parameter);
		ps.setString(i, roleJson);
		
	}

	@Override
	public List<Role> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		String roleJson = rs.getString(columnName);
		
		return Optional.ofNullable(roleJson)
				.map(json -> JsonUtil.fromJsonList(roleJson, Role.class))
				.orElse(new ArrayList<>());
	}

	@Override
	public List<Role> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String roleJson = rs.getString(columnIndex);
		
		return Optional.ofNullable(roleJson)
				.map(json -> JsonUtil.fromJsonList(roleJson, Role.class))
				.orElse(new ArrayList<>());
	}

	@Override
	public List<Role> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String roleJson = cs.getString(columnIndex);
		
		return Optional.ofNullable(roleJson)
				.map(json -> JsonUtil.fromJsonList(roleJson, Role.class))
				.orElse(new ArrayList<>());
	}

}
