package jp.co.ycode.webapp.util;

import javax.persistence.Column;

public class AnnotationAccessUtilBean {
	public String getColumnLength(Class<?> cls, String fieldName) throws NoSuchFieldException, SecurityException
	{
		return String.valueOf(cls.getDeclaredField(fieldName).getAnnotation(Column.class).length());
	}
}
