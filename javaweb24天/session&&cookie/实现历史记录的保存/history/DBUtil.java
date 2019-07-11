package com.history;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {
private static Map<String , Book> books = new HashMap<String, Book>();
static {
	books.put("1",new Book("1", "金瓶梅", "￥20", "王瑞新") );
	books.put("2",new Book("2", "葵花宝典", "￥38", "杨成义") );
	books.put("3",new Book("3", "九阳正经", "￥89", "杨光") );
	books.put("4",new Book("4", "玉女心经", "￥45", "陈志家") );
}
//得到所有图书的列表
public static Map<String , Book>findallBooks(){
	return books;
}
//根据id值查找指定的书
public static Book findbBookById(String id)
{
	return books.get(id);
}
}
