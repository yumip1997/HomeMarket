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

import com.plateer.homemarket.util.JsonUtil;

public class RolesTypeHandler extends BaseTypeHandler<List<String>>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		String rolesJson = JsonUtil.toJson(parameter);
        ps.setString(i, rolesJson);
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
        String rolesJson = rs.getString(columnName);
        return Optional.ofNullable(rolesJson)
        .map(json -> JsonUtil.fromJsonList(rolesJson, String.class))
        .orElse(new ArrayList<>());
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
        String rolesJson = rs.getString(columnIndex);
        return Optional.ofNullable(rolesJson)
        .map(json -> JsonUtil.fromJsonList(rolesJson, String.class))
        .orElse(new ArrayList<>());
	}

	@Override
	public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
        String rolesJson = cs.getString(columnIndex);
        return Optional.ofNullable(rolesJson)
        .map(json -> JsonUtil.fromJsonList(rolesJson, String.class))
        .orElse(new ArrayList<>());
	}

}
