package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;

public class DTOColumnasTablaBandeja implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9099676334706527614L;

	
	String title;
	
	String dataIndex;
	
	String key;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
