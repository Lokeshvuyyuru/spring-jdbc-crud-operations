package com.vuyu;

import java.util.List;
import java.util.Map;

public interface ItemDAO {
	public void insertItem(int iid, String iname, float iprice);
	public List <Map<String,Object>>displayItems();
	public void updateItem(int iid, float iprice);
	public void deleteItem(int iid);
}

