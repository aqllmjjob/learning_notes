package com.history;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {
private static Map<String , Book> books = new HashMap<String, Book>();
static {
	books.put("1",new Book("1", "��ƿ÷", "��20", "������") );
	books.put("2",new Book("2", "��������", "��38", "�����") );
	books.put("3",new Book("3", "��������", "��89", "���") );
	books.put("4",new Book("4", "��Ů�ľ�", "��45", "��־��") );
}
//�õ�����ͼ����б�
public static Map<String , Book>findallBooks(){
	return books;
}
//����idֵ����ָ������
public static Book findbBookById(String id)
{
	return books.get(id);
}
}
