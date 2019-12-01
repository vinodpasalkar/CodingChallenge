package net.webtestautomation.requests;

import java.util.List;

public class CityDataResponse{
	private List<ItemsItem> items;

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"items = '" + items + '\'' + 
			"}";
		}
}