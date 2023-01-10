package net.wanho.util;

import java.sql.ResultSet;

public interface RowMapper<T> {

	public T rowMap(ResultSet rs);
}
